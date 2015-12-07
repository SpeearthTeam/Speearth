package com.speearth.controller;

import com.speearth.model.core.Impiegato;

/**
 * Classe di accesso alle funzionalità del layer Controller
 */
public class AppFacadeController {
	/**
	 * Unica istanza del Controller
	 */
	private static AppFacadeController instance;

	/**
	 * Utente che sta utilizzando il Sistema
	 */
	private Impiegato utente;

	/**
	 * Costruttore di default
	 */
	private AppFacadeController() {
	}

	/**
	 * Restituisce la singola istanza del Controller
	 * 
	 * @return AppFacadeController
	 */
	public static AppFacadeController getInstance() {
		if (instance == null)
			instance = new AppFacadeController();
		return instance;
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
	 * Restituisce il Controller di Login
	 * 
	 * @return LoginController
	 */
	public LoginController getLoginController() {
		return LoginController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaServizio
	 * 
	 * @return PrenotaServizioController
	 */
	public PrenotaServizioController getPrenotaServizioController() {
		return PrenotaServizioController.getInstance();
	}

	/**
	 * Restituisce il Controller di CreaOfferta
	 * 
	 * @return CreaOffertaController
	 */
	public CreaOffertaController getCreaOffertaController() {
		return CreaOffertaController.getInstance();
	}

	/**
	 * Restituisce il Controller di GestisciClienti
	 * 
	 * @return GestisciClientiController
	 */
	public GestisciClientiController getGestisciClientiController() {
		return GestisciClientiController.getInstance();
	}

	/**
	 * Restituisce il Controller di GestisciImpiegati
	 * 
	 * @return GestisciImpiegatiController
	 */
	public GestisciImpiegatiController getGestisciImpiegatiController() {
		return GestisciImpiegatiController.getInstance();
	}

	/**
	 * Restituisce il Controller del Caso d'Uso di Startup
	 * 
	 * @return StartupController
	 */
	public StartupController getStartupController() {
		return StartupController.getInstance();
	}
}
