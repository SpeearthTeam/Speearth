package com.speearth.view.gestisciimpiegati.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Impiegato;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class ImpiegatoListItem extends ListCell<Impiegato> {

	/**
	 * Stage nella list view
	 */
	private Stage stage;
	
	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public ImpiegatoListItem(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Aggiorna un elemento della lista
	 * 
	 * @param impiegato
	 * @param empty
	 */
	@Override
	protected void updateItem(Impiegato impiegato, boolean empty) {
		super.updateItem(impiegato, empty);
		
		if (impiegato != null) {
			try {
				RisultatoImpiegatoItem impiegato_item = new RisultatoImpiegatoItem(stage, impiegato);
				setGraphic(impiegato_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			setGraphic(null);
		}
	}
}
