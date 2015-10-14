package com.speearth.view.prenotaservizio.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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

	private ObservableList<Biglietto> biglietti = FXCollections.observableArrayList();

	private ListView<Biglietto> list_view = null;

	public RicercaBigliettoForm(Stage stage) throws IOException {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.input_ora_andata.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_ora_ritorno.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
				"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_adulti.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
		this.input_bambini.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4"));
		this.input_mezzo.setItems(FXCollections.observableArrayList("treno", "aereo"));
		this.input_adulti.getSelectionModel().select(0);
		this.input_bambini.getSelectionModel().select(0);
		this.input_mezzo.getSelectionModel().select(0);
	}

	@Override
	public void validate() {

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

		// Controllo della data di andata
		LocalDate local_date_andata = input_data_andata.getValue();

		if (local_date_andata == null) {
			throw new InvalidParameterException("Definire la data di partenza");
		}

		if (local_date_andata.isBefore(LocalDate.now())) {
			throw new InvalidParameterException("Definire una data di partenza corretta");
		}

		// Controllo della data di ritorno
		LocalDate local_date_ritorno = input_data_ritorno.getValue();

		if (local_date_ritorno != null
				&& (local_date_ritorno.isBefore(local_date_andata) || local_date_ritorno.isEqual(local_date_andata))) {
			throw new InvalidParameterException("Definire una data di ritorno valida");
		}
	}

	@Override
	public HashMap<String, String> getParameters() {
		// Calcolo della data di andata
		int hour = 0;
		LocalDate local_date_andata = input_data_andata.getValue();
		hour = (input_ora_andata.getValue() != null) ? Integer.parseInt(input_ora_andata.getValue()) : 0;
		LocalDateTime local_date_time_andata = local_date_andata.atTime(hour, 0, 0);
		String data_andata = local_date_time_andata.format(DateTimeFormatter.ISO_DATE_TIME);

		// Calcolo della data di ritorno
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

	@Override
	public void send(HashMap<String, String> parameters) throws IOException {
		// ottengo i biglietti dal controller
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		// se il risultato non contiene biglietti, allora effettuo la ricerca
		if (risultati == null || risultati.isEmpty()) {
			risultati = AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
					.ricerca(parameters);
		}
		// altrimenti ho ottenuto i biglietti da una ricerca precedente e procedo
//		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
//				.ricerca(parameters);
		this.biglietti.clear();
		this.biglietti.setAll(risultati);

		if (this.list_view != null) {
			this.list_view.setItems(this.biglietti);
		}
	}

	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		try {
			validate();
			send(getParameters());
		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		} catch (IOException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE_HTTP, null, e.getMessage());
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}

	public ObservableList<Biglietto> getBiglietti() {
		return biglietti;
	}

	public void bind(ListView<Biglietto> view) {
		this.list_view = view;
		this.list_view.setItems(this.biglietti);
	}

	@Override
	public void updateUI() {

	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_BIGLIETTO_FORM;
	}

}
