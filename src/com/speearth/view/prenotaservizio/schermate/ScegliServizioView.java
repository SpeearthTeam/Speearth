package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.utility.Costanti;
import com.speearth.view.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ScegliServizioView extends View {
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Button bottone_prenota_biglietto;
	@FXML
	private Button bottone_prenota_alloggio;
	@FXML
	private Button bottone_prenota_pacchetto;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public ScegliServizioView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_SCEGLI_SERVIZIO);
	}

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	// Event Listener on Button[#bottone_prenota_biglietto].onAction
	@FXML
	public void prenotaBiglietto(ActionEvent event) throws IOException {
		RicercaBigliettoView view = new RicercaBigliettoView(getStage());
		view.setPreviousView(this);
		view.mostra();
	}

	// Event Listener on Button[#bottone_prenota_alloggio].onAction
	@FXML
	public void prenotaAlloggio(ActionEvent event) throws IOException {
		RicercaAlloggioView view = new RicercaAlloggioView(getStage());
		view.setPreviousView(this);
		view.mostra();
	}

	// Event Listener on Button[#bottone_prenota_pacchetto].onAction
	@FXML
	public void prenotaPacchetto(ActionEvent event) throws IOException {
		RicercaPacchettoView view = new RicercaPacchettoView(getStage());
		view.setPreviousView(this);
		view.mostra();
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_SCEGLI_SERVIZIO;
	}
}
