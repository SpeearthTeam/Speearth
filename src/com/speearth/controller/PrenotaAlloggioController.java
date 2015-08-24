package com.speearth.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Alloggio;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.transazioni.ricerca.RicercaAlloggiCommand;
import com.speearth.model.transazioni.ricerca.RicercaReceiver;

/**
 * Controller per l'Estensione PrenotaAlloggio
 */
public class PrenotaAlloggioController implements IFrammentoController {
	/**
	 * Alloggio in prenotazione
	 */
	private Alloggio alloggio;
	
	/**
	 * Unica instanza del controller
	 */
	private static PrenotaAlloggioController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaAlloggioController() {
	}
	
	/**
	 * Restituisce l'instanza del controller
	 */
	public static PrenotaAlloggioController getInstance() {
		if (instance == null)
			instance = new PrenotaAlloggioController();
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
		AgenziaFacade.getInstance().effettuaTransazione(new RicercaAlloggiCommand(ricerca_receiver, parametri));
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

}
