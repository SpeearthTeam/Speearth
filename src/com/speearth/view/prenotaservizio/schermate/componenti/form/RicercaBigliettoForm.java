package com.speearth.view.prenotaservizio.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe che gestisce la Form di ricerca di Biglietti
 */
public class RicercaBigliettoForm extends FormView {
	@FXML
	private TextField input_partenza;
	@FXML
	private TextField input_destinazione;
	@FXML
	private DatePicker input_data_andata;
	@FXML
	private DatePicker input_data_ritorno;
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

	/**
	 * ObservableList di Biglietti da incorporare nella Listview
	 */
	private ObservableList<Biglietto> biglietti = FXCollections.observableArrayList();

	/**
	 * Lista dei risultati della Ricerca
	 */
	private ListView<Biglietto> list_view = null;

	private void impostaParametri() {
		// ottengo i parametri di ricerca dal controller
		HashMap<String, String> parametri = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getParametri();

		if (!parametri.isEmpty()) {
			String partenza = parametri.get("partenza");
			this.input_partenza.setText(partenza);

			String destinazione = parametri.get("destinazione");
			this.input_destinazione.setText(destinazione);

			String data_andata = parametri.get("data_andata");
			LocalDateTime local_date_time_andata = LocalDateTime.parse(data_andata, DateTimeFormatter.ISO_DATE_TIME);
			LocalDate local_date_andata = local_date_time_andata.toLocalDate();
			this.input_data_andata.setValue(local_date_andata);

			LocalTime local_time_andata = local_date_time_andata.toLocalTime();
			int index_ora_andata = local_time_andata.getHour();
			this.input_ora_andata.getSelectionModel().select(index_ora_andata);

			String data_ritorno = parametri.get("data_ritorno");
			if (data_ritorno != null) {
				LocalDateTime local_date_time_ritorno = LocalDateTime.parse(data_ritorno,
						DateTimeFormatter.ISO_DATE_TIME);
				LocalDate local_date_ritorno = local_date_time_ritorno.toLocalDate();
				this.input_data_ritorno.setValue(local_date_ritorno);

				LocalTime local_time_ritorno = local_date_time_ritorno.toLocalTime();
				int index_ora_ritorno = local_time_ritorno.getHour();
				this.input_ora_ritorno.getSelectionModel().select(index_ora_ritorno);
			}

			int index_adulti = Integer.parseInt(parametri.get("numero_adulti")) - 1;
			this.input_adulti.getSelectionModel().select(index_adulti);

			int index_bambini = Integer.parseInt(parametri.get("numero_bambini"));
			this.input_bambini.getSelectionModel().select(index_bambini);

			// int index_mezzo = Integer.parseInt(parametri.get("mezzo"));
			// this.input_mezzo.getSelectionModel().select(index_mezzo);

		}

	}

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaBigliettoForm(Stage stage) throws IOException {
		super(stage);
		impostaParametri();
	}

