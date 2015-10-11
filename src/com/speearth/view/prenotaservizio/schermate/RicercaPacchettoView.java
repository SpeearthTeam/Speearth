package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
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
	private TableView<IServizioComponent> tabella_pacchetto;
	@FXML
	private TableColumn<IServizioComponent, String> tipo_servizio_col;
	@FXML
	private TableColumn<IServizioComponent, String> fornitore_servizio_col;
	@FXML
	private TableColumn<IServizioComponent, String> prezzo_servizio_col;
	@FXML
	private AnchorPane alloggio_form_container;
	@FXML
	private AnchorPane biglietto_form_container;

	private ObservableList<IServizioComponent> lista_servizi = FXCollections.observableArrayList();

	private RicercaAlloggioForm ricerca_alloggio_form;

	private RicercaBigliettoForm ricerca_biglietto_form;

	private TableColumn<IServizioComponent, Boolean> cancella_servizio_col = new TableColumn<>("Cancella");

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
						IServizioComponent servizio = AppFacadeController.getInstance().getPrenotaServizioController()
								.getServizio();
						if (servizio != null && servizio.getListaServizi().contains(event.getServizio()))
							mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_SERVIZIO_PRESENTE, null,
									Costanti.MESSAGGIO_SERVIZIO_PRESENTE);
						else {
							AppFacadeController.getInstance().getPrenotaServizioController().getServizio()
									.aggiungi(event.getServizio());
							lista_servizi.add(event.getServizio());
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
		this.lista_risultati_alloggi.setCellFactory(param -> new AlloggioListItem(getStage()));

		try {
			this.ricerca_biglietto_form = new RicercaBigliettoForm(getStage());
			this.ricerca_biglietto_form.bind(lista_risultati_biglietti);
			this.biglietto_form_container.getChildren().add(this.ricerca_biglietto_form.getParentNode());

			this.ricerca_alloggio_form = new RicercaAlloggioForm(getStage());
			this.ricerca_alloggio_form.bind(this.lista_risultati_alloggi);
			this.alloggio_form_container.getChildren().add(this.ricerca_alloggio_form.getParentNode());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		if (this.ricerca_biglietto_form.getBiglietti().isEmpty() && this.ricerca_alloggio_form.getAlloggi().isEmpty())
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
	private class ButtonCell extends TableCell<IServizioComponent, Boolean> {
		final Button cellButton = new Button("Cancella");

		ButtonCell() {
			// Azione associata all'event handler della pressione del Button
			// Cancella
			cellButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {
					// Recupero il servizio relativo all'indice di riga
					IServizioComponent servizio = ButtonCell.this.getTableView().getItems()
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