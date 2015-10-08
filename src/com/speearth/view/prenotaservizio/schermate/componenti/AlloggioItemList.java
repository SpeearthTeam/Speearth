package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che modella la Lista di risultati della ricerca di Alloggi
 */
public class AlloggioItemList extends ListCell<Alloggio> {
	
	/**
	 * Stage della list view
	 */
	private Stage stage;
	
	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public AlloggioItemList(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Aggiorna un elemento della Lista
	 * 
	 * @param alloggio
	 * @param empty
	 */
	@Override
	protected void updateItem(Alloggio alloggio, boolean empty) {
		super.updateItem(alloggio, empty);
		
		if (alloggio != null) {
			try {
				RisultatoAlloggioItem alloggio_item = new RisultatoAlloggioItem(this.stage, alloggio);
				setGraphic(alloggio_item.getParentNode());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
