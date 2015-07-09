package model;

import java.util.ArrayList;

public class PacchettoComposite implements ServizioComponent {

	private int id;
	private float prezzo;
	private ArrayList<ServizioComponent> servizi;

	/**
	 * Costruttore di deafault
	 */
	public PacchettoComposite() {
	}

	/**
	 * Restituisce il prezzo totale del Pacchetto
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		for (ServizioComponent servizio : this.servizi) {
			this.prezzo += servizio.getTotale();
		}
		return this.getPrezzo();
	}

	/**
	 * Imposta il prezzo totale del Pacchetto
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.setPrezzo(totale);
	}

	/**
	 * Aggiunge un Servizio al Pacchetto
	 * 
	 * @param ServizioComponent
	 */
	@Override
	public void aggiungi(ServizioComponent servizio) {
		this.servizi.add(servizio);
	}

	/**
	 * Rimuove un Servizio dal Pacchetto
	 */
	@Override
	public void rimuovi(ServizioComponent servizio) {
		this.servizi.remove(servizio);
	}

	/**
	 * Restituisce un Servizio incluso nel Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	@Override
	public ServizioComponent getServizio(int indice) {
		return this.servizi.get(indice);
	}

	/**
	 * Restituisce l'id del Pacchetto
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id del Pacchetto
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il prezzo del Pacchetto
	 * 
	 * @return float
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Imposta il prezzo del Pacchetto
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}