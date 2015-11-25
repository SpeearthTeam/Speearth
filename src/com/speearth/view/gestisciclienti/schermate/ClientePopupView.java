package com.speearth.view.gestisciclienti.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoGestioneCliente;
import com.speearth.view.gestisciclienti.schermate.componenti.form.AggiungiClienteForm;
import com.speearth.view.gestisciclienti.schermate.componenti.form.ModificaClienteForm;

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
	private FormView form;

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
		setCliente(cliente);
		getRoot().addEventHandler(EventoGestioneCliente.AGGIUNGI_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				setCliente(event.getCliente());
				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_CLIENTE_AGGIUNTO, null,
						Costanti.MESSAGGIO_CLIENTE_AGGIUNTO + getCliente().getCodiceTessera());
			}
		});

		getRoot().addEventHandler(EventoGestioneCliente.MODIFICA_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				setCliente(event.getCliente());
			}
		});

		try {
			if (cliente == null) {
				form = new AggiungiClienteForm(getStage(), cliente);
				form_container.getChildren().add(form.getRoot());
				getStage().setTitle(Costanti.TITOLO_AGGIUNGI_CLIENTE);
			} else {
				form = new ModificaClienteForm(getStage(), cliente);
				form_container.getChildren().add(form.getRoot());
				getStage().setTitle(Costanti.TITOLO_MODIFICA_CLIENTE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

	/**
	 * Restituisce la risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_CLIENTE_POPUP;
	}
}
