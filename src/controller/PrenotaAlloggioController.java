package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.AgenziaFacade;
import model.Alloggio;
import model.RicercaAlloggiCommand;
import model.RicercaReceiver;
import model.ServizioComponent;

/**
 * Controller per l'Estensione PrenotaAlloggio
 */
public class PrenotaAlloggioController implements EstensioneController {
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
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) {
		return AgenziaFacade.getInstance()
				.effettuaRicerca(new RicercaAlloggiCommand(RicercaReceiver.getInstance(), parametri));
	}
	
	/**
	 * Conferma la scelta dell'Alloggio
	 */
	public Alloggio conferma() {
		this.getBase().setServizio(this.alloggio);
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
	 * Restituisce il Caso d'Uso base al quale appartiene
	 * 
	 * @return CasoDUsoController
	 */
	@Override
	public PrenotaServizioController getBase() {
		return PrenotaServizioController.getInstance();
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public GancioController getGancio(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void rimuoviGancio(GancioController gancio) {
	}

}
