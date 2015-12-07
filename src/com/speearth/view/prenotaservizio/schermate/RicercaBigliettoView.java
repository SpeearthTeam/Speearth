package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoSelezionaServizio;
import com.speearth.view.prenotaservizio.schermate.componenti.BigliettoListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaBigliettoForm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Schermata di ricerca di Biglietti
 */
public class RicercaBigliettoView extends View {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Biglietto> lista_risultati;
	@FXML
	private AnchorPane form_container;

	/**
	 * Form di ricerca
	 */
	private RicercaBigliettoForm ricerca_biglietto_form;

	/**
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati.setCellFactory(param -> new BigliettoListItem(this.getStage()));
		try {
			this.ricerca_biglietto_form = new RicercaBigliettoForm(this.getStage());
			this.ricerca_biglietto_form.bind(this.lista_risultati);
			this.form_container.getChildren().add(this.ricerca_biglietto_form.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaBigliettoView(Stage stage) throws IOException {
		super(stage);
		this.getStage().setTitle(Costanti.TITOLO_PRENOTA_BIGLIETTO);
		this.impostaBiglietti();
		this.getRoot().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO,
				new EventHandler<EventoSelezionaServizio>() {
					@Override
					public void handle(EventoSelezionaServizio event) {
						try {
							ServizioComponent servizio = AppFacadeController.getInstance()
									.getPrenotaServizioController().getServizio();
							if (servizio != null && servizio.equals(event.getServizio()))
								RicercaBigliettoView.this.mostraAlert(AlertType.INFORMATION,
										Costanti.TITOLO_SERVIZIO_PRESENTE, null, Costanti.MESSAGGIO_SERVIZIO_PRESENTE);
							else {
								AppFacadeController.getInstance().getPrenotaServizioController()
										.setServizio(event.getServizio());
								RicercaBigliettoView.this.vaiARiepilogo();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
	}

	/**
	 * Carica i Biglietti salvati nel Controller all'interno View per evitarne
	 * la perdita durante un cambio di Schermata
	 */
	private void impostaBiglietti() {
		// ottengo i biglietti dal controller
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		// se il risultato contiene biglietti, allora...
		if (!risultati.isEmpty()) {
			this.lista_risultati.setCellFactory(param -> new BigliettoListItem(this.getStage()));
			// converto l'ArrayList in observableArrayList
			ObservableList<Biglietto> list = FXCollections.observableArrayList(risultati);
			// setto la lista dei risultati, ListView, con la Observable
			this.lista_risultati.setItems(list);
		}
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		if (!risultati.isEmpty()) {
			Optional<ButtonType> result = this.mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_ALLA_HOME,
					null, Costanti.MESSAGGIO_TORNA_ALLA_HOME);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().reset();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearParametri();
				HomeView view = new HomeView(this.getStage());
				view.mostra();
			}
		} else {
			AppFacadeController.getInstance().getPrenotaServizioController().reset();
			HomeView view = new HomeView(this.getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		if (!risultati.isEmpty()) {
			Optional<ButtonType> result = this.mostraAlert(AlertType.CONFIRMATION,
					Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO, null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearParametri();
				ScegliServizioView view = new ScegliServizioView(this.getStage());
				view.mostra();
			}
		} else {
			ScegliServizioView view = new ScegliServizioView(this.getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogoButtonClick(ActionEvent event) throws IOException {
		this.vaiARiepilogo();
	}

	/**
	 * Ridirige l'Utente alla Schermata di Riepilogo
	 * 
	 * @throws IOException
	 */
	public void vaiARiepilogo() throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null)
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null,
					Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoBigliettoView view = new RiepilogoBigliettoView(this.getStage());
			view.mostra();
		}
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RICERCA_BIGLIETTO;
	}
}
