package com.speearth.controller;

import com.speearth.model.core.Commesso;
import com.speearth.view.AppFacadeView;

/**
 * Classe di accesso alle funzionalitą del layer Controller
 */
public class AppFacadeController {
	/**
	 * Istanza della Classe
	 */
	private static AppFacadeController instance;

	/**
	 * Utente che sta utilizzando il Sistema
	 */
	private Commesso utente;

	/**
	 * Restituisce la singola instanza della classe
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
	public AppFacadeController() {
	}

	/**
	 * Restituisce l'Utente attuale del Sistema
	 * 
	 * @return
	 */
	public Commesso getUtente() {
		return utente;
	}

	/**
	 * Imposta l'Utente attuale del Sistema
	 * 
	 * @param utente
	 */
	public void setUtente(Commesso utente) {
		this.utente = utente;
	}

	/**
	 * Avvia l'Applicazione
	 * @throws Exception 
	 */
	public void avvia(String[] args) throws Exception {
		// TODO
		AppFacadeView.launch(args);
	}

	/**
	 * Chiude l'Applicazione
	 */
	public void chiudi() {
		// TODO
	}

	/**
	 * Avvia il Caso d'Uso PrenotaServizio
	 */
	public PrenotaServizioController prenotaServizio() {
		return new PrenotaServizioController();
	}
}
