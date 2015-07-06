package model;

import java.util.Date;

/**
 * Classe che descrive il pagamento
 */
public class Pagamento {

	/**
	 * Id
	 */
	private int id;
	
	/**
	 * Ammontare
	 */
	private float ammontare;
	
	/**
	 * Data
	 */
	private Date data;

	/**
	 * Metodo costruttore
	 */
	public Pagamento() {}

	/**
	 * Restituisce l'id
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id
	 * @param id
	 * @return Pagamento
	 */
	public Pagamento setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * Restituisce l'ammontare
	 * @return float
	 */
	public float getAmmontare() {
		return this.ammontare;
	}

	/**
	 * Imposta l'ammontare
	 * @param ammontare
	 * @return Pagamento
	 */
	public Pagamento setAmmontare(float ammontare) {
		this.ammontare = ammontare;
		return this;
	}

	/**
	 * Restituisce la data
	 * @return Date
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * Imposta la data
	 * @param data
	 * @return Pagamento
	 */
	public Pagamento setData(Date data) {
		this.data = data;
		return this;
	}

	/**
	 * Restituisce la ricevuta
	 * @return String
	 */
	public String generaRicevuta() {
		// TODO - implement Pagamento.generaRicevuta
		return null;
	}
}