package com.speearth.controller;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements IFrammentoController {

	/**
	 * Unica istanza del controller
	 */
	private static PrenotaPacchettoController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaPacchettoController() {
	}

	/**
	 * Restituisce l'istanza del controller
	 */
	public static PrenotaPacchettoController getInstance() {
		if (instance == null)
			instance = new PrenotaPacchettoController();
		return instance;
	}

	/**
	 * Restituisce il Controller di PrenotaBiglietto
	 */
	public PrenotaBigliettoController getPrenotaBigliettoController() {
		return PrenotaBigliettoController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaAlloggio
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}
}
