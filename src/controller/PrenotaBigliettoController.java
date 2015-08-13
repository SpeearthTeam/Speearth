package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.core.AgenziaFacade;
import model.core.Biglietto;
import model.core.IServizioComponent;
import model.ricerca.RicercaBigliettiCommand;
import model.ricerca.RicercaReceiver;

/**
 * Controller per l'estensione PrenotaBiglietto
 */
public class PrenotaBigliettoController implements ICasoDUsoController {
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
	public ArrayList<IServizioComponent> ricerca(HashMap<String, String> parametri) {
		return AgenziaFacade.getInstance().effettuaRicerca(
				new RicercaBigliettiCommand(RicercaReceiver.getInstance(), parametri));
	}

	/**
	 * Conferma la scelta del Biglietto
	 */
	public Biglietto conferma() {
		this.chiudi();
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
	public void avviaFrammento(ICasoDUsoController frammento) {
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void rimuoviFrammento(ICasoDUsoController frammento) {
	}

}