	/**
	 * Inizializza la SubView
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.input_ora_andata.setItems(FXCollections.observableArrayList(Costanti.LISTA_ORE));
		this.input_ora_ritorno.setItems(FXCollections.observableArrayList(Costanti.LISTA_ORE));
		this.input_adulti.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_ADULTI));
		this.input_bambini.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_BAMBINI));
		this.input_mezzo.setItems(FXCollections.observableArrayList(Costanti.LISTA_MEZZI));
		this.input_adulti.getSelectionModel().select(0);
		this.input_bambini.getSelectionModel().select(0);
		this.input_mezzo.getSelectionModel().select(0);
	}

	/**
	 * Valida gli input della Form
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valida() {
		// Controllo del luogo di partenza
		if (this.input_partenza.getText() == null || this.input_partenza.getText().isEmpty()) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_PARTENZA);
		}
		// Controllo del luogo di destinazione
		if (this.input_destinazione.getText() == null || this.input_destinazione.getText().isEmpty()) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_DESTINAZIONE);
		}
		// Controllo del mezzo
		if (this.input_mezzo.getValue() == null) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_MEZZO);
		}
		// Controllo della data di andata
		LocalDate local_date_andata = this.input_data_andata.getValue();
		if (local_date_andata == null) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_DATA_ANDATA);
		}
		if (local_date_andata.isBefore(LocalDate.now())) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DATA_PARTENZA_NON_VALIDA);
		}
		// Controllo della data di ritorno
		LocalDate local_date_ritorno = this.input_data_ritorno.getValue();
		if (local_date_ritorno != null
				&& (local_date_ritorno.isBefore(local_date_andata) || local_date_ritorno.isEqual(local_date_andata))) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DATA_RITORNO_NON_VALIDA);
		}
		return true;
	}

	/**
	 * Resituisce i parametri della Form
	 * 
	 * @return HashMap<String, String>
	 */
	@Override
	public HashMap<String, String> getParametri() {
		// Calcolo della data di andata
		int hour = 0;
		LocalDate local_date_andata = this.input_data_andata.getValue();
		hour = (this.input_ora_andata.getValue() != null) ? Integer.parseInt(this.input_ora_andata.getValue()) : 0;
		LocalDateTime local_date_time_andata = local_date_andata.atTime(hour, 0, 0);
		String data_andata = local_date_time_andata.format(DateTimeFormatter.ISO_DATE_TIME);

		// Calcolo della data di ritorno
		String data_ritorno = null;
		LocalDate local_date_ritorno = this.input_data_ritorno.getValue();

		if (local_date_ritorno != null) {
			hour = (this.input_ora_ritorno.getValue() != null) ? Integer.parseInt(this.input_ora_ritorno.getValue())
					: 0;
			LocalDateTime local_date_time_ritorno = local_date_ritorno.atTime(hour, 0, 0);
			data_ritorno = local_date_time_ritorno.format(DateTimeFormatter.ISO_DATE_TIME);
		}

		// Calcolo numero adulti
		String numero_adulti = (this.input_adulti.getValue() != null) ? this.input_adulti.getValue() : "0";

		// Calcolo numero bambini
		String numero_bambini = (this.input_bambini.getValue() != null) ? this.input_bambini.getValue() : "0";

		// Costruzione dei parametri
		HashMap<String, String> parametri = new HashMap<String, String>();
		parametri.put("numero_adulti", numero_adulti);
		parametri.put("numero_bambini", numero_bambini);
		parametri.put("partenza", this.input_partenza.getText());
		parametri.put("destinazione", this.input_destinazione.getText());
		parametri.put("data_andata", data_andata);
		parametri.put("data_ritorno", data_ritorno);
		parametri.put("mezzo", this.input_mezzo.getValue());
		return parametri;
	}

	/**
	 * Invia la richiesta
	 * 
	 * @param parameters
	 * @throws IOException
	 */
	@Override
	public void invia(HashMap<String, String> parameters) throws IOException {
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().ricerca(parameters);
		this.biglietti.clear();
		this.biglietti.setAll(risultati);
		if (this.list_view != null) {
			this.list_view.setItems(this.biglietti);
		}
	}

	// Event Listener on Button[#bottone_cerca].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		try {
			this.valida();
			this.invia(getParametri());
		} catch (NullPointerException e) {
			e.printStackTrace();
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		} catch (IOException e) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE_HTTP, null, e.getMessage());
		} catch (InvalidParameterException e) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}

	/**
	 * Restituisce l'ObservableList di Alloggi
	 * 
	 * @return ObservableList<Alloggio>
	 */
	public ObservableList<Biglietto> getBiglietti() {
		return this.biglietti;
	}

	/**
	 * Lega la ListView al suo contenuto
	 * 
	 * @param view
	 */
	public void bind(ListView<Biglietto> view) {
		this.list_view = view;
		this.list_view.setItems(this.biglietti);
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RICERCA_BIGLIETTO_FORM;
	}
}
