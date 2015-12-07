package com.speearth.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.creaofferta.schermate.CreaOffertaView;
import com.speearth.view.gestisciclienti.schermate.GesticiClientiView;
import com.speearth.view.gestisciimpiegati.schermate.GesticiImpiegatiView;
import com.speearth.view.prenotaservizio.schermate.ScegliServizioView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Schermata della Homepage dell'Applicazione
 */
public class HomeView extends View {
	@FXML
	private Button bottone_prenota_servizio;
	@FXML
	private Button bottone_gestisci_clienti;
	@FXML
	private Button bottone_gestici_impiegati;
	@FXML
	private Button bottone_crea_offerta;
	@FXML
	private Button bottone_esci;
	@FXML
	private Label label_utente;
	@FXML
	private Label label_ruolo_utente;

	/**
	 * Costruttore
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
	public void esci(ActionEvent event) throws IOException {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_LOGOUT, null,
				Costanti.MESSAGGIO_LOGOUT);
		if (result.get() == ButtonType.OK) {
			AppFacadeController.getInstance().getLoginController().logout();
			LoginView view = new LoginView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_prenota_servizio].onAction
	@FXML
	public void prenotaServizio(ActionEvent event) throws IOException {
		ScegliServizioView view = new ScegliServizioView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_gestisci_clienti].onAction
	@FXML
	public void gestisciClienti(ActionEvent event) throws IOException {
		GesticiClientiView view = new GesticiClientiView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_gestisci_impiegati].onAction
	@FXML
	public void gestisciImpiegati(ActionEvent event) throws IOException {
		GesticiImpiegatiView view = new GesticiImpiegatiView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_crea_offerta].onAction
	@FXML
	public void creaOfferta(ActionEvent event) throws IOException {
		CreaOffertaView view = new CreaOffertaView(this.getStage());
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
		switch (AppFacadeController.getInstance().getUtente().getRuolo()) {
		case "Commesso":
			return Costanti.FXML_HOME_COMMESSO;
		case "Responsabile Offerte":
			return Costanti.FXML_HOME_RESPONSABILE_OFFERTE;
		case "Direttore":
			return Costanti.FXML_HOME_DIRETTORE;
		}
		return null;
	}
}
