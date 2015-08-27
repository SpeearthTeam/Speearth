package com.speearth.view.prenotaservizio;

import com.speearth.model.core.Alloggio;

import javafx.scene.control.ListCell;

public class RicercaAlloggioListView extends ListCell<Alloggio> {

	@Override
	protected void updateItem(Alloggio alloggio, boolean empty) {
		super.updateItem(alloggio, empty);
		
		if (alloggio != null) {
			RisultatoAlloggioView risultato_alloggio_view = new RisultatoAlloggioView();
			risultato_alloggio_view.impostaInfo(alloggio);
			setGraphic(risultato_alloggio_view.getBorderPane());
		}
	}
	
}
