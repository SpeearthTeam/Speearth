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

/**
 * Popup per l'aggiunta o modifica di un Cliente
 */
public class ClientePopupView extends View {
	@FXML
	private AnchorPane form_container;

	/**
	 * Form
	 */
	private FormView form;

	/**
	 * Cliente
	 */
	private Cliente cliente;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @param cliente
	 * @throws IOException
	 */
	public ClientePopupView(Stage stage, Cliente cliente) throws IOException {
		super(stage);
		this.setCliente(cliente);
		this.getRoot().addEventHandler(EventoGestioneCliente.AGGIUNGI_CLIENTE,
				new EventHandler<EventoGestioneCliente>() {
					@Override
					public void handle(EventoGestioneCliente event) {
						ClientePopupView.this.setCliente(event.getCliente());
						ClientePopupView.this.mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_CLIENTE_AGGIUNTO, null,
								Costanti.MESSAGGIO_CLIENTE_AGGIUNTO
										+ ClientePopupView.this.getCliente().getCodiceTessera());
					}
				});
		this.getRoot().addEventHandler(EventoGestioneCliente.MODIFICA_CLIENTE,
				new EventHandler<EventoGestioneCliente>() {
					@Override
					public void handle(EventoGestioneCliente event) {
						ClientePopupView.this.setCliente(event.getCliente());
					}
				});
		try {
			if (cliente == null) {
				this.form = new AggiungiClienteForm(this.getStage(), cliente);
				this.form_container.getChildren().add(this.form.getRoot());
				this.getStage().setTitle(Costanti.TITOLO_AGGIUNGI_CLIENTE);
			} else {
				this.form = new ModificaClienteForm(this.getStage(), cliente);
				this.form_container.getChildren().add(this.form.getRoot());
				this.getStage().setTitle(Costanti.TITOLO_MODIFICA_CLIENTE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inizializza la View
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.getStage().setHeight(Costanti.DIMENSIONE_ALTEZZA_POPUP_CLIENTE);
		this.getStage().setWidth(Costanti.DIMENSIONE_LARGHEZZA_POPUP_CLIENTE);
		this.getStage().setResizable(false);
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
	 * Restituisce il Cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_CLIENTE_POPUP;
	}
}
