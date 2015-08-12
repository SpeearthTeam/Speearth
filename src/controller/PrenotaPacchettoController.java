package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.AgenziaFacade;
import model.PacchettoComposite;
import model.RicercaAlloggiCommand;
import model.RicercaBigliettiCommand;
import model.RicercaReceiver;
import model.ServizioComponent;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements CasoDUsoController {
	/**
	 * Pacchetto in prenotazione
	 */
	private PacchettoComposite pacchetto;
	
	/**
	 * Costruttore di default
	 */
	public PrenotaPacchettoController() {
	}

	/**
	 * Avvia l'Estensione
	 */
	@Override
	public void avvia() {
		// TODO
	}

	/**
	 * Chiude L'Estensione
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
	public ArrayList<ServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) {
		return AgenziaFacade.getInstance()
				.effettuaRicerca(new RicercaBigliettiCommand(RicercaReceiver.getInstance(), parametri));
	}

	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) {
		return AgenziaFacade.getInstance()
				.effettuaRicerca(new RicercaAlloggiCommand(RicercaReceiver.getInstance(), parametri));
	}
	
	/**
	 * Aggiunge un Servizio al Pacchetto
	 * 
	 * @param servizio
	 */
	public void aggiungiServizio(ServizioComponent servizio) {
		this.pacchetto.aggiungi(servizio);
	}
	
	/**
	 * Rimuove un Servizio dal Pacchetto
	 * 
	 * @param servizio
	 */
	public void rimuoviServizio(ServizioComponent servizio) {
		this.pacchetto.rimuovi(servizio);
	}
	
	/**
	 * Conferma la scelta del Pacchetto
	 */
	public PacchettoComposite conferma() {
//		this.getBase().setServizio(this.pacchetto);
		return this.pacchetto;
	}

	/**
	 * Restituisce il Pacchetto in prenotazione
	 * 
	 * @return Biglietto
	 */
	public PacchettoComposite getPacchetto() {
		return pacchetto;
	}

	/**
	 * Imposta il Pacchetto in prenotazione
	 * 
	 * @param biglietto
	 */
	public void setPacchetto(PacchettoComposite pacchetto) {
		this.pacchetto = pacchetto;
	}

	/**
	 * Il metodo non si applica in quanto non ha Estensioni o Inclusioni
	 */
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
	public void rimuoviFrammento(CasoDUsoController frammento) {
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
