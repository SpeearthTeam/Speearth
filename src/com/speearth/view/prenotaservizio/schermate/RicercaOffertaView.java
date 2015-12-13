package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoSelezionaOfferta;
import com.speearth.view.prenotaservizio.schermate.componenti.ServizioOffertaListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaOffertaForm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Schermata di ricerca di Offerte
 */
public class RicercaOffertaView extends View {
	@FXML
	private ListView<ServizioComponent> output_lista_servizi;
	@FXML
	private HBox form_container;
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
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.output_lista_servizi.setCellFactory(param -> new ServizioOffertaListItem(this.getStage()));
		try {
			this.form_ricerca_offerta = new RicercaOffertaForm(this.getStage());
			this.form_container.getChildren().add(this.form_ricerca_offerta.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.impostaRisultati();
	}

	/**
	 * Carica la lista di servizi contenuti nell'Offerta, salvata nel
	 * Controller, all'interno della View per evitarne la perdita durante un
	 * cambio di Schermata
	 */
	private void impostaRisultati() {
		List<ServizioComponent> lista_servizi = AppFacadeController.getInstance().getPrenotaServizioController()
				.getAcquistaOffertaController().getListaServizi();
		if (!lista_servizi.isEmpty() && lista_servizi != null) {
			ObservableList<ServizioComponent> lista_servizi_observable = FXCollections
					.observableArrayList(lista_servizi);
			this.output_lista_servizi.setItems(lista_servizi_observable);
		}
	}

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaOffertaView(Stage stage) throws IOException {
		super(stage);
		this.getStage().setTitle(Costanti.TITOLO_ACQUISTA_OFFERTA);
		this.getRoot().addEventHandler(EventoSelezionaOfferta.OFFERTA_SELEZIONATA,
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
		ServizioComponent servizio = AppFacadeController.getInstance().getPrenotaServizioController().getServizio();
		if (servizio != null) {
			Optional<ButtonType> result = this.mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_ALLA_HOME,
					null, Costanti.MESSAGGIO_TORNA_ALLA_HOME);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().reset();
				AppFacadeController.getInstance().getPrenotaServizioController().getAcquistaOffertaController().reset();
				HomeView view = new HomeView(this.getStage());
				view.mostra();
			}
		} else {
			HomeView view = new HomeView(this.getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		ServizioComponent servizio = AppFacadeController.getInstance().getPrenotaServizioController().getServizio();
		if (servizio != null) {
			Optional<ButtonType> result = this.mostraAlert(AlertType.CONFIRMATION,
					Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO, null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
			if (result.get() == ButtonType.OK) {
				AppFacadeController.getInstance().getPrenotaServizioController().reset();
				AppFacadeController.getInstance().getPrenotaServizioController().getAcquistaOffertaController().reset();
				ScegliServizioView view = new ScegliServizioView(this.getStage());
				view.mostra();
			}
		} else {
			ScegliServizioView view = new ScegliServizioView(this.getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void conferma(ActionEvent event) throws IOException {
		this.vaiARiepilogo(event);
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) throws IOException {
		if (this.offerta_selezionata != null) {
			AppFacadeController.getInstance().getPrenotaServizioController().setServizio(this.offerta_selezionata);
			AppFacadeController.getInstance().getPrenotaServizioController().getAcquistaOffertaController()
					.setListaServizi(this.offerta_selezionata.getListaServizi());
			RiepilogoOffertaView view = new RiepilogoOffertaView(this.getStage());
			view.mostra();
		} else {
			ServizioComponent servizio = AppFacadeController.getInstance().getPrenotaServizioController().getServizio();
			if (servizio != null) {
				RiepilogoOffertaView view = new RiepilogoOffertaView(this.getStage());
				view.mostra();
			} else
				this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null,
						Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		}
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RICERCA_OFFERTA;
	}
}
