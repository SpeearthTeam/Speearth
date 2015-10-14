package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;
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

	private RicercaBigliettoForm ricerca_biglietto_form;

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati.setCellFactory(param -> new BigliettoListItem(getStage()));
		try {
			this.ricerca_biglietto_form = new RicercaBigliettoForm(getStage());
			this.ricerca_biglietto_form.bind(this.lista_risultati);
			this.form_container.getChildren().add(this.ricerca_biglietto_form.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setListaRisultati(){
		ArrayList<Biglietto> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().getBiglietti();
		ObservableList<Biglietto> list = FXCollections.observableArrayList(risultati);
		lista_risultati = new ListView<Biglietto>(list);
	}

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaBigliettoView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_BIGLIETTO);
		getRoot().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO,
				new EventHandler<EventoSelezionaServizio>() {

					@Override
					public void handle(EventoSelezionaServizio event) {
						try {
							IServizioComponent servizio = AppFacadeController.getInstance()
									.getPrenotaServizioController().getServizio();
							if (servizio != null && servizio.equals(event.getServizio()))
								mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_SERVIZIO_PRESENTE, null,
										Costanti.MESSAGGIO_SERVIZIO_PRESENTE);
							else {
								AppFacadeController.getInstance().getPrenotaServizioController()
										.setServizio(event.getServizio());
								vaiARiepilogo();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
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
			}
		}
		ScegliServizioView view = new ScegliServizioView(getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogoButtonClick(ActionEvent event) throws IOException {
		vaiARiepilogo();
	}

	/**
	 * Ridirige l'utente al riepilogo
	 * 
	 * @throws IOException
	 */
	public void vaiARiepilogo() throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null)
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoBigliettoView view = new RiepilogoBigliettoView(getStage());
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_BIGLIETTO;
	}
}
