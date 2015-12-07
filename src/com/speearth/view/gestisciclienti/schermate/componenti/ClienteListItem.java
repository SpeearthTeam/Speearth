package com.speearth.view.gestisciclienti.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Cliente;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Cliente
 */
public class ClienteListItem extends ListCell<Cliente> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public ClienteListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna un elemento della Lista
	 * 
	 * @param cliente
	 * @param empty
	 */
	@Override
	protected void updateItem(Cliente cliente, boolean empty) {
		super.updateItem(cliente, empty);
		if (cliente != null) {
			try {
				RisultatoClienteItem cliente_item = new RisultatoClienteItem(this.stage, cliente);
				this.setGraphic(cliente_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.setGraphic(null);
		}
	}
}
