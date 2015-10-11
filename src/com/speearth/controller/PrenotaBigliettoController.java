package com.speearth.controller;

import java.io.IOException;
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
	 * Unica istanza del controller
	 */
	private static PrenotaBigliettoController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaBigliettoController() {
	}

	/**
	 * Restituisce l'istanza del controller
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
	 * @throws IOException 
	 */
	public ArrayList<Biglietto> ricerca(HashMap<String, String> parametri) throws IOException {
		RicercaReceiver ricerca_receiver = RicercaReceiver.getInstance();
		RicercaBigliettiCommand command = new RicercaBigliettiCommand(ricerca_receiver, parametri);
		AgenziaFacade.getInstance().effettuaTransazione(command);
		ArrayList<IServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

		for (IServizioComponent risultato : risultati)
			biglietti.add((Biglietto) risultato);

		return biglietti;
	}
}
