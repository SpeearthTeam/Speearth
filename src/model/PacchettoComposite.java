package model;

import java.util.ArrayList;

/**
 * Il pacchetto è un insieme di servizi eterogenei
 */
public class PacchettoComposite implements ServizioComponent {

	/**
	 * Id
	 */
	private int id;

	/**
	 * Prezzo
	 */
	private float prezzo = 0;

	/**
	 * Prezzo totale
	 */
	private float totale = 0;

	/**
	 * Servizi che compongono il pacchetto
	 */
	private ArrayList<ServizioComponent> lista_servizi;

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
	 * Restituisce il prezzo totale del pacchetto
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		return this.totale;
	}

	/**
	 * Imposta il prezzo totale del pacchetto
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.totale = totale;
	}

	/**
	 * Aggiunge un Servizio al pacchetto
	 * 
	 * @param ServizioComponent
	 */
	@Override
	public void aggiungi(ServizioComponent servizio) {
		this.lista_servizi.add(servizio);
		this.prezzo += servizio.getPrezzo();
		this.totale += servizio.getTotale();
	}

	/**
	 * Rimuove un Servizio dal pacchetto
	 */
	@Override
	public void rimuovi(ServizioComponent servizio) {
		if (this.lista_servizi.contains(servizio)) {
			this.prezzo -= servizio.getPrezzo();
			this.totale -= servizio.getTotale();
			this.lista_servizi.remove(servizio);
		}
	}

	/**
	 * Restituisce un particolare Servizio del Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	@Override
	public ServizioComponent getServizio(int i) {
		return this.lista_servizi.get(i);
	}

	@Override
	public void setListaServizi(ArrayList<ServizioComponent> servizi) {
		this.lista_servizi = servizi;

		float prezzo = 0;

		for (ServizioComponent servizio : this.lista_servizi)
			prezzo += servizio.getPrezzo();

		setPrezzo(prezzo);
		setTotale(prezzo);
	}

	/**
	 * Restituisce i servizi relativi al pacchetto
	 */
	@Override
	public ArrayList<ServizioComponent> getListaServizi() {
		return this.lista_servizi;
	}

}