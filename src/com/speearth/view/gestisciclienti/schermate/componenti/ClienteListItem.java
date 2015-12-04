package com.speearth.view.gestisciclienti.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Cliente;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class ClienteListItem extends ListCell<Cliente> {

	/**
	 * Stage nella list view
	 */
	private Stage stage;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public ClienteListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna un elemento della lista
	 * 
	 * @param cliente
	 * @param empty
	 */
	@Override
	protected void updateItem(Cliente cliente, boolean empty) {
		super.updateItem(cliente, empty);
		if (cliente != null) {
			try {
				RisultatoClienteItem cliente_item = new RisultatoClienteItem(stage, cliente);
				setGraphic(cliente_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			setGraphic(null);
		}
	}
}
