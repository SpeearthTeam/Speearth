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

public class RisultatoClienteItem extends SubView {
	@FXML
	private BorderPane risultato_cliente;
	@FXML
	private Label nome;
	@FXML
	private Label cognome;
	@FXML
	private Label codice_fiscale;
	@FXML
	private Label data_nascita;
	@FXML
	private Label codice_tessera;
	@FXML
	private Button bottone_modifica;
	@FXML
	private Button bottone_elimina;
	
	/**
	 * Cliente contenuto nella subview
	 */
	private Cliente cliente;

	/**
	 * Costruttore con parametro
	 * 
	 * @param stage
	 * @param cliente
	 * @throws IOException
	 */
	public RisultatoClienteItem(Stage stage, Cliente cliente) throws IOException {
		super(stage);
		this.setCliente(cliente);
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
		nome.setText(cliente.getNome());
		cognome.setText(cliente.getCognome());
		codice_fiscale.setText(cliente.getCodiceFiscale());
		data_nascita.setText(Costanti.FORMATO_DATA.format(cliente.getDataNascita()));
		codice_tessera.setText(Integer.toString(cliente.getCodiceTessera()));
	}

	/**
	 * Restituisce la risorsa fxml della subview
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RISULTATO_CLIENTE;
	}
	
	// Event Listener on Button[#bottone_modifica].onAction
	@FXML
	public void modificaCliente(ActionEvent event) {
		EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.MODIFICA_CLIENTE, cliente);
		getRoot().fireEvent(evento);
	}
	
	// Event Listener on Button[#bottone_elimina].onAction
	@FXML
	public void eliminaCliente(ActionEvent event) {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_ELIMINA_CLIENTE,
				null, Costanti.MESSAGGIO_ELIMINA_CLIENTE);
		if (result.get() == ButtonType.OK) {
			EventoGestioneCliente evento = new EventoGestioneCliente(EventoGestioneCliente.ELIMINA_CLIENTE, cliente);
			getRoot().fireEvent(evento);
		}
	}

	/**
	 * Restituisce il cliente
	 */
	public Cliente getCliente() {
		return cliente;
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
	 * Imposta il cliente ed aggiorna la view
	 * 
	 * @param cliente
	 */
	public void updateCliente(Cliente cliente) {
		setCliente(cliente);
		updateUI();
	}
}
