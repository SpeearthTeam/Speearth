package com.speearth.view.creaofferta.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Biglietto;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Biglietto
 */
public class BigliettoListItem extends ListCell<Biglietto> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public BigliettoListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 * 
	 * @param item
	 * @param empty
	 */
	@Override
	protected void updateItem(Biglietto biglietto, boolean empty) {
		super.updateItem(biglietto, empty);
		if (biglietto != null) {
			try {
				RisultatoBigliettoItem biglietto_item = new RisultatoBigliettoItem(this.stage, biglietto);
				setGraphic(biglietto_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
