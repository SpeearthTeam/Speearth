package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Servizio
 * contenuto in un Pacchetto
 */
public class ServizioPacchettoListItem extends ListCell<ServizioComponent> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public ServizioPacchettoListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna l'elemento della Lista
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
