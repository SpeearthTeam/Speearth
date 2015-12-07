package com.speearth.view.gestisciclienti.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;
import com.speearth.view.eventi.EventoGestioneCliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Componente che rappresenta un Cliente nella Lista dei Clienti registrati
 */
public class RisultatoClienteItem extends SubView {
	@FXML
	private BorderPane risultato_cliente;
	@FXML
	private Label output_nome;
	@FXML
	private Label output_cognome;
	@FXML
	private Label output_codice_fiscale;
	@FXML
	private Label output_data_nascita;
	@FXML
	private Label output_codice_tessera;
	@FXML
	private Button bottone_modifica;
	@FXML
	private Button bottone_elimina;
	
	/**
	 * Cliente contenuto nella SubView
	 */
	private Cliente cliente;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @param cliente
	 * @throws IOException
	 */
	public RisultatoClienteItem(Stage stage, Cliente cliente) throws IOException {
		super(stage);
		this.setCliente(cliente);
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
		this.output_nome.setText(this.cliente.getNome());
		this.output_cognome.setText(this.cliente.getCognome());
		this.output_codice_fiscale.setText(this.cliente.getCodiceFiscale());
		this.output_data_nascita.setText(Costanti.FORMATO_DATA.format(this.cliente.getDataNascita()));
		this.output_codice_tessera.setText(this.cliente.getCodiceTessera());
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RISULTATO_CLIENTE;
	}
	
	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modificaCliente(ActionEvent event) {
		EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.MODIFICA_CLIENTE, this.cliente);
		this.getRoot().fireEvent(evento);
	}
	
	// Event Listener on Button[#bottone_elimina].onAction
	@FXML
	public void eliminaCliente(ActionEvent event) {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_ELIMINA_CLIENTE,
				null, Costanti.MESSAGGIO_ELIMINA_CLIENTE);
		if (result.get() == ButtonType.OK) {
			EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.ELIMINA_CLIENTE, this.cliente);
			this.getRoot().fireEvent(evento);
		}
	}

	/**
	 * Restituisce il Cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}

	/**
	 * Imposta il Cliente
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Imposta il Cliente ed aggiorna la View
	 * 
	 * @param cliente
	 */
	public void aggiornaCliente(Cliente cliente) {
		this.setCliente(cliente);
		this.aggiornaUI();
	}
}
