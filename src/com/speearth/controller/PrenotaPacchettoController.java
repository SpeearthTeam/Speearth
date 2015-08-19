package com.speearth.controller;

import com.speearth.model.core.IServizioComponent;
import com.speearth.model.core.PacchettoComposite;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements ICasoDUsoController {
	/**
	 * Pacchetto in prenotazione
	 */
	private PacchettoComposite pacchetto;

	/**
	 * Elenco di Frammenti (Estensioni e/o Inclusioni) del Caso d'Uso
	 */
	private ICasoDUsoController frammento;

	/**
	 * Costruttore di default
	 */
	public PrenotaPacchettoController() {
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
	public void prenotaBiglietto() {
		this.avviaFrammento(new PrenotaBigliettoController());
	}

	/**
	 * Avvia l'Inclusione PrenotaAlloggio
	 */
	public void prenotaAlloggio() {
		this.avviaFrammento(new PrenotaAlloggioController());
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

	/**
	 * Aggiunge un Frammento (Estensione o Inclusione) al Caso D'Uso
	 * 
	 * @param frammento
	 */
	@Override
	public void avviaFrammento(ICasoDUsoController frammento) {
		this.frammento = frammento;
		this.frammento.avvia();
	}

	/**
	 * Rimuove un Frammento (Estensione o Inclusione) dal Caso D'Uso
	 * 
	 * @param frammento
	 */
	@Override
	public void rimuoviFrammento(ICasoDUsoController frammento) {
		this.frammento = null;
	}

}
