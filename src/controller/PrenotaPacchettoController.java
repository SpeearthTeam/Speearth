package controller;

import model.business.PacchettoComposite;
import model.business.ServizioComponent;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements CasoDUsoController {
	/**
	 * Pacchetto in prenotazione
	 */
	private PacchettoComposite pacchetto;

	/**
	 * Elenco di Frammenti (Estensioni e/o Inclusioni) del Caso d'Uso
	 */
	private CasoDUsoController frammento;

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
	public void aggiungiServizio(ServizioComponent servizio) {
		this.pacchetto.aggiungi(servizio);
	}

	/**
	 * Rimuove un Servizio dal Pacchetto
	 * 
	 * @param servizio
	 */
	public void rimuoviServizio(ServizioComponent servizio) {
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
	public void avviaFrammento(CasoDUsoController frammento) {
		this.frammento = frammento;
		this.frammento.avvia();
	}

	/**
	 * Rimuove un Frammento (Estensione o Inclusione) dal Caso D'Uso
	 * 
	 * @param frammento
	 */
	@Override
	public void rimuoviFrammento(CasoDUsoController frammento) {
		this.frammento = null;
	}

}
