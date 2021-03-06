package com.speearth.view;

import java.io.IOException;

import javafx.stage.Stage;

/**
 * Classe che rappresenta un elemento grafico che compone una View ma ne �
 * indipendente
 */
public abstract class SubView extends View {
	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public SubView(Stage stage) throws IOException {
		super(stage);
	}
}
