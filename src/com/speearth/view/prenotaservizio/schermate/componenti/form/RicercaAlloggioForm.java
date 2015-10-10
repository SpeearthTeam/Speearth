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
import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
	
	private ObservableList<Alloggio> alloggi = FXCollections.observableArrayList();
	
	private ListView<Alloggio> list_view = null;

	public RicercaAlloggioForm(Stage stage) throws IOException {
		super(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.input_ora_arrivo.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
		this.input_ora_partenza.setItems(FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
				"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"));
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

	@Override
	public void validate() throws InvalidParameterException {
		// Controllo della zona
		if (input_localita.getText() == null || input_localita.getText().isEmpty()) {
			throw new InvalidParameterException("Definire la località");
		}

		// Controllo stanze
		if (!input_singola.isSelected() && !input_doppia.isSelected() && !input_tripla.isSelected()
				&& !input_quadrupla.isSelected()) {
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

		// Controllo e calcolo della data di partenza
		LocalDate local_date_partenza = input_data_partenza.getValue();

		if (local_date_partenza == null) {
			throw new InvalidParameterException("Definire la data di partenza");
		}

		// Controllo validità delle date
		if (local_date_arrivo.isAfter(local_date_partenza) || local_date_arrivo.isEqual(local_date_partenza)) {
			throw new InvalidParameterException("Definire una data di partenza corretta");
		}
	}

	@Override
	public HashMap<String, String> getParameters() {
		// Calcolo della data di arrivo
		int hour = 0;

		LocalDate local_date_arrivo = input_data_arrivo.getValue();
		hour = (input_ora_arrivo.getValue() != null) ? Integer.parseInt(input_ora_arrivo.getValue()) : 0;
		LocalDateTime local_date_time_arrivo = local_date_arrivo.atTime(hour, 0, 0);
		String data_arrivo = local_date_time_arrivo.format(DateTimeFormatter.ISO_DATE_TIME);

		// Calcolo della data di partenza
		LocalDate local_date_partenza = input_data_partenza.getValue();
		hour = (input_ora_partenza.getValue() != null) ? Integer.parseInt(input_ora_partenza.getValue()) : 0;
		LocalDateTime local_date_time_partenza = local_date_partenza.atTime(hour, 0, 0);
		String data_partenza = local_date_time_partenza.format(DateTimeFormatter.ISO_DATE_TIME);

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
	
	@Override
	public void send(HashMap<String, String> parameters) {
		ArrayList<Alloggio> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController().ricerca(parameters);
		this.alloggi.clear();
		this.alloggi.setAll(risultati);
		
		if (this.list_view != null) {
			this.list_view.setItems(this.alloggi);
		}
	}
	
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		try {
			validate();
			send(getParameters());
		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}
	
	public ObservableList<Alloggio> getAlloggi() {
		return alloggi;
	}
	
	public void bind(ListView<Alloggio> view) {
		this.list_view = view;
		this.list_view.setItems(this.alloggi);
	}

	@Override
	public void updateUI() {
		
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_ALLOGGIO_FORM;
	}

}
