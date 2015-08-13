package controller;

import model.business.Commesso;

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
	 */
	public void avvia() {
		// TODO
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
	public void prenotaServizio() {
		PrenotaServizioController.getInstance().avvia();
	}
}
