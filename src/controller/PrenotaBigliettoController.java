package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.AgenziaFacade;
import model.Biglietto;
import model.RicercaBigliettiCommand;
import model.RicercaReceiver;
import model.ServizioComponent;

/**
 * Controller per l'estensione PrenotaBiglietto
 */
public class PrenotaBigliettoController implements EstensioneController {
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
		return AgenziaFacade.getInstance()
				.effettuaRicerca(new RicercaBigliettiCommand(RicercaReceiver.getInstance(), parametri));
	}
	
	/**
	 * Conferma la scelta del Biglietto
	 */
	public void conferma() {
		// TODO
	}

	/**
	 * Restituisce il Biglietto in prenotazione
	 * 
	 * @return Biglietto
	 */
	public Biglietto getBiglietto() {
		return biglietto;
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
