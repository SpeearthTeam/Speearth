package com.speearth.view;

import java.io.IOException;

import javafx.stage.Stage;

/**
 * Classe che rappresenta un elemento grafico che compone una View ma ne è
 * indipendente
 */
public abstract class SubView extends View {
	/**
	 * Costruttore della SubView
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public SubView(Stage stage) throws IOException {
		super(stage);
	}

	/**
	 * Aggiorna l'interfaccia grafica della subview
	 */
	public abstract void updateUI();
}
