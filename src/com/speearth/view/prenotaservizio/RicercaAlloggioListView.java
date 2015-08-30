package com.speearth.view.prenotaservizio;

import java.io.IOException;

import com.speearth.model.core.Alloggio;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che modella la Lista di risultati della ricerca di Alloggi
 */
public class RicercaAlloggioListView extends ListCell<Alloggio> {
	
	/**
	 * Stage della list view
	 */
	private Stage stage;
	
	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 */
	public RicercaAlloggioListView(Stage stage) {
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
				RisultatoAlloggioView risultato_alloggio_view = new RisultatoAlloggioView(this.stage);
				risultato_alloggio_view.impostaInfo(alloggio);
				setGraphic(risultato_alloggio_view.getBorderPane());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
