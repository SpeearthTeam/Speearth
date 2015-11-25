package com.speearth.view.gestisciclienti.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoGestioneCliente;
import com.speearth.view.gestisciclienti.schermate.componenti.form.ClienteForm;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClientePopupView extends View {
	@FXML
	private AnchorPane form_container;

	/**
	 * Form di salvataggio del cliente
	 */
	private ClienteForm form;

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
	public ClientePopupView(Stage stage, Cliente cliente) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_GESTISCI_CLIENTE);
		setCliente(cliente);
		getRoot().addEventHandler(EventoGestioneCliente.AGGIUNGI_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				setCliente(event.getCliente());
				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_TESSERA_ASSOCIATA, null,
						Costanti.MESSAGGIO_TESSERA_ASSOCIATA + getCliente().getCodiceTessera());
			}
		});
		
		getRoot().addEventHandler(EventoGestioneCliente.MODIFICA_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				setCliente(event.getCliente());
//				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_TESSERA_ASSOCIATA, null,
//						Costanti.MESSAGGIO_TESSERA_ASSOCIATA + getCliente().getCodiceTessera());
			}
		});
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			form = new ClienteForm(getStage(), cliente);
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
		return Costanti.FXML_CLIENTE_POPUP;
	}
}
