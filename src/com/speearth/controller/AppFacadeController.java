package com.speearth.controller;

import com.speearth.model.core.Impiegato;

/**
 * Classe di accesso alle funzionalità del layer Controller
 */
public class AppFacadeController {
	/**
	 * Istanza della Classe
	 */
	private static AppFacadeController instance;

	/**
	 * Utente che sta utilizzando il Sistema
	 */
	private Impiegato utente;

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return AppFacadeController
	 */
	public static AppFacadeController getInstance() {
		if (instance == null)
			instance = new AppFacadeController();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	private AppFacadeController() {
		this.utente = new Impiegato("Tizio", "Caio", "tiziocaio85", "vbaybzvn");
	}

	/**
	 * Restituisce l'Utente attuale del Sistema
	 * 
	 * @return
	 */
	public Impiegato getUtente() {
		return utente;
	}

	/**
	 * Imposta l'Utente attuale del Sistema
	 * 
	 * @param utente
	 */
	public void setUtente(Impiegato utente) {
		this.utente = utente;
	}

	/**
	 * Restituisce il Controller di PrenotaServizio
	 */
	public PrenotaServizioController getPrenotaServizioController() {
		return PrenotaServizioController.getInstance();
	}
	
	/**
	 * Restituisce il Controller di CreaOfferta
	 */
	public CreaOffertaController getCreaOffertaController() {
		return CreaOffertaController.getInstance();
	}
	
	/**
	 * Restituisce il Controller di GestisciClienti
	 */
	public GestisciClientiController getGestisciClientiController() {
		return GestisciClientiController.getInstance();
	}
	
	/**
	 * Restituisce il Controller del Caso d'Uso di Startup
	 */
	public StartupController getStartupController() {
		return StartupController.getInstance();
	}
}
