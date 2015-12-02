package com.speearth.view.gestisciimpiegati.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;
import com.speearth.view.eventi.EventoGestioneImpiegato;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RisultatoImpiegatoItem extends SubView {
	@FXML
	private BorderPane risultato_impiegato;
	@FXML
	private Label nome;
	@FXML
	private Label cognome;
	@FXML
	private Label codice_fiscale;
	@FXML
	private Label data_nascita;
	@FXML
	private Label output_ruolo;
	@FXML
	private Button bottone_modifica;
	@FXML
	private Button bottone_elimina;

	/**
	 * Impiegato contenuto nella subview
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore con parametro
	 * 
	 * @param stage
	 * @param impiegato
	 * @throws IOException
	 */
	public RisultatoImpiegatoItem(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		this.setImpiegato(impiegato);
		updateUI();
	}

	/**
	 * Inizializza la subview
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Aggiorna la subview
	 */
	@Override
	public void updateUI() {
		nome.setText(impiegato.getNome());
		cognome.setText(impiegato.getCognome());
		codice_fiscale.setText(impiegato.getCodiceFiscale());
		data_nascita.setText(Costanti.FORMATO_DATA.format(impiegato.getDataNascita()));
	}

	/**
	 * Restituisce la risorsa fxml della subview
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RISULTATO_IMPIEGATO;
	}

	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modificaImpiegato(ActionEvent event) {
		EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
				impiegato);
		getRoot().fireEvent(evento);
	}

	// Event Listener on Button[#bottone_elimina].onAction
	@FXML
	public void eliminaImpiegato(ActionEvent event) {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_ELIMINA_IMPIEGATO, null,
				Costanti.MESSAGGIO_ELIMINA_IMPIEGATO);
		if (result.get() == ButtonType.OK) {
			EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.ELIMINA_IMPIEGATO,
					impiegato);
			getRoot().fireEvent(evento);
		}
	}

	/**
	 * Restituisce l'impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}

	/**
	 * Imposta l'impiegato
	 * 
	 * @param impiegato
	 */
	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	/**
	 * Imposta l'impiegato ed aggiorna la view
	 * 
	 * @param impiegato
	 */
	public void updateImpiegato(Impiegato impiegato) {
		setImpiegato(impiegato);
		updateUI();
	}
}
