package com.speearth.view.gestisciclienti.schermate;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.gestisciclienti.eventi.EventoGestioneCliente;
import com.speearth.view.gestisciclienti.schermate.componenti.form.SalvaClienteForm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SalvaClienteView extends View {
	@FXML
	private AnchorPane form_container;
	@FXML
	private Button bottone_indietro;

	/**
	 * View precedente
	 */
	private View previousView;

	/**
	 * Form di salvataggio del cliente
	 */
	private SalvaClienteForm form;

	/**
	 * Cliente
	 */
	private Cliente cliente;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @param previousView
	 * @param cliente
	 * @throws IOException
	 */
	public SalvaClienteView(Stage stage, View previousView, Cliente cliente) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_GESTISCI_CLIENTE);
		this.previousView = previousView;
		setCliente(cliente);

		getRoot().addEventHandler(EventoGestioneCliente.SALVA_CLIENTE, new EventHandler<EventoGestioneCliente>() {

			@Override
			public void handle(EventoGestioneCliente event) {
				setCliente(event.getCliente());
				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_TESSERA_ASSOCIATA, null,
						Costanti.MESSAGGIO_TESSERA_ASSOCIATA + getCliente().getCodiceTessera());

				if (previousView != null) {
					previousView.updateUI();
					previousView.mostra();
				}
			}
		});
	}

	// Event Listener on Button[#bottone_indietro].onAction
	@FXML
	public void vaiIndietro(ActionEvent event) {
		if (previousView != null) {
			previousView.mostra();
		}
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			form = new SalvaClienteForm(getStage(), cliente);
			form_container.getChildren().add(form.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Imposta il cliente
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		if (form != null) {
			form.setCliente(cliente);
			form.updateUI();
		}
	}

	/**
	 * Restituisce il cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Restituisce la risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_SALVA_CLIENTE;
	}
}
