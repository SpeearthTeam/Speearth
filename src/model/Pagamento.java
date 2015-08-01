package model;

import java.util.Date;

/**
 * Classe rappresentante un Pagamento per un Servizio offerto dall'Agenzia
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
	 * Metodo di Pagamento
	 */
	private String metodo;

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
	 * Costruttore con parametri
	 * 
	 * @param ammontare
	 * @param metodo
	 */
	public Pagamento(float ammontare, String metodo) {
		this.ammontare = ammontare;
		this.metodo = metodo;
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
	 * Restituisce il metodo di Pagamento
	 * 
	 * @return String
	 */
	public String getMetodo() {
		return metodo;
	}

	/**
	 * Imposta il metodo di Pagamento
	 * 
	 * @param metodo
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
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