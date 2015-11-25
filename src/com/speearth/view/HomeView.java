package com.speearth.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.creaofferta.schermate.CreaOffertaView;
import com.speearth.view.gestisciclienti.schermate.GesticiClientiView;
import com.speearth.view.prenotaservizio.schermate.ScegliServizioView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeView extends View{
	@FXML
	private Button bottone_prenota_servizio;
	@FXML
	private Button bottone_gestici_clienti;
	@FXML
	private Button bottone_crea_offerta;
	@FXML
	private Label label_utente;
	@FXML
	private Label label_ruolo_utente;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public HomeView(Stage stage) throws IOException {
		super(stage);
		stage.setTitle(Costanti.TITOLO_HOME);
	}
	
	// Event Listener on Button[#bottone_prenota_servizio].onAction
	@FXML
	public void prenotaServizio(ActionEvent event) throws IOException {
		ScegliServizioView view = new ScegliServizioView(getStage());
		view.mostra();
	}
	
	// Event Listener on Button[#bottone_gestici_clienti].onAction
	@FXML
	public void gesticiClienti(ActionEvent event) throws IOException {
		GesticiClientiView view = new GesticiClientiView(getStage());
		view.mostra();
	}
	
	// Event Listener on Button[#bottone_crea_offerta].onAction
	@FXML
	public void creaOfferta(ActionEvent event) throws IOException {
		CreaOffertaView view = new CreaOffertaView(getStage());
		view.mostra();
	}
	
	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Impiegato utente = AppFacadeController.getInstance().getUtente();
		this.label_utente.setText(utente.getNome() + " " + utente.getCognome());
	}
	
	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_HOME_RESPONSABILE_OFFERTE;
	}
}
