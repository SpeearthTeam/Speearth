package com.speearth.view.prenotaservizio;

import java.io.IOException;

import com.speearth.model.core.Biglietto;

import javafx.scene.control.ListCell;
import javafx.stage.Stage;

/**
 * Classe che modella la Lista di risultati della ricerca di Alloggi
 */
public class RicercaBigliettoListView extends ListCell<Biglietto> {
	
	private Stage stage;
	
	public RicercaBigliettoListView(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Aggiorna un elemento della Lista
	 * 
	 * @param biglietto
	 * @param empty
	 */
	@Override
	protected void updateItem(Biglietto biglietto, boolean empty) {
		super.updateItem(biglietto, empty);
		
		if (biglietto != null) {
			RisultatoBigliettoView risultato_biglietto_view;
			try {
				risultato_biglietto_view = new RisultatoBigliettoView(this.stage);
				risultato_biglietto_view.impostaInfo(biglietto);
				setGraphic(risultato_biglietto_view.getBorderPane());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
