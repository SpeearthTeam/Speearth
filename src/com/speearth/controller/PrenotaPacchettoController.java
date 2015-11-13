package com.speearth.controller;

import java.util.ArrayList;

import com.speearth.model.core.ServizioComponent;

/**
 * Controller per l'Estensione PrenotaPacchetto
 */
public class PrenotaPacchettoController implements IFrammentoController {

	/**
	 * Unica istanza del controller
	 */
	private static PrenotaPacchettoController instance;

	/**
	 * Memorizza i servizi creati nel pacchetto. Serve alla View per recuperarli
	 * quando si torna indietro dalla schermata Riepilogo alla schermata
	 * Ricerca.
	 */
	private ArrayList<ServizioComponent> pacchetto = new ArrayList<>();

	/**
	 * Costruttore di default
	 */
	private PrenotaPacchettoController() {
	}

	/**
	 * Restituisce l'istanza del controller
	 */
	public static PrenotaPacchettoController getInstance() {
		if (instance == null)
			instance = new PrenotaPacchettoController();
		return instance;
	}

	/**
	 * Restituisce il Controller di PrenotaBiglietto
	 */
	public PrenotaBigliettoController getPrenotaBigliettoController() {
		return PrenotaBigliettoController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaAlloggio
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Serve alla View per recuperare i servizi contenuti nel pacchetto quando
	 * si torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return biglietti
	 */
	public ArrayList<ServizioComponent> getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(ArrayList<ServizioComponent> lista_servizi) {
		this.pacchetto = lista_servizi;
	}

	public void clearPacchetto() {
		this.pacchetto = new ArrayList<>();
	}

}
