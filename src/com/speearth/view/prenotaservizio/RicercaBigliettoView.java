package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.events.EventoSelezionaServizio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RicercaBigliettoView extends View {
	@FXML
	private TextField input_partenza;
	@FXML
	private TextField input_destinazione;
	@FXML
	private DatePicker input_data_andata;
	@FXML
	private DatePicker input_data_ritorno;
	@FXML
	private Button ricerca_biglietti;
	@FXML
	private ChoiceBox<String> input_mezzo;
	@FXML
	private ChoiceBox<String> input_bambini;
	@FXML
	private ChoiceBox<String> input_adulti;
	@FXML
	private ChoiceBox<String> input_ora_ritorno;
	@FXML
	private ChoiceBox<String> input_ora_andata;
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Biglietto> lista_risultati;

	/**
	 * Lista di Biglietti che va a riempire lista_risultati
	 */
	private ObservableList<Biglietto> lista_biglietti = FXCollections.observableArrayList();

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati.setCellFactory(param -> new BigliettoItemList(getStage()));
		this.lista_risultati.setItems(this.lista_biglietti);
		this.input_ora_andata.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_ora_ritorno.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_adulti.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
		this.input_bambini.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4"));
		this.input_mezzo.setItems(FXCollections.observableArrayList("treno", "aereo"));
		this.input_adulti.getSelectionModel().select(0);
		this.input_bambini.getSelectionModel().select(0);
		this.input_mezzo.getSelectionModel().select(0);
	}
	
	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDati() throws InvalidParameterException {
		int hour = 0;
		
		// Controllo del luogo di partenza
		if (input_partenza.getText() == null || input_partenza.getText().isEmpty()) {
			throw new InvalidParameterException("Definire il luogo di partenza");
		}
		
		// Controllo del luogo di destinazione
		if (input_destinazione.getText() == null || input_destinazione.getText().isEmpty()) {
			throw new InvalidParameterException("Definire il luogo di destinazione");
		}
		
		// Controllo del mezzo
		if (input_mezzo.getValue() == null) {
			throw new InvalidParameterException("Definire il mezzo di trasporto");
		}

		// Controllo e calcolo della data di andata
		LocalDate local_date_andata = input_data_andata.getValue();
		
		if (local_date_andata == null) {
			throw new InvalidParameterException("Definire la data di partenza");
		}
		
		hour = (input_ora_andata.getValue() != null) ? Integer.parseInt(input_ora_andata.getValue()) : 0;
		LocalDateTime local_date_time_andata = local_date_andata.atTime(hour, 0, 0);
		String data_andata = local_date_time_andata.format(DateTimeFormatter.ISO_DATE_TIME);
		
		// Controllo e calcolo della data di ritorno
		String data_ritorno = null;
		LocalDate local_date_ritorno = input_data_ritorno.getValue();
		
		if (local_date_ritorno != null) {
			hour = (input_ora_ritorno.getValue() != null) ? Integer.parseInt(input_ora_ritorno.getValue()) : 0;
			LocalDateTime local_date_time_ritorno = local_date_ritorno.atTime(hour, 0, 0);
			data_ritorno = local_date_time_ritorno.format(DateTimeFormatter.ISO_DATE_TIME);
		}
		
		// Calcolo numero adulti
		String numero_adulti = (input_adulti.getValue() != null) ? input_adulti.getValue() : "0";
		
		// Calcolo numero bambini
		String numero_bambini = (input_bambini.getValue() != null) ? input_bambini.getValue() : "0";
		
		
		// Costruzione dei parametri
		HashMap<String, String> parametri = new HashMap<String, String>();
		parametri.put("numero_adulti", numero_adulti);
		parametri.put("numero_bambini", numero_bambini);
		parametri.put("partenza", input_partenza.getText());
		parametri.put("destinazione", input_destinazione.getText());
		parametri.put("data_andata", data_andata);
		parametri.put("data_ritorno", data_ritorno);
		parametri.put("mezzo", input_mezzo.getValue());
		return parametri;
	}

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaBigliettoView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_BIGLIETTO);
		getParentNode().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO, new EventHandler<EventoSelezionaServizio>() {

			@Override
			public void handle(EventoSelezionaServizio event) {
				try {
					AppFacadeController.getInstance().getPrenotaServizioController()
							.setServizio(event.getServizio());
					vaiARiepilogo();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Event Listener on Button[#ricerca_biglietti].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDati();
			ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
					.getPrenotaBigliettoController().ricerca(dati);

			this.lista_biglietti.clear();
			this.lista_biglietti.setAll(risultati);
			this.lista_risultati.setItems(this.lista_biglietti);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		if (this.lista_biglietti.isEmpty())
			mostraPrecedente();
		else {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
					null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
				mostraPrecedente();
			}
		}
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogoButtonClick(ActionEvent event) throws IOException {
		vaiARiepilogo();
	}

	/**
	 * Ridirige l'utente al riepilogo
	 * 
	 * @throws IOException
	 */
	public void vaiARiepilogo() throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null)
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoBigliettoView view = new RiepilogoBigliettoView(getStage());
			view.setPreviousView(this);
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_BIGLIETTO;
	}
}
