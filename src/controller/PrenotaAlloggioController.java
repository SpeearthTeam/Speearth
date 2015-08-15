package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.core.AgenziaFacade;
import model.core.Alloggio;
import model.core.IServizioComponent;
import model.transazioni.ricerca.RicercaAlloggiCommand;
import model.transazioni.ricerca.RicercaReceiver;

/**
 * Controller per l'Estensione PrenotaAlloggio
 */
public class PrenotaAlloggioController implements ICasoDUsoController {
	/**
	 * Alloggio in prenotazione
	 */
	private Alloggio alloggio;

	/**
	 * Costruttore di default
	 */
	public PrenotaAlloggioController() {
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
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<IServizioComponent> ricerca(HashMap<String, String> parametri) {
		
		RicercaReceiver ricerca_receiver = RicercaReceiver.getInstance();
		AgenziaFacade.getInstance().effettuaRicerca(new RicercaAlloggiCommand(ricerca_receiver, parametri));
		return ricerca_receiver.getRisultatoRicerca();
		
	}

	/**
	 * Conferma la scelta dell'Alloggio
	 * 
	 * @return Alloggio
	 */
	public Alloggio conferma() {
		this.chiudi();
		return this.alloggio;
	}

	/**
	 * Restituisce l'Allogggio in prenotazione
	 * 
	 * @return Biglietto
	 */
	public Alloggio getAlloggio() {
		return this.alloggio;
	}

	/**
	 * Imposta l'Alloggio in prenotazione
	 * 
	 * @param biglietto
	 */
	public void setAlloggio(Alloggio alloggio) {
		this.alloggio = alloggio;
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
	public void rimuoviFrammento(ICasoDUsoController gancio) {
	}

}
