package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class PacchettoListItem extends ListCell<IServizioComponent> {
	
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
	protected void updateItem(IServizioComponent item, boolean empty) {
		super.updateItem(item, empty);
		
		if (item != null) {
			try {
				if (item instanceof Alloggio) {
					RisultatoAlloggioItem alloggio_item = new RisultatoAlloggioItem(this.stage, (Alloggio) item);
					setGraphic(alloggio_item.getRoot());
				} else if (item instanceof Biglietto) {
					RisultatoBigliettoItem biglietto_item = new RisultatoBigliettoItem(this.stage, (Biglietto) item);
					setGraphic(biglietto_item.getRoot());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
	
}
