package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;

import com.speearth.model.core.Offerta;
import com.speearth.view.eventi.EventoSelezionaOfferta;

import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Classe che rifinisce una ListCell per adattarla a contenere un'Offerta
 */
public class OffertaListItem extends ListCell<Offerta> {
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
	 * Aggiorna l'elemento della Lista
	 * 
	 * @param offerta
	 * @param empty
	 */
	@Override
	protected void updateItem(Offerta offerta, boolean empty) {
		super.updateItem(offerta, empty);
		if (offerta != null) {
			try {
				RisultatoOffertaItem offerta_item = new RisultatoOffertaItem(this.stage, offerta);
				this.setGraphic(offerta_item.getRoot());
				offerta_item.getRoot().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						EventoSelezionaOfferta evento = new EventoSelezionaOfferta(
								EventoSelezionaOfferta.OFFERTA_SELEZIONATA, offerta);
						OffertaListItem.this.fireEvent(evento);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
