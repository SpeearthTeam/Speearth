package com.speearth.controller;

import java.util.ArrayList;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;

public class AcquistaOffertaController implements IFrammentoController {
	/**
	 * Unica istanza del Controller
	 */
	private static AcquistaOffertaController instance;

	/**
	 * Memorizza i Servizi aggiunti al Pacchetto. Serve alla View per
	 * recuperarli quando si torna indietro dalla schermata Riepilogo alla
	 * schermata Ricerca.
	 */
	private ArrayList<ServizioComponent> pacchetto = new ArrayList<>();

	/**
	 * Costruttore di default
	 */
	private AcquistaOffertaController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 * 
	 * @return AcquistaOffertaController
	 */
	public static AcquistaOffertaController getInstance() {
		if (instance == null)
			instance = new AcquistaOffertaController();
		return instance;
	}

	/**
	 * Cerca un'Offerta all'interno del Catalogo dell'Agenzia secondo un valore
	 * 
	 * @param valore
	 * @return ArrayList<Offerta>
	 */
	public ArrayList<Offerta> cercaOfferta(String valore) {
		return AgenziaFacade.getInstance().getCatalogoOfferte().cercaOfferta(valore);
	}

	/**
	 * Serve alla View per recuperare i Servizi contenuti nell'Offerta quando si
	 * torna indietro dalla schermata Riepilogo alla schermata Ricerca.
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> getPacchetto() {
		return this.pacchetto;
	}

	/**
	 * Imposta la lista di Servizi che compongono l'Offerta
	 * 
	 * @param lista_servizi
	 */
	public void setPacchetto(ArrayList<ServizioComponent> lista_servizi) {
		this.pacchetto = lista_servizi;
	}

	/**
	 * Ristabilisce lo stato di partenza del Caso D'Uso
	 */
	public void reset() {
		this.pacchetto = new ArrayList<>();
	}
}
