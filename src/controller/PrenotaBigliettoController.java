package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.business.AgenziaFacade;
import model.business.Biglietto;
import model.business.ServizioComponent;
import model.tools.RicercaBigliettiCommand;
import model.tools.ToolsFacade;

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
		return AgenziaFacade.getInstance().effettuaRicerca(
				new RicercaBigliettiCommand(ToolsFacade.getInstance().getRicercaRiceiver(), parametri));
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
	public void avviaFrammento(CasoDUsoController frammento) {
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void rimuoviFrammento(CasoDUsoController frammento) {
	}

}
