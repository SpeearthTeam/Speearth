package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Alloggio;
import com.speearth.model.core.IServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;
import com.speearth.view.prenotaservizio.schermate.componenti.AlloggioListItem;
import com.speearth.view.prenotaservizio.schermate.componenti.form.RicercaAlloggioForm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RicercaAlloggioView extends View {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Alloggio> lista_risultati;
	@FXML
	private AnchorPane form_container;

	private RicercaAlloggioForm ricerca_alloggio_form;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RicercaAlloggioView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_ALLOGGIO);
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

	/**
	 * Inizializza la view
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lista_risultati.setCellFactory(param -> new AlloggioListItem(getStage()));
		try {
			this.ricerca_alloggio_form = new RicercaAlloggioForm(getStage());
			this.ricerca_alloggio_form.bind(this.lista_risultati);
			this.form_container.getChildren().add(this.ricerca_alloggio_form.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		if (!this.ricerca_alloggio_form.getAlloggi().isEmpty()) {
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
			RiepilogoAlloggioView view = new RiepilogoAlloggioView(getStage());
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_ALLOGGIO;
	}
}
