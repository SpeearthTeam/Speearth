package com.speearth.controller;

import java.io.IOException;
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
	 * Unica istanza della classe
	 */
	private static PrenotaAlloggioController instance;
	
	/**
	 * Memorizza gli alloggi cercati. Serve alla View per recuperarli quando si
	 * torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 */
	private ArrayList<Alloggio> alloggi = new ArrayList<>();

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
		ArrayList<IServizioComponent> risultati = ricerca_receiver.getRisultatoRicerca();
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();

		for (IServizioComponent risultato : risultati)
			alloggi.add((Alloggio) risultato);

		return (this.alloggi = alloggi);
	}
	
	/**
	 * Serve alla View per recuperare gli alloggi quando si torna indietro dalla
	 * schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return alloggi
	 */
	public ArrayList<Alloggio> getAlloggi() {
		return this.alloggi;
	}
	
	public void clearAlloggi(){
		this.alloggi = new ArrayList<>();
	}
	
}
