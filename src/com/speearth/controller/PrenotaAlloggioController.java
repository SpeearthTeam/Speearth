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
	 * Istanza della classe
	 */
	private static PrenotaAlloggioController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaAlloggioController() {
	}
	
	/**
	 * Restituisce la singola instanza della classe
	 * 
	 * @return PrenotaAlloggioController
	 */
	public static PrenotaAlloggioController getInstance() {
		if (instance == null)
			instance = new PrenotaAlloggioController();
		return instance;
	}

	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<Alloggio> ricerca(HashMap<String, String> parametri) {
		RicercaReceiver ricerca_receiver = RicercaReceiver.getInstance();
		ricerca_receiver.svuotaRisultatiRicerca();
		RicercaAlloggiCommand command = new RicercaAlloggiCommand(ricerca_receiver, parametri);
		AgenziaFacade.getInstance().effettuaTransazione(command);
		ArrayList<IServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();
		
		for (IServizioComponent risultato : risultati)
			alloggi.add((Alloggio) risultato);
		
		return alloggi;
	}

	/**
	 * Conferma la scelta dell'Alloggio
	 * 
	 * @return Alloggio
	 */
	public Alloggio conferma() {
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
