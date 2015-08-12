package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.AgenziaFacade;
import model.Biglietto;
import model.RicercaBigliettiCommand;
import model.RicercaReceiver;
import model.ServizioComponent;

/**
 * Controller per l'estensione PrenotaBiglietto
 */
public class PrenotaBigliettoController implements CasoDUsoController {
	/**
	 * Biglietto in prenotazione
	 */
	private Biglietto biglietto;

	/**
	 * Costruttore di default
	 */
	public PrenotaBigliettoController() {
	}

	/**
	 * Avvia l'Estensione
	 */
	@Override
	public void avvia() {
		// TODO
	}

	/**
	 * Chiude l'Estensione
	 */
	@Override
	public void chiudi() {
		// TODO
	}

	/**
	 * Effettua una ricerca di Biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) {
		return AgenziaFacade.getInstance()
				.effettuaRicerca(new RicercaBigliettiCommand(RicercaReceiver.getInstance(), parametri));
	}

	/**
	 * Conferma la scelta del Biglietto
	 */
	public Biglietto conferma() {
//		this.getBase().setServizio(this.biglietto);
		return this.biglietto;
	}

	/**
	 * Restituisce il Biglietto in prenotazione
	 * 
	 * @return Biglietto
	 */
	public Biglietto getBiglietto() {
		return this.biglietto;
	}

	/**
	 * Imposta il Biglietto in prenotazione
	 * 
	 * @param biglietto
	 */
	public void setBiglietto(Biglietto biglietto) {
		this.biglietto = biglietto;
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public CasoDUsoController getFrammento(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void aggiungiFrammento(CasoDUsoController gancio) {
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void rimuoviFrammento(CasoDUsoController frammento) {
	}

	/**
	 * Restituisce il Caso D'Uso base dell'Estensione
	 * 
	 * @return PrenotaServizioController
	 */
	@Override
	public PrenotaServizioController getCasoDUsoBase() {
		return PrenotaServizioController.getInstance();
	}

}
