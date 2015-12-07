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
import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe che gestisce la Form di ricerca di Alloggi
 */
public class RicercaAlloggioForm extends FormView {
	@FXML
	private TextField input_localita;
	@FXML
	private DatePicker input_data_arrivo;
	@FXML
	private DatePicker input_data_partenza;
	@FXML
	private CheckBox input_singola;
	@FXML
	private CheckBox input_doppia;
	@FXML
	private CheckBox input_tripla;
	@FXML
	private CheckBox input_quadrupla;
	@FXML
	private ChoiceBox<String> input_ora_arrivo;
	@FXML
	private ChoiceBox<String> input_ora_partenza;
	@FXML
	private ChoiceBox<String> input_numero_singole;
	@FXML
	private ChoiceBox<String> input_numero_doppie;
	@FXML
	private ChoiceBox<String> input_numero_triple;
	@FXML
	private ChoiceBox<String> input_numero_quadruple;

	/**
	 * ObservableList di Alloggi da incorporare nella Listview
	 */
	private ObservableList<Alloggio> alloggi = FXCollections.observableArrayList();

	/**
	 * Lista dei risultati della Ricerca
	 */
	private ListView<Alloggio> list_view = null;

	/**
	 * Carica gli Alloggi salvati nel Controller all'interno View per evitarne
	 * la perdita durante un cambio di Schermata
	 */
	private void impostaParametri() {
		// ottengo i parametri di ricerca dal controller
		HashMap<String, String> parametri = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController().getParametri();

		// se i parametri non sono vuoti, allora li imposto nella view
		if (!parametri.isEmpty()) {
			String input_localita = parametri.get("zona");
			this.input_localita.setText(input_localita);

			String data_arrivo = parametri.get("data_arrivo");
			LocalDateTime local_date_time_arrivo = LocalDateTime.parse(data_arrivo, DateTimeFormatter.ISO_DATE_TIME);
			LocalDate local_date_arrivo = local_date_time_arrivo.toLocalDate();
			this.input_data_arrivo.setValue(local_date_arrivo);

			String data_partenza = parametri.get("data_partenza");
			LocalDateTime local_date_time_partenza = LocalDateTime.parse(data_partenza,
					DateTimeFormatter.ISO_DATE_TIME);
			LocalDate local_date_partenza = local_date_time_partenza.toLocalDate();
			this.input_data_partenza.setValue(local_date_partenza);

			LocalTime local_time_arrivo = local_date_time_arrivo.toLocalTime();
			int index_ora_arrivo = local_time_arrivo.getHour();
			this.input_ora_arrivo.getSelectionModel().select(index_ora_arrivo);

			LocalTime local_time_partenza = local_date_time_partenza.toLocalTime();
			int index_ora_partenza = local_time_partenza.getHour();
			this.input_ora_partenza.getSelectionModel().select(index_ora_partenza);

			String numero_singole = parametri.get("numero_singole");
			if (numero_singole != null) {
				this.input_singola.setSelected(true);
				int index = this.input_numero_singole.getItems().indexOf(numero_singole);
				this.input_numero_singole.getSelectionModel().select(index);
			}

			String numero_doppie = parametri.get("numero_doppie");
			if (numero_doppie != null) {
				this.input_doppia.setSelected(true);
				int index = this.input_numero_doppie.getItems().indexOf(numero_doppie);
				this.input_numero_doppie.getSelectionModel().select(index);
			}

			String numero_triple = parametri.get("numero_triple");
			if (numero_triple != null) {
				this.input_tripla.setSelected(true);
				int index = this.input_numero_triple.getItems().indexOf(numero_triple);
				this.input_numero_triple.getSelectionModel().select(index);
			}

			String numero_quadruple = parametri.get("numero_quadruple");
			if (numero_quadruple != null) {
				this.input_quadrupla.setSelected(true);
				int index = this.input_numero_quadruple.getItems().indexOf(numero_quadruple);
				this.input_numero_quadruple.getSelectionModel().select(index);
			}

		}
	}

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaAlloggioForm(Stage stage) throws IOException {
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
		this.input_ora_arrivo.setItems(FXCollections.observableArrayList(Costanti.LISTA_ORE));
		this.input_ora_partenza.setItems(FXCollections.observableArrayList(Costanti.LISTA_ORE));
		this.input_numero_singole.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_STANZE));
		this.input_numero_doppie.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_STANZE));
		this.input_numero_triple.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_STANZE));
		this.input_numero_quadruple.setItems(FXCollections.observableArrayList(Costanti.LISTA_NUMERO_STANZE));
		this.input_singola.setSelected(true);
		this.input_numero_singole.getSelectionModel().select(1);
		this.input_numero_doppie.getSelectionModel().select(0);
		this.input_numero_triple.getSelectionModel().select(0);
		this.input_numero_quadruple.getSelectionModel().select(0);
	}

	/**
	 * Valida gli input della Form
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valida() throws InvalidParameterException {
		// Controllo della località
		if (this.input_localita.getText() == null || this.input_localita.getText().isEmpty()) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_LOCALITA);
		}
		// Controllo stanze
		if (!this.input_singola.isSelected() && !this.input_doppia.isSelected() && !this.input_tripla.isSelected()
				&& !input_quadrupla.isSelected()) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_SCEGLIERE_STANZA);
		}
		// Controllo singola
		if (this.input_singola.isSelected() && this.input_numero_singole.getValue().equals("0")) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_SCEGLIERE_SINGOLA);
		}
		// Controllo doppia
		if (this.input_doppia.isSelected() && this.input_numero_doppie.getValue().equals("0")) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_SCEGLIERE_DOPPIA);
		}
		// Controllo tripla
		if (this.input_tripla.isSelected() && this.input_numero_triple.getValue().equals("0")) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_SCEGLIERE_TRIPLA);
		}
		// Controllo quadrupla
		if (this.input_quadrupla.isSelected() && this.input_numero_quadruple.getValue().equals("0")) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_SCEGLIERE_QUADRUPLA);
		}
		// Controllo e calcolo della data di arrivo
		LocalDate local_date_arrivo = this.input_data_arrivo.getValue();
		if (local_date_arrivo == null) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_DATA_ARRIVO);
		}
		// Controllo e calcolo della data di partenza
		LocalDate local_date_partenza = this.input_data_partenza.getValue();
		if (local_date_partenza == null) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DEFINIRE_DATA_PARTENZA);
		}
		// Controllo validità delle date
		if (local_date_arrivo.isAfter(local_date_partenza)) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DATA_PARTENZA_NON_VALIDA);
		}
		if (local_date_arrivo.isBefore(LocalDate.now())) {
			throw new InvalidParameterException(Costanti.MESSAGGIO_DATA_ARRIVO_NON_VALIDA);
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
		// Calcolo della data di arrivo
		int hour = 0;

		LocalDate local_date_arrivo = this.input_data_arrivo.getValue();
		hour = (this.input_ora_arrivo.getValue() != null) ? Integer.parseInt(this.input_ora_arrivo.getValue()) : 0;
		LocalDateTime local_date_time_arrivo = local_date_arrivo.atTime(hour, 0, 0);
		String data_arrivo = local_date_time_arrivo.format(DateTimeFormatter.ISO_DATE_TIME);

		// Calcolo della data di partenza
		LocalDate local_date_partenza = this.input_data_partenza.getValue();
		hour = (this.input_ora_partenza.getValue() != null) ? Integer.parseInt(this.input_ora_partenza.getValue()) : 0;
		LocalDateTime local_date_time_partenza = local_date_partenza.atTime(hour, 0, 0);
		String data_partenza = local_date_time_partenza.format(DateTimeFormatter.ISO_DATE_TIME);

		// Costruisco i parametri
		HashMap<String, String> parametri = new HashMap<String, String>();

		parametri.put("data_arrivo", data_arrivo);
		parametri.put("data_partenza", data_partenza);
		parametri.put("zona", this.input_localita.getText());
		if (this.input_singola.isSelected()) {
			parametri.put("numero_singole", this.input_numero_singole.getValue());
		}
		if (this.input_doppia.isSelected()) {
			parametri.put("numero_doppie", this.input_numero_doppie.getValue());
		}
		if (this.input_tripla.isSelected()) {
			parametri.put("numero_triple", this.input_numero_triple.getValue());
		}
		if (this.input_quadrupla.isSelected()) {
			parametri.put("numero_quadruple", this.input_numero_quadruple.getValue());
		}
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
		ArrayList<Alloggio> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController().ricerca(parameters);
		this.alloggi.clear();
		this.alloggi.setAll(risultati);
		if (this.list_view != null) {
			this.list_view.setItems(this.alloggi);
		}
	}

	// Event Listener on Button[#bottone_cerca].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		try {
			this.valida();
			this.invia(getParametri());
		} catch (NullPointerException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		} catch (IOException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE_HTTP, null, e.getMessage());
		}
	}

	/**
	 * Restituisce l'ObservableList di Alloggi
	 * 
	 * @return ObservableList<Alloggio>
	 */
	public ObservableList<Alloggio> getAlloggi() {
		return this.alloggi;
	}

	/**
	 * Lega la ListView al suo contenuto
	 * 
	 * @param view
	 */
	public void bind(ListView<Alloggio> view) {
		this.list_view = view;
		this.list_view.setItems(this.alloggi);
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
		return Costanti.FXML_RICERCA_ALLOGGIO_FORM;
	}
}
