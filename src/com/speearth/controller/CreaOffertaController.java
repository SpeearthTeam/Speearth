package com.speearth.controller;

import java.util.ArrayList;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;

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
	private Offerta offerta;

	/**
	 * Memorizza i Servizi aggiunti all'Offerta. Serve alla View per recuperarli
	 * quando si torna indietro dalla schermata Riepilogo alla schermata
	 * Ricerca.
	 */
	private ArrayList<ServizioComponent> lista_servizi = new ArrayList<>();

	/**
	 * Costruttore di default
	 */
	private CreaOffertaController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 * 
	 * @return CreaOffertaController
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
	 * 
	 * @return PrenotaAlloggioController
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Serve alla View per recuperare i Servizi contenuti nell'Offerta quando si
	 * torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> getListaServizi() {
		return lista_servizi;
	}

	/**
	 * Imposta la lista di Servizi che compongono l'Offerta
	 * 
	 * @param lista_servizi
	 */
	public void setListaServizi(ArrayList<ServizioComponent> lista_servizi) {
		this.lista_servizi = lista_servizi;
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
		this.lista_servizi = new ArrayList<>();
		getPrenotaAlloggioController().reset();
		getPrenotaBigliettoController().reset();
	}
}
