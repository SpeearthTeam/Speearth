package com.speearth.model.core;

import java.util.ArrayList;

/**
 * Il pacchetto è un insieme di servizi eterogenei
 */
public class PacchettoComposite extends ServizioComponent {

	/**
	 * Servizi che compongono il pacchetto
	 */
	private ArrayList<ServizioComponent> listaServizi = new ArrayList<>();

	/**
	 * Costruttore di deafault
	 */
	public PacchettoComposite() {

	}

	/**
	 * Costruisce un pacchetto da una lista di servizi
	 * 
	 * @param servizi
	 */
	public PacchettoComposite(ArrayList<ServizioComponent> servizi) {
		this.listaServizi = servizi;
	}

	/**
	 * Aggiunge un Servizio al pacchetto
	 * 
	 * @param ServizioComponent
	 */
	@Override
	public void aggiungi(ServizioComponent servizio) {
		this.listaServizi.add(servizio);
		this.prezzo += servizio.getPrezzo();
	}

	/**
	 * Rimuove un Servizio dal pacchetto
	 */
	@Override
	public void rimuovi(ServizioComponent servizio) {
		if (this.listaServizi.contains(servizio)) {
			this.prezzo -= servizio.getPrezzo();
			this.listaServizi.remove(servizio);
		}
	}

	/**
	 * Restituisce un particolare Servizio del Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	@Override
	public ServizioComponent getServizio(int i) {
		return this.listaServizi.get(i);
	}

	/**
	 * Imposta la lista di Servizi che compongono il Pacchetto
	 * 
	 * @param servizi
	 */
	@Override
	public void setListaServizi(ArrayList<ServizioComponent> servizi) {
		this.listaServizi = servizi;

		float prezzo = 0;
		for (ServizioComponent servizio : this.listaServizi)
			prezzo += servizio.getPrezzo();
		this.setPrezzo(prezzo);
	}

	/**
	 * Restituisce la lista di Servizi che compongono il Pacchetto
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	public ArrayList<ServizioComponent> getListaServizi() {
		return this.listaServizi;
	}

}