package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Biglietto;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che modella la Lista di risultati della ricerca di Alloggi
 */
public class BigliettoListItem extends ListCell<Biglietto> {
	
	/**
	 * Lo stage della finestra
	 */
	private Stage stage;
	
	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public BigliettoListItem(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Aggiorna un elemento della Lista
	 * 
	 * @param biglietto
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
