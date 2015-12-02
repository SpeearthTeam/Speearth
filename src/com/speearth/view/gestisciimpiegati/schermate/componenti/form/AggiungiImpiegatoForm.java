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
import com.speearth.controller.GestisciImpiegatiController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.eventi.EventoGestioneImpiegato;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AggiungiImpiegatoForm extends FormView {
	@FXML
	private TextField input_username;
	@FXML
	private TextField input_password;
	@FXML
	private TextField input_conferma_password;
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
	private TextField input_ruolo;
	@FXML
	private TextField input_stipendio;

	/**
	 * Impiegato associato alla form
	 */
	private Impiegato impiegato;

	/**
	 * Controllore di gestione dei clienti
	 */
	private GestisciImpiegatiController controller;

	/**
	 * Costruttore di default usato per la creazione del impiegato
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
	 * Costruttore con impiegato usato per la modifica del impiegato
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
		this.controller = AppFacadeController.getInstance().getGestisciImpiegatiController();
		updateUI();
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
			this.validate();
			this.send(null);
			EventoGestioneImpiegato evento = new EventoGestioneImpiegato(EventoGestioneImpiegato.AGGIUNGI_IMPIEGATO,
					impiegato);
			getRoot().fireEvent(evento);
		} catch (InvalidParameterException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		} catch (IOException e) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, e.getMessage());
		}
		this.getStage().close();
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Valida la form
	 */
	@Override
	public void validate() {
		// Controllo del nome
		if (input_nome.getText() == null || input_nome.getText().isEmpty()) {
			throw new InvalidParameterException("Definire il nome");
		}

		// Controllo del cognome
		if (input_cognome.getText() == null || input_cognome.getText().isEmpty()) {
			throw new InvalidParameterException("Definire il cognome");
		}

		// Controllo del codice fiscale
		if (input_codice_fiscale.getText() == null || input_codice_fiscale.getText().isEmpty()) {
			throw new InvalidParameterException("Definire il codice fiscale");
		}

		// Controllo della data di nascita
		LocalDate data_nascita = input_data_nascita.getValue();

		if (data_nascita == null) {
			throw new InvalidParameterException("Definire la data di nascita");
		}

		if (data_nascita.isAfter(LocalDate.now())) {
			throw new InvalidParameterException("Definire una data di nascita corretta");
		}
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
		String username = input_username.getText();
		String password = input_password.getText();
		String nome = input_nome.getText();
		String cognome = input_cognome.getText();
		String codice_fiscale = input_codice_fiscale.getText();
		Date data_nascita = Date.from(input_data_nascita.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		String ruolo = input_ruolo.getText();
		float stipendio = Float.parseFloat(input_stipendio.getText());

		if (impiegato == null) {
			// creo un nuovo impiegato
			impiegato = controller.aggiungiImpiegato(username, password, nome, cognome, data_nascita, codice_fiscale,
					ruolo, stipendio);
		} else {
			// modifico l'Impiegato
			impiegato = controller.modificaImpiegato(username, password, nome, cognome, data_nascita, codice_fiscale,
					ruolo, stipendio);
		}
	}

	/**
	 * Aggiorna la form view
	 */
	@Override
	public void updateUI() {
		if (impiegato != null) {
			input_nome.setText(impiegato.getNome());
			input_cognome.setText(impiegato.getCognome());
			input_codice_fiscale.setText(impiegato.getCodiceFiscale());
			input_data_nascita
					.setValue(LocalDate.parse(Costanti.FORMATO_DATA_STANDARD.format(impiegato.getDataNascita())));
		}
	}

	/**
	 * Restituisce il nome della risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_AGGIUNGI_IMPIEGATO_FORM;
	}
}
