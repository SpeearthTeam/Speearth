package com.speearth.view.prenotaservizio.schermate.componenti;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.IServizioComponent;
import com.speearth.view.prenotaservizio.schermate.RicercaPacchettoView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<IServizioComponent, Boolean> {
	final Button cellButton = new Button("Cancella");

	public ButtonCell() {

		// Action when the button is pressed
		cellButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				// get Selected Item
				IServizioComponent servizio = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
				// remove selected item from the table list
				RicercaPacchettoView view = new RicercaPacchettoView();
				view.getListaServizi().remove(servizio);
				AppFacadeController.getInstance().getPrenotaServizioController().getServizio().rimuovi(servizio);
			}
		});
	}

	// Display button if the row is not empty
	@Override
	protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
		if (!empty) {
			setGraphic(cellButton);
		} else {
			setGraphic(null);
		}
	}
}
