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
public class PrenotaAlloggioController implements CasoDUsoController {
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
	 * 
	 * @return Alloggio
	 */
	public Alloggio conferma() {
		this.getCasoDUsoBase().setServizio(this.alloggio);
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

	@Override
	public CasoDUsoController getFrammento(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void aggiungiFrammento(CasoDUsoController gancio) {
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
	@Override
	public void rimuoviFrammento(CasoDUsoController gancio) {
	}

	/**
	 * Restituisce il Caso D'Uso base dell'Estensione
	 * 
	 * @return PrenotaServizioController
	 */
	@Override
	public PrenotaServizioController getCasoDUsoBase() {
		return PrenotaServizioController.getInstance();
	}

}
