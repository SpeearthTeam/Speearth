package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Alloggio
 */
public class AlloggioListItem extends ListCell<Alloggio> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public AlloggioListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna l'elemento della Lista
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
				setGraphic(alloggio_item.getRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
