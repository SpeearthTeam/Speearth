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

/**
 * Form per l'aggiunta di un nuovo Impiegato
 */
public class AggiungiImpiegatoForm extends FormView {
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
	 * Impiegato
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public AggiungiImpiegatoForm(Stage stage) throws IOException {
		this(stage, null);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				stage.close();
			}
		});
	}

	/**
	 * Costruttore con Impiegato
	 * 
	 * @param stage
	 * @param impiegato
	 * @throws IOException
	 */
	public AggiungiImpiegatoForm(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				stage.close();
			}
		});
		this.impiegato = impiegato;
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

	// Event Listener on Button[#bottone_aggiungi].onAction
	@FXML
	public void aggiungi(ActionEvent event) {
		try {
			if (this.valida()) {
				this.invia(null);
				EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.AGGIUNGI_IMPIEGATO,
						impiegato);
				this.getRoot().fireEvent(evento);
				this.getStage().close();
			}
		} catch (InvalidParameterException e) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		} catch (IOException e) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
	}

	/**
	 * Inizializza la SubView
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.input_ruolo.setItems(FXCollections.observableArrayList(Costanti.LISTA_RUOLI));
		this.input_ruolo.setValue(Costanti.LISTA_RUOLI[0]);
	}

	/**
	 * Valida gli input della Form
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valida() {
		// Controllo dello username
		if (this.input_username.getText() == null || this.input_username.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_USERNAME);
			return false;
		}
		// Controllo della password
		if (this.input_password.getText() == null || this.input_password.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_PASSWORD);
			return false;
		}
		// Controllo della password ripetuta
		if (this.input_ripeti_password.getText() == null || this.input_ripeti_password.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_RIPETERE_PASSWORD);
			return false;
		}
		// Controllo dell'uguaglianza delle password
		if (!(this.input_password.getText().equals(this.input_ripeti_password.getText()))) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PASSWORD_DIVERSE);
			return false;
		}
		// Controllo del nome
		if (input_nome.getText() == null || input_nome.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_NOME);
			return false;
		}
		// Controllo del cognome
		if (input_cognome.getText() == null || input_cognome.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_COGNOME);
			return false;
		}
		// Controllo del codice fiscale
		if (input_codice_fiscale.getText() == null || input_codice_fiscale.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_CF);
			return false;
		}
		// Controllo della data di nascita
		LocalDate data_nascita = this.input_data_nascita.getValue();
		if (data_nascita == null) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_DATA_NASCITA);
			return false;
		}
		if (data_nascita.isAfter(LocalDate.now())) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DATA_NASCITA_NON_VALIDA);
			return false;
		}
		// Controllo dello stipendio
		if (this.input_stipendio.getText() == null || this.input_stipendio.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_STIPENDIO);
			return false;
		}
		// Controllo della validità della stringa stipendio
		if (this.validazioneEParsificazioneStipendio(this.input_stipendio.getText()) == null) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_STIPENDIO_NON_VALIDO);
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
	 * Resituisce i parametri della Form
	 * 
	 * @return HashMap<String, String>
	 */
	@Override
	public HashMap<String, String> getParametri() {
		return null;
	}

	/**
	 * Invia la richiesta
	 * 
	 * @param parameters
	 * @throws IOException
	 */
	@Override
	public void invia(HashMap<String, String> parameters) throws IOException {
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
			this.impiegato = AppFacadeController.getInstance().getGestisciImpiegatiController().aggiungiImpiegato(username,
					password, nome, cognome, data_nascita, codice_fiscale, ruolo, stipendio);
		} else {
			this.impiegato = AppFacadeController.getInstance().getGestisciImpiegatiController().modificaImpiegato(username,
					password, nome, cognome, data_nascita, codice_fiscale, ruolo, stipendio);
		}
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_AGGIUNGI_IMPIEGATO_FORM;
	}
}
