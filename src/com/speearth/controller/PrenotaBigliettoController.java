package com.speearth.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.transazioni.ricerca.RicercaBigliettiCommand;
import com.speearth.model.transazioni.ricerca.RicercaReceiver;

/**
 * Controller per l'estensione PrenotaBiglietto
 */
public class PrenotaBigliettoController implements IFrammentoController {
	/**
	 * Biglietto in prenotazione
	 */
	private Biglietto biglietto;
	
	/**
	 * Unica instanza del controller
	 */
	private static PrenotaBigliettoController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaBigliettoController() {
	}
	
	/**
	 * Restituisce l'instanza del controller
	 */
	public static PrenotaBigliettoController getInstance() {
		if (instance == null)
			instance = new PrenotaBigliettoController();
		return instance;
	}

	/**
	 * Effettua una ricerca di Biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<Biglietto> ricerca(HashMap<String, String> parametri) {

		RicercaReceiver ricerca_receiver = RicercaReceiver.getInstance();
		AgenziaFacade.getInstance().effettuaTransazione(new RicercaBigliettiCommand(ricerca_receiver, parametri));
		ArrayList<IServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
		
		for (IServizioComponent risultato : risultati)
			biglietti.add((Biglietto) risultato);

		return biglietti;
	}

	/**
	 * Conferma la scelta del Biglietto
	 */
	public Biglietto conferma() {
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

}
