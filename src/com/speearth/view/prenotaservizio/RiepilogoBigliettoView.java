package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.controller.PrenotaBigliettoController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RiepilogoBigliettoView extends View {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Label output_nome_cliente;
	@FXML
	private Label output_cognome_cliente;
	@FXML
	private Label output_data_nascita_cliente;
	@FXML
	private Label output_cf_cliente;
	@FXML
	private TextField input_codice_tessera;
	@FXML
	private Button bottone_identifica_cliente;
	@FXML
	private Label output_tipo_bonus;
	@FXML
	private Label output_totale;
	@FXML
	private Button bottone_conferma_pagamento;
	@FXML
	private Label input_metodo_pagamento;

	/**
	 * Cliente
	 */
	private Cliente cliente = null;

	/**
	 * Biglietto in prenotazione
	 */
	private Biglietto biglietto;

	/**
	 * Imposta le informazioni del Cliente nella View
	 * 
	 * @param cliente
	 */
	private void impostaInfoCliente(Cliente cliente) {
		this.output_cf_cliente.setText(cliente.getCodiceFiscale());
		this.output_cognome_cliente.setText(cliente.getCognome());
		this.output_data_nascita_cliente.setText(cliente.getDataNascita().toString());
		this.output_nome_cliente.setText(cliente.getNome());
	}

	/**
	 * Costruttore della View
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RiepilogoBigliettoView(Stage stage) throws IOException {
		super(stage);
		this.stage.setTitle(Costanti.TITOLO_RIEPILOGO);
		
		PrenotaBigliettoController controller = AppFacadeController.getInstance().getPrenotaServizioController().
				getPrenotaBigliettoController();
		this.biglietto = controller.getBiglietto();
		
		this.output_totale.setText(Float.toString(this.biglietto.getPrezzo()));
	}

	/**
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO caricare le info del servizio
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
				Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO, null);
		if (result.get() == ButtonType.OK) {
			ScegliServizioView view = new ScegliServizioView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) throws IOException {
		mostraPrecedente();
	}

	// Event Listener on Button[#bottone_identifica_cliente].onAction
	@FXML
	public void identificaCliente(ActionEvent event) {
		this.cliente = AppFacadeController.getInstance().getPrenotaServizioController()
				.identificaCliente(this.input_codice_tessera.getText());
		if (cliente != null)
			this.impostaInfoCliente(cliente);
		else
			mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_ERRORE, Costanti.MESSAGGIO_CLIENTE_NON_TROVATO, null);
	}

	// Event Listener on Button[#bottone_conferma_pagamento].onAction
	@FXML
	public void effettuaPagamento(ActionEvent event) {
		String ricevuta = AppFacadeController.getInstance().getPrenotaServizioController()
				.effettuaPagamento(this.cliente, this.input_metodo_pagamento.getText());
		mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_PAGAMENTO_EFFETTUATO,
				Costanti.MESSAGGIO_PAGAMENTO_EFFETTUATO, ricevuta);
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RIEPILOGO_BIGLIETTO;
	}
}