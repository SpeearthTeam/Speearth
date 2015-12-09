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

/**
 * Componente che rappresenta un Impiegato nella Lista di Impiegati
 */
public class RisultatoImpiegatoItem extends SubView {
	@FXML
	private BorderPane risultato_impiegato;
	@FXML
	private Label output_username;
	@FXML
	private Label output_nome;
	@FXML
	private Label output_cognome;
	@FXML
	private Label output_codice_fiscale;
	@FXML
	private Label output_data_nascita;
	@FXML
	private Label output_ruolo;
	@FXML
	private Label output_stipendio;
	@FXML
	private Button bottone_modifica;
	@FXML
	private Button bottone_elimina;

	/**
	 * Impiegato
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @param impiegato
	 * @throws IOException
	 */
	public RisultatoImpiegatoItem(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		this.setImpiegato(impiegato);
		this.aggiornaUI();
	}

	/**
	 * Inizializza la SubView
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		this.output_username.setText(this.impiegato.getUsername());
		this.output_nome.setText(this.impiegato.getNome());
		this.output_cognome.setText(this.impiegato.getCognome());
		this.output_codice_fiscale.setText(this.impiegato.getCodiceFiscale());
		this.output_data_nascita.setText(Costanti.FORMATO_DATA.format(this.impiegato.getDataNascita()));
		this.output_ruolo.setText(this.impiegato.getRuolo());
		this.output_stipendio.setText(String.valueOf(this.impiegato.getStipendio()));
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RISULTATO_IMPIEGATO;
	}

	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modificaImpiegato(ActionEvent event) {
		EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
				this.impiegato);
		this.getRoot().fireEvent(evento);
	}

	// Event Listener on Button[#bottone_elimina].onAction
	@FXML
	public void eliminaImpiegato(ActionEvent event) {
		Optional<ButtonType> result = this.mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_ELIMINA_IMPIEGATO, null,
				Costanti.MESSAGGIO_ELIMINA_IMPIEGATO);
		if (result.get() == ButtonType.OK) {
			EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.ELIMINA_IMPIEGATO,
					this.impiegato);
			this.getRoot().fireEvent(evento);
		}
	}

	/**
	 * Restituisce l'Impiegato
	 * 
	 * @return Impiegato
	 */
	public Impiegato getImpiegato() {
		return this.impiegato;
	}

	/**
	 * Imposta l'Impiegato
	 * 
	 * @param impiegato
	 */
	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	/**
	 * Imposta l'Impiegato ed aggiorna la View
	 * 
	 * @param impiegato
	 */
	public void updateImpiegato(Impiegato impiegato) {
		this.setImpiegato(impiegato);
		this.aggiornaUI();
	}
}
