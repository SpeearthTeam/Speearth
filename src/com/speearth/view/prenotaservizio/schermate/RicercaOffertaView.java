package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoSelezionaOfferta;
import com.speearth.view.prenotaservizio.schermate.componenti.ServizioOffertaListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaOffertaForm;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RicercaOffertaView extends View {
	@FXML
	private ListView<ServizioComponent> output_lista_servizi;
	@FXML
	private AnchorPane form_container;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Button bottone_conferma;

	/**
	 * Form di ricerca di Offerte
	 */
	private RicercaOffertaForm form_ricerca_offerta;

	/**
	 * Offerta selezionata
	 */
	private Offerta offerta_selezionata;

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.output_lista_servizi.setCellFactory(param -> new ServizioOffertaListItem(getStage()));
		try {
			this.form_ricerca_offerta = new RicercaOffertaForm(getStage());
			this.form_container.getChildren().add(this.form_ricerca_offerta.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaOffertaView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_ACQUISTA_OFFERTA);
		getRoot().addEventHandler(EventoSelezionaOfferta.OFFERTA_SELEZIONATA,
				new EventHandler<EventoSelezionaOfferta>() {
					@Override
					public void handle(EventoSelezionaOfferta event) {
						RicercaOffertaView.this.output_lista_servizi
								.setItems(FXCollections.observableArrayList(event.getOfferta().getListaServizi()));
						RicercaOffertaView.this.offerta_selezionata = event.getOfferta();
					}
				});
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		if (!risultati.isEmpty()) {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_ALLA_HOME, null,
					Costanti.MESSAGGIO_TORNA_ALLA_HOME);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().reset();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearParametri();
				HomeView view = new HomeView(getStage());
				view.mostra();
			}
		} else {
			AppFacadeController.getInstance().getPrenotaServizioController().reset();
			HomeView view = new HomeView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		if (!risultati.isEmpty()) {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
					null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
						.clearParametri();
				ScegliServizioView view = new ScegliServizioView(getStage());
				view.mostra();
			}
		} else {
			ScegliServizioView view = new ScegliServizioView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void conferma(ActionEvent event) throws IOException {
		AppFacadeController.getInstance().getPrenotaServizioController().setServizio(this.offerta_selezionata);
		vaiARiepilogo();
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogoButtonClick(ActionEvent event) throws IOException {
		vaiARiepilogo();
	}

	/**
	 * Ridirige l'Utente al Riepilogo
	 * 
	 * @throws IOException
	 */
	public void vaiARiepilogo() throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null)
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoOffertaView view = new RiepilogoOffertaView(getStage());
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_OFFERTA;
	}
}
