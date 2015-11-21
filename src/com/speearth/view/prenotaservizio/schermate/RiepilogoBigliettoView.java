package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.Cliente;
import com.speearth.model.core.bonus.IBonus;
import com.speearth.model.core.bonus.ScontoConcreteStrategy;
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
	private Button bottone_conferma_pagamento;
	@FXML
	private Button bottone_identifica_cliente;
	@FXML
	private Label input_metodo_pagamento;
	@FXML
	private TextField input_codice_tessera;
	@FXML
	private Label output_nome_cliente;
	@FXML
	private Label output_cognome_cliente;
	@FXML
	private Label output_data_nascita_cliente;
	@FXML
	private Label output_cf_cliente;
	@FXML
	private Label output_tipo_bonus;
	@FXML
	private Label output_totale;
	@FXML
	private Label output_fornitore;
	@FXML
	private Label output_partenza;
	@FXML
	private Label output_destinazione;
	@FXML
	private Label output_partenza_andata;
	@FXML
	private Label output_arrivo_andata;
	@FXML
	private Label output_partenza_ritorno;
	@FXML
	private Label output_arrivo_ritorno;
	@FXML
	private Label output_adulti;
	@FXML
	private Label output_bambini;
	@FXML
	private Label label_bonus;

	/**
	 * Cliente
	 */
	private Cliente cliente = null;

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
	 * Imposta le informazioni del Biglietto prenotato nella View
	 * 
	 * @param biglietto
	 */
	private void impostaInfoBiglietto(Biglietto biglietto) {
		this.output_totale.setText(Float.toString(biglietto.getPrezzo()));
		this.output_adulti.setText(Integer.toString(biglietto.getNumeroAdulti()));
		this.output_arrivo_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoAndata()));
		this.output_arrivo_ritorno.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoRitorno()));

		this.output_bambini.setText(Integer.toString(biglietto.getNumeroBambini()));
		this.output_destinazione.setText(biglietto.getDestinazione());
		this.output_fornitore.setText(biglietto.getFornitore());
		this.output_partenza.setText(biglietto.getPartenza());
		this.output_partenza_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaAndata()));
		this.output_partenza_ritorno.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaRitorno()));
	}

	/**
	 * Costruttore della View
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RiepilogoBigliettoView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_RIEPILOGO);
		this.impostaInfoBiglietto(
				(Biglietto) AppFacadeController.getInstance().getPrenotaServizioController().getServizio());
	}

	/**
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
				Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO, null);
		if (result.get() == ButtonType.OK) {
			AppFacadeController.getInstance().getPrenotaServizioController().setServizio(null);
			AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController()
					.clearBiglietti();
			ScegliServizioView view = new ScegliServizioView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) throws IOException {
		RicercaBigliettoView view = new RicercaBigliettoView(getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_identifica_cliente].onAction
	@FXML
	public void identificaCliente(ActionEvent event) {
		if (!this.input_codice_tessera.getText().isEmpty()) {
			this.cliente = AppFacadeController.getInstance().getPrenotaServizioController()
					.identificaCliente(Integer.parseInt(this.input_codice_tessera.getText()));
			if (cliente != null) {
				this.impostaInfoCliente(cliente);
				AppFacadeController.getInstance().getPrenotaServizioController().setCliente(cliente);
				IBonus bonus = AppFacadeController.getInstance().getPrenotaServizioController().calcolaBonus(cliente);
				if (bonus != null) {
					this.label_bonus.setVisible(true);
					this.output_totale
							.setText(Float.toString(AppFacadeController.getInstance().getPrenotaServizioController()
									.applicaBonus(bonus, new ScontoConcreteStrategy()).getPrezzo()));
				}
			} else
				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_NON_TROVATO, null,
						Costanti.MESSAGGIO_CLIENTE_NON_TROVATO);
		} else
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_NESSUN_CODICE);
	}

	// Event Listener on Button[#bottone_conferma_pagamento].onAction
	@FXML
	public void effettuaPagamento(ActionEvent event) throws IOException {
		// TODO - Ipotesi semplificativa: pagamento in contanti
		if (AppFacadeController.getInstance().getPrenotaServizioController().getCliente() == null) {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_NESSUN_CLIENTE, null,
					Costanti.MESSAGGIO_NESSUN_CLIENTE);
			if (result.get() == ButtonType.CANCEL) {
				return;
			}
		}
		String ricevuta = AppFacadeController.getInstance().getPrenotaServizioController()
				.effettuaPagamento("contanti");
		mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_PAGAMENTO_EFFETTUATO,
				Costanti.MESSAGGIO_PAGAMENTO_EFFETTUATO, ricevuta);
		AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaBigliettoController().reset();
		AppFacadeController.getInstance().getPrenotaServizioController().reset();
		ScegliServizioView view = new ScegliServizioView(getStage());
		view.mostra();
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
