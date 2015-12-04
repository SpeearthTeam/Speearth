package com.speearth.view.gestisciimpiegati.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.eventi.EventoGestioneImpiegato;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ModificaImpiegatoForm extends FormView {
	@FXML
	private TextField input_username;
	@FXML
	private PasswordField input_password;
	@FXML
	private PasswordField input_ripeti_password;
	@FXML
	private TextField input_nome;
	@FXML
	private TextField input_cognome;
	@FXML
	private DatePicker input_data_nascita;
	@FXML
	private Button bottone_aggiungi;
	@FXML
	private TextField input_codice_fiscale;
	@FXML
	private ChoiceBox<String> input_ruolo;
	@FXML
	private TextField input_stipendio;

	/**
	 * Impiegato associato alla form
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore con impiegato usato per la modifica del impiegato
	 * 
	 * @param stage
	 * @param impiegato
	 * @throws IOException
	 */
	public ModificaImpiegatoForm(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				stage.close();
			}
		});
		this.impiegato = impiegato;
		this.updateUI();
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
	 * Restituisce l'Impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}

	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modifica(ActionEvent event) {
		try {
			if (this.validate()) {
				this.send(null);
				EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
						impiegato);
				getRoot().fireEvent(evento);
				this.getStage().close();
			}
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		} catch (IOException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.input_ruolo.setItems(FXCollections.observableArrayList("Commesso", "Responsabile Offerte"));
	}

	/**
	 * Valida la form
	 */
	@Override
	public boolean validate() {
		// Controllo dello username
		if (this.input_username.getText() == null || this.input_username.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_USERNAME);
			return false;
		}
		// Controllo della password
		if (this.input_password.getText() == null || this.input_password.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_PASSWORD);
			return false;
		}
		// Controllo della password ripetuta
		if (this.input_ripeti_password.getText() == null || this.input_ripeti_password.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_RIPETERE_PASSWORD);
			return false;
		}
		// Controllo dell'uguaglianza delle password
		if (!(this.input_password.getText().equals(this.input_ripeti_password.getText()))) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PASSWORD_DIVERSE);
			return false;
		}
		// Controllo del nome
		if (input_nome.getText() == null || input_nome.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_NOME);
			return false;
		}
		// Controllo del cognome
		if (input_cognome.getText() == null || input_cognome.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_COGNOME);
			return false;
		}
		// Controllo del codice fiscale
		if (input_codice_fiscale.getText() == null || input_codice_fiscale.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_CF);
			return false;
		}
		// Controllo della data di nascita
		LocalDate data_nascita = this.input_data_nascita.getValue();
		if (data_nascita == null) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_DATA_NASCITA);
			return false;
		}
		if (data_nascita.isAfter(LocalDate.now())) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DATA_NASCITA_NON_VALIDA);
			return false;
		}
		// Controllo dello stipendio
		if (this.input_stipendio.getText() == null || this.input_stipendio.getText().isEmpty()) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_STIPENDIO);
			return false;
		}
		// Controllo della validità della stringa stipendio
		if (this.validazioneEParsificazioneStipendio(this.input_stipendio.getText()) == null) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_STIPENDIO_NON_VALIDO);
			return false;
		}
		return true;
	}

	/**
	 * Prende in input lo Stipendio inserito, controlla, e restituisce una
	 * stringa valida parsificata
	 * 
	 * @param input
	 * @return String
	 */
	private String validazioneEParsificazioneStipendio(String input) {
		input = input.replace(",", ".");
		if (input.matches(Costanti.REG_EX_FLOAT) && Float.parseFloat(input) > 0 && Float.parseFloat(input) < 100)
			return input;
		return null;
	}

	/**
	 * Restituisce i parametri
	 */
	@Override
	public HashMap<String, String> getParameters() {
		return null;
	}

	/**
	 * Invia i parametri della form
	 */
	@Override
	public void send(HashMap<String, String> parameters) throws IOException {
		// TODO
		String username = this.input_username.getText();
		String password = this.input_password.getText();
		String nome = this.input_nome.getText();
		String cognome = this.input_cognome.getText();
		String codice_fiscale = this.input_codice_fiscale.getText();
		Date data_nascita = Date
				.from(this.input_data_nascita.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		String ruolo = this.input_ruolo.getValue();
		float stipendio = Float.parseFloat(this.input_stipendio.getText());

		if (this.impiegato == null) {
			// creo un nuovo impiegato
			this.impiegato = AppFacadeController.getInstance().getGestisciImpiegatiController().aggiungiImpiegato(
					username, password, nome, cognome, data_nascita, codice_fiscale, ruolo, stipendio);
		} else {
			// modifico l'Impiegato
			this.impiegato = AppFacadeController.getInstance().getGestisciImpiegatiController().modificaImpiegato(
					username, password, nome, cognome, data_nascita, codice_fiscale, ruolo, stipendio);
		}
	}

	/**
	 * Aggiorna la form view
	 */
	@Override
	public void updateUI() {
		if (this.impiegato != null) {
			this.input_username.setText(this.impiegato.getUsername());
			this.input_password.setText(this.impiegato.getPassword());
			this.input_ripeti_password.setText(this.impiegato.getPassword());
			this.input_cognome.setText(this.impiegato.getCognome());
			this.input_nome.setText(this.impiegato.getNome());
			this.input_codice_fiscale.setText(this.impiegato.getCodiceFiscale());
			this.input_data_nascita
					.setValue(LocalDate.parse(Costanti.FORMATO_DATA_STANDARD.format(this.impiegato.getDataNascita())));
			this.input_ruolo.setValue(this.impiegato.getRuolo());
			this.input_stipendio.setText(String.valueOf(this.impiegato.getStipendio()));
		}
	}

	/**
	 * Restituisce il nome della risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_MODIFICA_IMPIEGATO_FORM;
	}
}
