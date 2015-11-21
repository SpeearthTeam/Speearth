package com.speearth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;
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
	 * Memorizza i biglietti cercati. Serve alla View per recuperarli quando si
	 * torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 */
	private ArrayList<Biglietto> biglietti = new ArrayList<>();

	private HashMap<String, String> parametri = new HashMap<>();

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
		ArrayList<ServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

		for (ServizioComponent risultato : risultati)
			biglietti.add((Biglietto) risultato);

		this.parametri = parametri;

		return (this.biglietti = biglietti);
	}

	/**
	 * Serve alla View per recuperare i biglietti quando si torna indietro dalla
	 * schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return biglietti
	 */
	public ArrayList<Biglietto> getBiglietti() {
		return this.biglietti;
	}

	/**
	 * Cancella la lista di Biglietti trovati
	 */
	public void clearBiglietti() {
		this.biglietti = new ArrayList<>();
	}

	/**
	 * Restituisce i parametri di ricerca
	 * 
	 * @return HashMap<String, String> getParametri()
	 */
	public HashMap<String, String> getParametri() {
		return this.parametri;
	}

	/**
	 * Cancella i parametri di ricerca
	 */
	public void clearParametri() {
		this.parametri = new HashMap<>();
	}
	
	/**
	 * Ristabilisce lo stato di partenza del Caso D'Uso
	 */
	public void reset() {
		this.biglietti = null;
		this.parametri = null;
	}

}
