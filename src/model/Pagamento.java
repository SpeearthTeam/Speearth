package model;

import java.util.Date;

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
	 * Costruttore di default
	 */
	public Pagamento() {
	}

	/**
	 * Restituisce l'id del Pagamento
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id del Pagamento
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce l'Ammontare del Pagamento
	 * 
	 * @return float
	 */
	public float getAmmontare() {
		return this.ammontare;
	}

	/**
	 * Imposta l'Ammontare del Pagamento
	 * 
	 * @param ammontare
	 */
	public void setAmmontare(float ammontare) {
		this.ammontare = ammontare;
	}

	/**
	 * Restituisce la Data del Pagamento
	 * 
	 * @return Date
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * Imposta la Data del Pagamento
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Restituisce la Ricevuta del Pagamento
	 * 
	 * @return String
	 */
	public String generaRicevuta() {
		// TODO - implement Pagamento.generaRicevuta
		return null;
	}
}