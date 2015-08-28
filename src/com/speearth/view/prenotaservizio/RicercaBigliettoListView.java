package com.speearth.view.prenotaservizio;

import com.speearth.model.core.Biglietto;

import javafx.scene.control.ListCell;

/**
 * Classe che modella la Lista di risultati della ricerca di Alloggi
 */
public class RicercaBigliettoListView extends ListCell<Biglietto> {
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
			RisultatoBigliettoView risultato_biglietto_view = new RisultatoBigliettoView();
			risultato_biglietto_view.impostaInfo(biglietto);
			setGraphic(risultato_biglietto_view.getBorderPane());
		}
	}
}
