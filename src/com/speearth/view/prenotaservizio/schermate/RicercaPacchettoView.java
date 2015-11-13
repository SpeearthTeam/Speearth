package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.PacchettoComposite;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;
import com.speearth.view.prenotaservizio.schermate.componenti.AlloggioListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.BigliettoListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaAlloggioForm;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaBigliettoForm;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RicercaPacchettoView extends View {
	@FXML
	private ListView<Biglietto> lista_risultati_biglietti;
	@FXML
	private ListView<Alloggio> lista_risultati_alloggi;
	@FXML
	private TableView<ServizioComponent> tabella_pacchetto;
	@FXML
	private TableColumn<ServizioComponent, String> tipo_servizio_col;
	@FXML
	private TableColumn<ServizioComponent, String> fornitore_servizio_col;
	@FXML
	private TableColumn<ServizioComponent, String> prezzo_servizio_col;
	@FXML
	private AnchorPane alloggio_form_container;
	@FXML
	private AnchorPane biglietto_form_container;

	private ObservableList<ServizioComponent> lista_servizi = FXCollections.observableArrayList();

	private RicercaAlloggioForm ricerca_alloggio_form;

	private RicercaBigliettoForm ricerca_biglietto_form;

	private TableColumn<ServizioComponent, Boolean> cancella_servizio_col = new TableColumn<>("Cancella");

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
		getRoot().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO,
				new EventHandler<EventoSelezionaServizio>() {

					@Override
					public void handle(EventoSelezionaServizio event) {
						ServizioComponent pacchetto = AppFacadeController.getInstance().getPrenotaServizioController()
								.getServizio();
						if (pacchetto != null && pacchetto.getListaServizi().contains(event.getServizio()))
							mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_SERVIZIO_PRESENTE, null,
									Costanti.MESSAGGIO_SERVIZIO_PRESENTE);
						else {
							ServizioComponent servizio = event.getServizio();
							AppFacadeController.getInstance().getPrenotaServizioController().getServizio()
									.aggiungi(servizio);
							lista_servizi.add(servizio);
						}
					}
				});

		impostaRisultati();
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
		this.lista_risultati_alloggi.setCellFactory(param -> new AlloggioListItem(getStage()));

		try {
			this.ricerca_biglietto_form = new RicercaBigliettoForm(getStage());
			this.ricerca_biglietto_form.bind(lista_risultati_biglietti);
			this.biglietto_form_container.getChildren().add(this.ricerca_biglietto_form.getRoot());

			this.ricerca_alloggio_form = new RicercaAlloggioForm(getStage());
			this.ricerca_alloggio_form.bind(this.lista_risultati_alloggi);
			this.alloggio_form_container.getChildren().add(this.ricerca_alloggio_form.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che serve a caricare i biglietti e gli alloggi salvati nel
	 * controller alla view, dalla schermata Riepilogo a Ricerca, altrimenti
	 * andrebbero persi
	 */
	private void impostaRisultati() {
		// ottengo i biglietti dal controller
		ArrayList<Biglietto> risultati_biglietti = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		// se il risultato contiene biglietti, allora...
		if (!risultati_biglietti.isEmpty()) {
			this.lista_risultati_biglietti.setCellFactory(param -> new BigliettoListItem(getStage()));
			// converto l'ArrayList in observableArrayList
			ObservableList<Biglietto> list_biglietti = FXCollections.observableArrayList(risultati_biglietti);
			// setto la lista dei risultati, ListView, con la Observable
			this.lista_risultati_biglietti.setItems(list_biglietti);
		}
		// ottengo i biglietti dal controller
		ArrayList<Alloggio> risultati_alloggi = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController().getAlloggi();
		// se il risultato contiene biglietti, allora...
		if (!risultati_alloggi.isEmpty()) {
			this.lista_risultati_alloggi.setCellFactory(param -> new AlloggioListItem(getStage()));
			// converto l'ArrayList in observableArrayList
			ObservableList<Alloggio> list_alloggi = FXCollections.observableArrayList(risultati_alloggi);
			// setto la lista dei risultati, ListView, con la Observable
			this.lista_risultati_alloggi.setItems(list_alloggi);
		}
		// ottengo i servizi del pacchetto dal controller
		ArrayList<ServizioComponent> pacchetto = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaPacchettoController().getPacchetto();
		// se il pacchetto contiene servizi, allora imposto la lista servizi del
		// pacchetto e la ObservableList
		if (!pacchetto.isEmpty()) {
			AppFacadeController.getInstance().getPrenotaServizioController().getServizio().setListaServizi(pacchetto);
			lista_servizi.addAll(pacchetto);
		}
	}

	/**
	 * Inizializza la tabella dei servizi scelti
	 */
	public void initializeServiceTable() {
		this.tipo_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<ServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<ServizioComponent, String> param) {
						ServizioComponent servizio = param.getValue();
						SimpleStringProperty tipo = null;

						if (servizio instanceof Alloggio)
							tipo = new SimpleStringProperty("Alloggio");
						else if (servizio instanceof Biglietto)
							tipo = new SimpleStringProperty("Biglietto");

						return tipo;
					}
				});

		this.fornitore_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<ServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<ServizioComponent, String> param) {
						ServizioComponent servizio = param.getValue();
						SimpleStringProperty fornitore = null;

						if (servizio instanceof Alloggio)
							fornitore = new SimpleStringProperty(((Alloggio) servizio).getFornitore());
						else if (servizio instanceof Biglietto)
							fornitore = new SimpleStringProperty(((Biglietto) servizio).getFornitore());

						return fornitore;
					}
				});

		this.prezzo_servizio_col.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<ServizioComponent, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<ServizioComponent, String> param) {
						ServizioComponent servizio = param.getValue();
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
				new Callback<TableColumn<ServizioComponent, Boolean>, TableCell<ServizioComponent, Boolean>>() {

					@Override
					public TableCell<ServizioComponent, Boolean> call(TableColumn<ServizioComponent, Boolean> p) {
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
		ArrayList<Biglietto> risultati_biglietti = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		ArrayList<Alloggio> risultati_alloggi = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController().getAlloggi();
		if (!risultati_biglietti.isEmpty() || !risultati_alloggi.isEmpty()) {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
					null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaAlloggioController()
						.clearAlloggi();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearParametri();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaAlloggioController()
						.clearParametri();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaPacchettoController()
						.clearPacchetto();
				ScegliServizioView view = new ScegliServizioView(getStage());
				view.mostra();
			}
		} else {
			AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
			ScegliServizioView view = new ScegliServizioView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) throws IOException {
		ArrayList<ServizioComponent> pacchetto = AppFacadeController.getInstance().getPrenotaServizioController()
				.getServizio().getListaServizi();
		AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaPacchettoController()
				.setPacchetto(pacchetto);
		if (pacchetto.isEmpty())
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else if (!(pacchetto.size() > 1))
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PACCHETTO_UN_ELEMENTO);
		else {
			AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaPacchettoController()
					.setPacchetto(pacchetto);
			RiepilogoPacchettoView view = new RiepilogoPacchettoView(getStage());
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

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_PACCHETTO;
	}

	// Definisco la classe privata ButtonCell
	private class ButtonCell extends TableCell<ServizioComponent, Boolean> {
		final Button cellButton = new Button("Cancella");

		ButtonCell() {
			// Azione associata all'event handler della pressione del Button
			// Cancella
			cellButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					// Recupero il servizio relativo all'indice di riga
					ServizioComponent servizio = ButtonCell.this.getTableView().getItems()
							.get(ButtonCell.this.getIndex());

					// Rimuovo il servizio dalla lista servizi
					lista_servizi.remove(servizio);
					// Rimuovo il servizio dal servizio in prenotazione
					AppFacadeController.getInstance().getPrenotaServizioController().getServizio().rimuovi(servizio);

				}
			});
		}

		// Visualizzo il Button se la riga non è vuota
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