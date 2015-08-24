package com.speearth.controller;

import com.speearth.model.core.IServizioComponent;
import com.speearth.model.core.PacchettoComposite;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements IFrammentoController {
	/**
	 * Pacchetto in prenotazione
	 */
	private PacchettoComposite pacchetto;
	
	/**
	 * Unica instanza del controller
	 */
	private static PrenotaPacchettoController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaPacchettoController() {
	}
	
	/**
	 * Restituisce l'instanza del controller
	 */
	public static PrenotaPacchettoController getInstance() {
		if (instance == null)
			instance = new PrenotaPacchettoController();
		return instance;
	}

	/**
	 * Avvia l'Estensione
	 */
	@Override
	public void avvia() {
		// TODO
	}

	/**
	 * Chiude L'Estensione
	 */
	@Override
	public void chiudi() {
		// TODO
	}

	/**
	 * Avvia l'Inclusione PrenotaBiglietto
	 */
	public PrenotaBigliettoController prenotaBiglietto() {
		return PrenotaBigliettoController.getInstance();
	}

	/**
	 * Avvia l'Inclusione PrenotaAlloggio
	 */
	public PrenotaAlloggioController prenotaAlloggio() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Aggiunge un Servizio al Pacchetto
	 * 
	 * @param servizio
	 */
	public void aggiungiServizio(IServizioComponent servizio) {
		this.pacchetto.aggiungi(servizio);
	}

	/**
	 * Rimuove un Servizio dal Pacchetto
	 * 
	 * @param servizio
	 */
	public void rimuoviServizio(IServizioComponent servizio) {
		this.pacchetto.rimuovi(servizio);
	}

	/**
	 * Conferma la scelta del Pacchetto
	 */
	public PacchettoComposite conferma() {
		this.chiudi();
		return this.pacchetto;
	}

	/**
	 * Restituisce il Pacchetto in prenotazione
	 * 
	 * @return Biglietto
	 */
	public PacchettoComposite getPacchetto() {
		return pacchetto;
	}

	/**
	 * Imposta il Pacchetto in prenotazione
	 * 
	 * @param biglietto
	 */
	public void setPacchetto(PacchettoComposite pacchetto) {
		this.pacchetto = pacchetto;
	}

}
