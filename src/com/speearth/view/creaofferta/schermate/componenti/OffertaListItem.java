package com.speearth.view.creaofferta.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere i Servizi che
 * compongono un'Offerta
 */
public class OffertaListItem extends ListCell<ServizioComponent> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public OffertaListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 * 
	 * @param item
	 * @param empty
	 */
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
