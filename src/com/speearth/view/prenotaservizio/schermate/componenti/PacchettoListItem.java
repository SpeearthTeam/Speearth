package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class PacchettoListItem extends ListCell<ServizioComponent> {

	/**
	 * Stage della list view
	 */
	private Stage stage;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public PacchettoListItem(Stage stage) {
		this.stage = stage;
	}

	@Override
	protected void updateItem(ServizioComponent item, boolean empty) {
		super.updateItem(item, empty);

		if (item != null) {
			try {
				if (item instanceof Alloggio) {
					RiepilogoAlloggioItem alloggio_item = new RiepilogoAlloggioItem(this.stage, (Alloggio) item);
					setGraphic(alloggio_item.getRoot());
				} else if (item instanceof Biglietto) {
					RiepilogoBigliettoItem biglietto_item = new RiepilogoBigliettoItem(this.stage, (Biglietto) item);
					setGraphic(biglietto_item.getRoot());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
