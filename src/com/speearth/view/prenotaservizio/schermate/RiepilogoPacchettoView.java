package com.speearth.view.prenotaservizio.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Cliente;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.core.PacchettoComposite;
import com.speearth.model.core.bonus.IBonus;
import com.speearth.model.core.bonus.ScontoConcreteStrategy;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.prenotaservizio.schermate.componenti.PacchettoListItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RiepilogoPacchettoView extends View {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
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
	private Label output_totale;
	@FXML
	private Label output_tipo_bonus;
	@FXML
	private Button bottone_identifica_cliente;
	@FXML
	private Button bottone_conferma_pagamento;
	@FXML
	private Label input_metodo_pagamento;
	@FXML
	private ListView<IServizioComponent> riepilogo_servizi;
	@FXML
	private Label label_bonus;

	/**
	 * Cliente
	 */
	private Cliente cliente = null;

	private ObservableList<IServizioComponent> lista_servizi = FXCollections.observableArrayList();

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
	 * Imposta le informazioni del Pacchetto prenotato nella View
	 * 
	 * @param pacchetto
	 */
	private void impostaInfoPacchetto(PacchettoComposite pacchetto) {
		this.lista_servizi.setAll(pacchetto.getListaServizi());
		this.riepilogo_servizi.setItems(this.lista_servizi);
		this.output_totale.setText(Float.toString(pacchetto.getPrezzo()));
	}

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RiepilogoPacchettoView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_RIEPILOGO);
		this.impostaInfoPacchetto(
				(PacchettoComposite) AppFacadeController.getInstance().getPrenotaServizioController().getServizio());
	}

	/**
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.riepilogo_servizi.setCellFactory(param -> new PacchettoListItem(getStage()));
		this.riepilogo_servizi.setItems(this.lista_servizi);
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
			AppFacadeController.getInstance().getPrenotaServizioController().getPrenotaAlloggioController()
					.clearAlloggi();
			ScegliServizioView view = new ScegliServizioView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) throws IOException {
		RicercaPacchettoView view = new RicercaPacchettoView(getStage());
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
		return Costanti.FXML_RIEPILOGO_PACCHETTO;
	}
}
