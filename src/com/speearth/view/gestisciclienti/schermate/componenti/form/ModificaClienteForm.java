package com.speearth.view.gestisciclienti.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.GestisciClientiController;
import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.eventi.EventoGestioneCliente;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ModificaClienteForm extends FormView {
	@FXML
	private TextField input_nome;
	@FXML
	private TextField input_cognome;
	@FXML
	private DatePicker input_data_nascita;
	@FXML
	private Button bottone_modifica;
	@FXML
	private TextField input_codice_fiscale;

	/**
	 * Cliente associato alla form
	 */
	private Cliente cliente;

	/**
	 * Controllore di gestione dei clienti
	 */
	GestisciClientiController controller;

	/**
	 * Costruttore con cliente usato per la modifica del cliente
	 * 
	 * @param stage
	 * @param cliente
	 * @throws IOException
	 */
	public ModificaClienteForm(Stage stage, Cliente cliente) throws IOException {
		super(stage);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				stage.close();
			}
		});
		this.cliente = cliente;
		this.controller = GestisciClientiController.getInstance();
		updateUI();
	}

	/**
	 * Imposta il cliente
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Restituisce il cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modifica(ActionEvent event) {
		try {
			if (this.validate()) {
				this.send(null);
				EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.MODIFICA_CLIENTE,
						cliente);
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

	}

	/**
	 * Valida la form
	 */
	@Override
	public boolean validate() {
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
		LocalDate data_nascita = input_data_nascita.getValue();
		if (data_nascita == null) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_DATA_NASCITA);
			return false;
		}
		if (data_nascita.isAfter(LocalDate.now())) {
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DATA_NASCITA_NON_VALIDA);
			return false;
		}
		return true;
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
		String nome = input_nome.getText();
		String cognome = input_cognome.getText();
		String codice_fiscale = input_codice_fiscale.getText();
		Date data_nascita = Date.from(input_data_nascita.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

		if (cliente == null) {
			// creo un nuovo cliente
			cliente = controller.aggiungiCliente(nome, cognome, data_nascita, codice_fiscale);
		} else {
			// modifico il cliente
			cliente = controller.modificaCliente(cliente.getId(), nome, cognome, data_nascita, codice_fiscale);
		}
	}

	/**
	 * Aggiorna la form view
	 */
	@Override
	public void updateUI() {
		if (cliente != null) {
			input_nome.setText(cliente.getNome());
			input_cognome.setText(cliente.getCognome());
			input_codice_fiscale.setText(cliente.getCodiceFiscale());
			input_data_nascita
					.setValue(LocalDate.parse(Costanti.FORMATO_DATA_STANDARD.format(cliente.getDataNascita())));
		}
	}

	/**
	 * Restituisce il nome della risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_MODIFICA_CLIENTE_FORM;
	}
}
