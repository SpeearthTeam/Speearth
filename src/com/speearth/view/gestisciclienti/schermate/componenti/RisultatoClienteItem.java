package com.speearth.view.gestisciclienti.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		// TODO Andare sulla schermata di modifica del cliente 
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
