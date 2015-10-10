package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
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
import com.speearth.view.prenotaservizio.schermate.componenti.ButtonCell;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
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
	private MenuButton input_mezzo;
	@FXML
	private MenuButton input_bambini;
	@FXML
	private MenuButton input_adulti;
	@FXML
	private MenuButton input_ora_ritorno;
	@FXML
	private MenuButton input_ora_andata;
	@FXML
	private TextField input_localita;
	@FXML
	private DatePicker input_data_arrivo;
	@FXML
	private DatePicker input_data_partenza;
	@FXML
	private Button ricerca_alloggi;
	@FXML
	private MenuButton input_numero_singole;
	@FXML
	private MenuButton input_ora_partenza;
	@FXML
	private MenuButton input_ora_arrivo;
	@FXML
	private CheckBox input_singola;
	@FXML
	private CheckBox input_doppia;
	@FXML
	private CheckBox input_tripla;
	@FXML
	private CheckBox input_quadrupla;
	@FXML
	private MenuButton input_numero_doppie;
	@FXML
	private MenuButton input_numero_triple;
	@FXML
	private MenuButton input_numero_quadruple;
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

	private TableColumn<IServizioComponent, Boolean> cancella_servizio_col = new TableColumn<>("Cancella");

	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca della tab
	 * Biglietti
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDatiBiglietti() {
		HashMap<String, String> parametri = new HashMap<String, String>();
		parametri.put("numero_adulti", this.input_adulti.getText());
		parametri.put("numero_bambini", this.input_bambini.getText());
		parametri.put("partenza", this.input_partenza.getText());
		parametri.put("destinazione", this.input_destinazione.getText());
		parametri.put("data_andata", this.input_data_andata.toString());
		parametri.put("data_ritorno", this.input_data_ritorno.toString());
		parametri.put("ora_andata", this.input_ora_andata.getText());
		parametri.put("ora_ritorno", this.input_ora_ritorno.getText());
		parametri.put("mezzo", this.input_mezzo.getText());
		return parametri;
	}

	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca della tab
	 * Alloggi
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDatiAlloggi() {
		HashMap<String, String> parametri = new HashMap<String, String>();

		parametri.put("data_arrivo", this.input_data_arrivo.toString());
		parametri.put("data_partenza", this.input_data_partenza.toString());
		parametri.put("stanza_doppia", this.input_doppia.getText());
		parametri.put("località", this.input_localita.getText());
		parametri.put("numero_doppie", this.input_numero_doppie.getText());
		parametri.put("numero_quadruple", this.input_numero_quadruple.getText());
		parametri.put("numero_singole", this.input_numero_singole.getText());
		parametri.put("numero_triple", this.input_numero_triple.getText());
		parametri.put("ora_arrivo", this.input_ora_arrivo.getText());
		parametri.put("ora_partenza", this.input_ora_partenza.getText());
		parametri.put("stanza_quadrupla", this.input_quadrupla.getText());
		parametri.put("stanza_singola", this.input_singola.getText());
		parametri.put("stanza_tripla", this.input_tripla.getText());

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

		this.bottone_ricerca.setDisable(true);
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
						ButtonCell button_cell = new ButtonCell(); 
						return button_cell;
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

	public ObservableList<IServizioComponent> getListaServizi() {
		return this.lista_servizi;
	}

}
