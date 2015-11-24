package com.speearth.controller;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Offerta;

/**
 * Controller per il Caso d'Uso Crea Offerta
 */
public class CreaOffertaController implements ICasoDUsoController {
	/**
	 * Unica istanza del Controller
	 */
	private static CreaOffertaController instance;

	/**
	 * Offerta in fase di creazione
	 */
	public Offerta offerta;

	/**
	 * Costruttore di default
	 */
	private CreaOffertaController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 */
	public static CreaOffertaController getInstance() {
		if (instance == null)
			instance = new CreaOffertaController();
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
	 * Applica uno sconto all'Offerta secondo una percentuale
	 * 
	 * @param percentuale
	 */
	public void applicaSconto(float percentuale) {
		this.offerta.applicaSconto(percentuale);
	}

	/**
	 * Salva l'Offerta creata
	 * 
	 * @return boolean
	 */
	public boolean confermaOfferta() {
		return AgenziaFacade.getInstance().getCatalogoOfferte().aggiungiOfferta(this.offerta);
	}

	/**
	 * Restituisce l'Offerta
	 * 
	 * @return Offerta
	 */
	public Offerta getOfferta() {
		return offerta;
	}

	/**
	 * Imposta l'Offerta
	 * 
	 * @param offerta
	 */
	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

	/**
	 * Ristabilisce lo stato di partenza del Caso D'Uso
	 */

	public void reset() {

		this.offerta = null;
	}

}
