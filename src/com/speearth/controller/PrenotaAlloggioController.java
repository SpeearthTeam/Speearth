package com.speearth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Alloggio;
import com.speearth.model.core.ServizioComponent;
import com.speearth.model.transazioni.ricerca.RicercaAlloggiCommand;
import com.speearth.model.transazioni.ricerca.RicercaReceiver;

/**
 * Controller per l'Estensione PrenotaAlloggio
 */
public class PrenotaAlloggioController implements IFrammentoController {
	/**
	 * Unica istanza della classe
	 */
	private static PrenotaAlloggioController instance;

	/**
	 * Memorizza gli alloggi cercati. Serve alla View per recuperarli quando si
	 * torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 */
	private ArrayList<Alloggio> alloggi = new ArrayList<>();

	/**
	 * Memorizza i parametri di ricerca usati l'ultima volta. Serve alla View
	 * per recuperarli quando si torna indietro dalla schermata Riepilogo alla
	 * schermata Ricerca.
	 */
	private HashMap<String, String> parametri = new HashMap<>();

	/**
	 * Costruttore di default
	 */
	private PrenotaAlloggioController() {
	}

	/**
	 * Restituisce la singola istanza della classe
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
	 * @throws IOException
	 */
	public ArrayList<Alloggio> ricerca(HashMap<String, String> parametri) throws IOException {
		RicercaReceiver ricerca_receiver = RicercaReceiver.getInstance();
		RicercaAlloggiCommand command = new RicercaAlloggiCommand(ricerca_receiver, parametri);
		AgenziaFacade.getInstance().effettuaTransazione(command);
		ArrayList<ServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();

		for (ServizioComponent risultato : risultati)
			alloggi.add((Alloggio) risultato);

		this.parametri = parametri;

		return (this.alloggi = alloggi);
	}

	/**
	 * Serve alla View per recuperare gli Alloggi quando si torna indietro dalla
	 * schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return alloggi
	 */
	public ArrayList<Alloggio> getAlloggi() {
		return this.alloggi;
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
	 * Cancella la lista di Alloggi trovati
	 */
	public void clearAlloggi() {
		this.alloggi = new ArrayList<>();
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
		clearAlloggi();
		clearParametri();
	}
}
