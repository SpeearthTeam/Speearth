package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.utility.Costanti;
import com.speearth.view.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_prenota_biglietto].onAction
	@FXML
	public void prenotaBiglietto(ActionEvent event) throws IOException {
		this.cambiaScena(event, Costanti.TITOLO_PRENOTA_BIGLIETTO,
				Costanti.FXML_RICERCA_BIGLIETTO);
	}

	// Event Listener on Button[#bottone_prenota_alloggio].onAction
	@FXML
	public void prenotaAlloggio(ActionEvent event) throws IOException {
		this.cambiaScena(event, Costanti.TITOLO_PRENOTA_ALLOGGIO,
				Costanti.FXML_RICERCA_ALLOGGIO);
	}

	// Event Listener on Button[#bottone_prenota_pacchetto].onAction
	@FXML
	public void prenotaPacchetto(ActionEvent event) throws IOException {
		this.cambiaScena(event, Costanti.TITOLO_PRENOTA_PACCHETTO,
				Costanti.FXML_RICERCA_PACCHETTO);
	}
}
