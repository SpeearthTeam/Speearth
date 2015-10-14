package com.speearth.model.core;

import java.util.ArrayList;

/**
 * Il pacchetto è un insieme di servizi eterogenei
 */
public class PacchettoComposite implements IServizioComponent {

	/**
	 * Id
	 */
	private int id;

	/**
	 * Prezzo del Pacchetto, comprensivo dei prezzi dei singoli Servizi
	 */
	private float prezzo = 0;

	/**
	 * Servizi che compongono il pacchetto
	 */
	private ArrayList<IServizioComponent> lista_servizi = new ArrayList<>();

	/**
	 * Costruttore di deafault
	 */
	public PacchettoComposite() {
		this.lista_servizi = new ArrayList<IServizioComponent>();
	}

	/**
	 * Costruisce un pacchetto da una lista di servizi
	 * 
	 * @param servizi
	 */
	public PacchettoComposite(ArrayList<IServizioComponent> servizi) {
		this.lista_servizi = servizi;
	}

	/**
	 * Restituisce l'id del pacchetto
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id del pacchetto
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il prezzo del pacchetto
	 * 
	 * @return float
	 */
	@Override
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo del pacchetto
	 * 
	 * @param prezzo
	 */
	@Override
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Aggiunge un Servizio al pacchetto
	 * 
	 * @param IServizioComponent
	 */
	@Override
	public void aggiungi(IServizioComponent servizio) {
		this.lista_servizi.add(servizio);
		this.prezzo += servizio.getPrezzo();
	}

	/**
	 * Rimuove un Servizio dal pacchetto
	 */
	@Override
	public void rimuovi(IServizioComponent servizio) {
		if (this.lista_servizi.contains(servizio)) {
			this.prezzo -= servizio.getPrezzo();
			this.lista_servizi.remove(servizio);
		}
	}

	/**
	 * Restituisce un particolare Servizio del Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	@Override
	public IServizioComponent getServizio(int i) {
		return this.lista_servizi.get(i);
	}

	/**
	 * Imposta la lista di Servizi che compongono il Pacchetto
	 * 
	 * @param servizi
	 */
	@Override
	public void setListaServizi(ArrayList<IServizioComponent> servizi) {
		this.lista_servizi = servizi;

		float prezzo = 0;
		for (IServizioComponent servizio : this.lista_servizi)
			prezzo += servizio.getPrezzo();
		this.setPrezzo(prezzo);
	}

	/**
	 * Restituisce la lista di Servizi che compongono il Pacchetto
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	public ArrayList<IServizioComponent> getListaServizi() {
		return this.lista_servizi;
	}

}