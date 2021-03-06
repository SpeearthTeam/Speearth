package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Schermata di selezione del Servizio da prenotare
 */
public class ScegliServizioView extends View {
	@FXML
	private Button bottone_torna_alla_home;
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
	@FXML
	private Button bottone_acquista_offerta;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public ScegliServizioView(Stage stage) throws IOException {
		super(stage);
		stage.setTitle(Costanti.TITOLO_SCEGLI_SERVIZIO);
	}

	/**
	 * Inizializza la View
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
		RicercaBigliettoView view = new RicercaBigliettoView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_prenota_alloggio].onAction
	@FXML
	public void prenotaAlloggio(ActionEvent event) throws IOException {
		RicercaAlloggioView view = new RicercaAlloggioView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_prenota_pacchetto].onAction
	@FXML
	public void prenotaPacchetto(ActionEvent event) throws IOException {
		RicercaPacchettoView view = new RicercaPacchettoView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_acquista_offerta].onAction
	@FXML
	public void acquistaOfferta(ActionEvent event) throws IOException {
		RicercaOffertaView view = new RicercaOffertaView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		HomeView view = new HomeView(this.getStage());
		view.mostra();
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_SCEGLI_SERVIZIO;
	}
}
