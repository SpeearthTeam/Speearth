package com.speearth.view.gestisciimpiegati.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Impiegato;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Impiegato
 */
public class ImpiegatoListItem extends ListCell<Impiegato> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public ImpiegatoListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna l'elemento della Lista
	 * 
	 * @param impiegato
	 * @param empty
	 */
	@Override
	protected void updateItem(Impiegato impiegato, boolean empty) {
		super.updateItem(impiegato, empty);
		if (impiegato != null) {
			try {
				RisultatoImpiegatoItem impiegato_item = new RisultatoImpiegatoItem(this.stage, impiegato);
				this.setGraphic(impiegato_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.setGraphic(null);
		}
	}
}
