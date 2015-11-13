package com.speearth.view.prenotaservizio.schermate.componenti.form;

import java.io.IOException;
import java.util.HashMap;

import com.speearth.view.SubView;

import javafx.stage.Stage;

public abstract class FormView extends SubView {

	public FormView(Stage stage) throws IOException {
		super(stage);
	}

	/**
	 * Valida gli input della form
	 */
	public abstract void validate();

	/**
	 * Resituisce i parametri della form
	 */
	public abstract HashMap<String, String> getParameters();

	/**
	 * Invia la richiesta
	 * 
	 * @param parameters
	 * @throws IOException
	 */
	public abstract void send(HashMap<String, String> parameters) throws IOException;

}
