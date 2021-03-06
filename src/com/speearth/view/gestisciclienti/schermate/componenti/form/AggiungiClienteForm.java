package com.speearth.view.gestisciclienti.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
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

/**
 * Form per l'aggiunta di un nuovo Cliente
 */
public class AggiungiClienteForm extends FormView {
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

	/**
	 * Cliente
	 */
	private Cliente cliente;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public AggiungiClienteForm(Stage stage) throws IOException {
		super(stage);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				AggiungiClienteForm.this.stage.close();
			}
		});
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
		return this.cliente;
	}

	// Event Listener on Button[#bottone_aggiungi].onAction
	@FXML
	public void aggiungi(ActionEvent event) {
		try {
			if (this.valida()) {
				this.invia(null);
				EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.AGGIUNGI_CLIENTE,
						this.cliente);
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
	}

	/**
	 * Valida gli input della Form
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valida() {
		// Controllo del nome
		if (this.input_nome.getText() == null || this.input_nome.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_NOME);
			return false;
		}
		// Controllo del cognome
		if (this.input_cognome.getText() == null || this.input_cognome.getText().isEmpty()) {
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_DEFINIRE_COGNOME);
			return false;
		}
		// Controllo del codice fiscale
		if (this.input_codice_fiscale.getText() == null || this.input_codice_fiscale.getText().isEmpty()) {
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
		return true;
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
		String nome = this.input_nome.getText();
		String cognome = this.input_cognome.getText();
		String codice_fiscale = this.input_codice_fiscale.getText();
		Date data_nascita = Date
				.from(this.input_data_nascita.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.cliente = AppFacadeController.getInstance().getGestisciClientiController().aggiungiCliente(nome, cognome,
				data_nascita, codice_fiscale);
	}

	/**
	 * Non necessario
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
		return Costanti.FXML_AGGIUNGI_CLIENTE_FORM;
	}
}
