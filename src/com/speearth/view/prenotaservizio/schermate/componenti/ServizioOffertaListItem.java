package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un Servizio
 * contenuto in un'Offerta
 */
public class ServizioOffertaListItem extends ListCell<ServizioComponent> {
	/**
	 * Stage
	 */
	private Stage stage;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 */
	public ServizioOffertaListItem(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Aggiorna l'elemento della Lista
	 * 
	 * @param servizio
	 * @param empty
	 */
	@Override
	protected void updateItem(ServizioComponent servizio, boolean empty) {
		super.updateItem(servizio, empty);
		if (servizio != null) {
			try {
				if (servizio instanceof Alloggio) {
					AlloggioOffertaItem alloggio_item = new AlloggioOffertaItem(this.stage, (Alloggio) servizio);
					setGraphic(alloggio_item.getRoot());
				} else if (servizio instanceof Biglietto) {
					BigliettoOffertaItem biglietto_item = new BigliettoOffertaItem(this.stage, (Biglietto) servizio);
					setGraphic(biglietto_item.getRoot());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
