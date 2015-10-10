package com.speearth.view.prenotaservizio.schermate;

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
import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;
import com.speearth.view.prenotaservizio.schermate.componenti.AlloggioListItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RicercaAlloggioView extends View {
	@FXML
	private TextField input_localita;
	@FXML
	private DatePicker input_data_arrivo;
	@FXML
	private DatePicker input_data_partenza;
	@FXML
	private Button ricerca_alloggi;
	@FXML
	private ChoiceBox<String> input_ora_arrivo;
	@FXML
	private ChoiceBox<String> input_ora_partenza;
	@FXML
	private CheckBox input_singola;
	@FXML
	private CheckBox input_doppia;
	@FXML
	private CheckBox input_tripla;
	@FXML
	private CheckBox input_quadrupla;
	@FXML
	private ChoiceBox<String> input_numero_singole;
	@FXML
	private ChoiceBox<String> input_numero_doppie;
	@FXML
	private ChoiceBox<String> input_numero_triple;
	@FXML
	private ChoiceBox<String> input_numero_quadruple;
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Alloggio> lista_risultati;

	private ObservableList<Alloggio> lista_alloggi = FXCollections.observableArrayList();

	/**
	 * Inizializza la view
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati.setCellFactory(param -> new AlloggioListItem(getStage()));
		this.lista_risultati.setItems(this.lista_alloggi);
		this.input_ora_arrivo.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_ora_partenza.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_numero_singole.setItems(FXCollections.observableArrayList("0", "1", "2"));
		this.input_numero_doppie.setItems(FXCollections.observableArrayList("0", "1", "2"));
		this.input_numero_triple.setItems(FXCollections.observableArrayList("0", "1", "2"));
		this.input_numero_quadruple.setItems(FXCollections.observableArrayList("0", "1", "2"));
		this.input_singola.setSelected(true);
		this.input_numero_singole.getSelectionModel().select(1);
		this.input_numero_doppie.getSelectionModel().select(0);
		this.input_numero_triple.getSelectionModel().select(0);
		this.input_numero_quadruple.getSelectionModel().select(0);
	}
	
	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDati() throws NullPointerException {
		int hour = 0;
		
		// Controllo della zona
		if (input_localita.getText() == null || input_localita.getText().isEmpty()) {
			throw new InvalidParameterException("Definire la località");
		}
		
		// Controllo stanze
		if (!input_singola.isSelected() && !input_doppia.isSelected() && !input_tripla.isSelected() && !input_quadrupla.isSelected()) {
			throw new InvalidParameterException("Scegliere almeno una stanza");
		}
		
		// Controllo singola
		if (input_singola.isSelected() && input_numero_singole.getValue().equals("0")) {
			throw new InvalidParameterException("Selezionare almeno una singola");
		}
		
		// Controllo doppia
		if (input_doppia.isSelected() && input_numero_doppie.getValue().equals("0")) {
			throw new InvalidParameterException("Selezionare almeno una doppia");
		}
		
		// Controllo tripla
		if (input_tripla.isSelected() && input_numero_triple.getValue().equals("0")) {
			throw new InvalidParameterException("Selezionare almeno una tripla");
		}
		
		// Controllo quadrupla
		if (input_quadrupla.isSelected() && input_numero_quadruple.getValue().equals("0")) {
			throw new InvalidParameterException("Selezionare almeno una quadrupla");
		}
				
		
		// Controllo e calcolo della data di arrivo
		LocalDate local_date_arrivo = input_data_arrivo.getValue();
		
		if (local_date_arrivo == null) {
			throw new InvalidParameterException("Definire la data di arrivo");
		}
		
		hour = (input_ora_arrivo.getValue() != null) ? Integer.parseInt(input_ora_arrivo.getValue()) : 0;
		LocalDateTime local_date_time_arrivo = local_date_arrivo.atTime(hour, 0, 0);
		String data_arrivo = local_date_time_arrivo.format(DateTimeFormatter.ISO_DATE_TIME);
		
		// Controllo e calcolo della data di partenza
		LocalDate local_date_partenza = input_data_partenza.getValue();
		
		if (local_date_partenza == null) {
			throw new InvalidParameterException("Definire la data di partenza");
		}
		
		hour = (input_ora_partenza.getValue() != null) ? Integer.parseInt(input_ora_partenza.getValue()) : 0;
		LocalDateTime local_date_time_partenza = local_date_partenza.atTime(hour, 0, 0);
		String data_partenza = local_date_time_partenza.format(DateTimeFormatter.ISO_DATE_TIME);
		
		// Controllo validità delle date
		if (local_date_time_arrivo.isAfter(local_date_time_partenza) || local_date_time_arrivo.isEqual(local_date_time_partenza))
			throw new InvalidParameterException("Definire una data di partenza corretta"); 
		
		
		// Costruisco i parametri
		HashMap<String, String> parametri = new HashMap<String, String>();

		parametri.put("data_arrivo", data_arrivo);
		parametri.put("data_partenza", data_partenza);
		parametri.put("zona", input_localita.getText());
		if (input_singola.isSelected()) {
			parametri.put("numero_singole", input_numero_singole.getValue());
		}
		if (input_doppia.isSelected()) {
			parametri.put("numero_doppie", input_numero_doppie.getValue());
		}
		if (input_tripla.isSelected()) {
			parametri.put("numero_triple", input_numero_triple.getValue());
		}
		if (input_quadrupla.isSelected()) {
			parametri.put("numero_quadruple", input_numero_quadruple.getValue());
		}

		return parametri;
	}

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaAlloggioView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_ALLOGGIO);
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
	
	// Event Listener on Button[#ricerca_alloggi].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDati();
			ArrayList<Alloggio> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
					.getPrenotaAlloggioController().ricerca(dati);
			this.lista_alloggi.clear();
			this.lista_alloggi.setAll(risultati);
			this.lista_risultati.setItems(lista_alloggi);

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
		if (this.lista_alloggi.isEmpty())
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
			RiepilogoAlloggioView view = new RiepilogoAlloggioView(getStage());
			view.setPreviousView(this);
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_ALLOGGIO;
	}
}
