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
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.core.PacchettoComposite;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;
import com.speearth.view.prenotaservizio.schermate.componenti.AlloggioListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.BigliettoListItem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RicercaPacchettoView extends View {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Button bottone_svuota;
	@FXML
	private Button bottone_conferma;
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
	private TextField input_localita;
	@FXML
	private DatePicker input_data_arrivo;
	@FXML
	private DatePicker input_data_partenza;
	@FXML
	private Button ricerca_alloggi;
	@FXML
	private ChoiceBox<String> input_numero_singole;
	@FXML
	private ChoiceBox<String> input_ora_partenza;
	@FXML
	private ChoiceBox<String> input_ora_arrivo;
	@FXML
	private CheckBox input_singola;
	@FXML
	private CheckBox input_doppia;
	@FXML
	private CheckBox input_tripla;
	@FXML
	private CheckBox input_quadrupla;
	@FXML
	private ChoiceBox<String> input_numero_doppie;
	@FXML
	private ChoiceBox<String> input_numero_triple;
	@FXML
	private ChoiceBox<String> input_numero_quadruple;
	@FXML
	private ListView<Biglietto> lista_risultati_biglietti;
	@FXML
	private ListView<Alloggio> lista_risultati_alloggi;
	@FXML
	private TableView<IServizioComponent> tabella_pacchetto;
	@FXML
	private TableColumn<IServizioComponent, String> tipo_servizio_col;
	@FXML
	private TableColumn<IServizioComponent, String> fornitore_servizio_col;
	@FXML
	private TableColumn<IServizioComponent, String> prezzo_servizio_col;

	private ObservableList<Biglietto> lista_biglietti = FXCollections.observableArrayList();

	private ObservableList<Alloggio> lista_alloggi = FXCollections.observableArrayList();

	private ObservableList<IServizioComponent> lista_servizi = FXCollections.observableArrayList();

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati_biglietti.setCellFactory(param -> new BigliettoListItem(getStage()));
		this.lista_risultati_biglietti.setItems(this.lista_biglietti);

		this.lista_risultati_alloggi.setCellFactory(param -> new AlloggioListItem(getStage()));
		this.lista_risultati_alloggi.setItems(this.lista_alloggi);

		// Biglietto form settings
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

		// Allogio form settings
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

	private TableColumn<IServizioComponent, Boolean> cancella_servizio_col = new TableColumn<>("Cancella");

	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca della tab
	 * Biglietti
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDatiBiglietti() {
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
	 * Recupera i dati inseriti dall'Utente nella form di ricerca della tab
	 * Alloggi
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDatiAlloggi() {
		int hour = 0;

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
		if (local_date_time_arrivo.isAfter(local_date_time_partenza)
				|| local_date_time_arrivo.isEqual(local_date_time_partenza))
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
	 * Costrutture di default
	 */
	public RicercaPacchettoView() {

	}

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaPacchettoView(Stage stage) throws IOException {
		super(stage);
		AppFacadeController.getInstance().getPrenotaServizioController().setServizio(new PacchettoComposite());
		getStage().setTitle(Costanti.TITOLO_PRENOTA_PACCHETTO);
		getParentNode().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO,
				new EventHandler<EventoSelezionaServizio>() {

					@Override
					public void handle(EventoSelezionaServizio event) {
						IServizioComponent servizio = event.getServizio();
						if (!lista_servizi.contains(servizio)) {
							lista_servizi.add(servizio);
							AppFacadeController.getInstance().getPrenotaServizioController().getServizio()
									.aggiungi(servizio);
						}
					}
				});

		initializeServiceTable();
	}

	/**
	 * Inizializza la tabella dei servizi scelti
	 */
	public void initializeServiceTable() {
		this.tipo_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<IServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<IServizioComponent, String> param) {
						IServizioComponent servizio = param.getValue();
						SimpleStringProperty tipo = null;

						if (servizio instanceof Alloggio)
							tipo = new SimpleStringProperty("Alloggio");
						else if (servizio instanceof Biglietto)
							tipo = new SimpleStringProperty("Biglietto");

						return tipo;
					}
				});

		this.fornitore_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<IServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<IServizioComponent, String> param) {
						IServizioComponent servizio = param.getValue();
						SimpleStringProperty fornitore = null;

						if (servizio instanceof Alloggio)
							fornitore = new SimpleStringProperty(((Alloggio) servizio).getFornitore());
						else if (servizio instanceof Biglietto)
							fornitore = new SimpleStringProperty(((Biglietto) servizio).getFornitore());

						return fornitore;
					}
				});

		this.prezzo_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<IServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<IServizioComponent, String> param) {
						IServizioComponent servizio = param.getValue();
						SimpleStringProperty prezzo = null;

						if (servizio instanceof Alloggio)
							prezzo = new SimpleStringProperty(Float.toString(((Alloggio) servizio).getPrezzo()));
						else if (servizio instanceof Biglietto)
							prezzo = new SimpleStringProperty(Float.toString(((Biglietto) servizio).getPrezzo()));

						return prezzo;
					}
				});

		// aggiungo la colonna per i pulsanti Cancella
		this.tabella_pacchetto.getColumns().add(this.cancella_servizio_col);
		// aggiungo il pulsante alla tabella
		this.cancella_servizio_col.setCellFactory(
				new Callback<TableColumn<IServizioComponent, Boolean>, TableCell<IServizioComponent, Boolean>>() {

					@Override
					public TableCell<IServizioComponent, Boolean> call(TableColumn<IServizioComponent, Boolean> p) {
						return new ButtonCell();
					}
				});

		this.lista_servizi.setAll(
				AppFacadeController.getInstance().getPrenotaServizioController().getServizio().getListaServizi());
		this.tabella_pacchetto.setItems(this.lista_servizi);
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		if (this.lista_biglietti.isEmpty() && this.lista_alloggi.isEmpty())
			mostraPrecedente();
		else {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
					null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK)
				mostraPrecedente();
		}
		AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio().getListaServizi().isEmpty())
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else if (!(AppFacadeController.getInstance().getPrenotaServizioController().getServizio().getListaServizi()
				.size() > 1))
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PACCHETTO_UN_ELEMENTO);
		else {
			RiepilogoPacchettoView view = new RiepilogoPacchettoView(getStage());
			view.setPreviousView(this);
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_svuota].onAction
	@FXML
	public void svuotaPacchetto(ActionEvent event) {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_SVUOTA_PACCHETTO, null,
				Costanti.MESSAGGIO_SVUOTA_PACCHETTO);
		if (result.get() == ButtonType.OK) {
			AppFacadeController.getInstance().getPrenotaServizioController().getServizio().getListaServizi().clear();
			this.lista_servizi.clear();
		}
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaPacchetto(ActionEvent event) throws IOException {
		vaiARiepilogo(event);
	}

	// Event Listener on Button[#ricerca_biglietti].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDatiBiglietti();
			ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
					.getPrenotaPacchettoController().getPrenotaBigliettoController().ricerca(dati);

			this.lista_biglietti.clear();
			this.lista_biglietti.setAll(risultati);
			this.lista_risultati_biglietti.setItems(this.lista_biglietti);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		}
	}

	// Event Listener on Button[#ricerca_alloggi].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDatiAlloggi();
			ArrayList<Alloggio> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
					.getPrenotaPacchettoController().getPrenotaAlloggioController().ricerca(dati);

			this.lista_alloggi.clear();
			this.lista_alloggi.setAll(risultati);
			this.lista_risultati_alloggi.setItems(lista_alloggi);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		}
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_PACCHETTO;
	}

	// Define the button cell
	private class ButtonCell extends TableCell<IServizioComponent, Boolean> {
		final Button cellButton = new Button("Cancella");

		ButtonCell() {

			// Action when the button is pressed
			cellButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					// get Selected Item
					IServizioComponent servizio = ButtonCell.this.getTableView().getItems()
							.get(ButtonCell.this.getIndex());
					// remove selected item from the table list
					lista_servizi.remove(servizio);
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {
				setGraphic(cellButton);
			} else {
				setGraphic(null);
			}
		}
	}

}