package com.speearth.view;

import java.io.IOException;
import java.util.HashMap;

import javafx.stage.Stage;

/**
 * Classe che modella una generica Form
 */
public abstract class FormView extends SubView {
	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public FormView(Stage stage) throws IOException {
		super(stage);
	}

	/**
	 * Valida gli input della Form
	 * 
	 * @return boolean
	 */
	public abstract boolean valida();

	/**
	 * Resituisce i parametri della Form
	 * 
	 * @return HashMap<String, String>
	 */
	public abstract HashMap<String, String> getParametri();

	/**
	 * Invia la richiesta
	 * 
	 * @param parameters
	 * @throws IOException
	 */
	public abstract void invia(HashMap<String, String> parameters) throws IOException;
}
