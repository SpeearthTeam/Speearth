/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.speearth.model.core;

/**
 * Classe rappresentante un Pagamento per un Servizio offerto dall'Agenzia
 */
@SuppressWarnings({ "all", "unchecked" })
public class Pagamento {
	public Pagamento() {
	}
	
	private int id;
	
	private float ammontare;
	
	private String metodo;
	
	private java.util.Date data;
	
	/**
	 * Id
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * Id
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * Ammontare
	 */
	public void setAmmontare(float value) {
		this.ammontare = value;
	}
	
	/**
	 * Ammontare
	 */
	public float getAmmontare() {
		return ammontare;
	}
	
	/**
	 * Metodo di Pagamento
	 */
	public void setMetodo(String value) {
		this.metodo = value;
	}
	
	/**
	 * Metodo di Pagamento
	 */
	public String getMetodo() {
		return metodo;
	}
	
	/**
	 * Data
	 */
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	/**
	 * Data
	 */
	public java.util.Date getData() {
		return data;
	}
	
	/**
	 * Costruttore con parametri
	 */
	public Pagamento(float ammontare, String metodo) {
		this.id = 0;
		this.ammontare = ammontare;
		this.metodo = metodo;
		this.data = new java.util.Date();
	}
	
	/**
	 * Restituisce la Ricevuta del Pagamento
	 */
	public String generaRicevuta() {
		String ricevuta = "Pagamento n°: " + this.id + "\n" + "Ammontare: " + this.ammontare + " €\n"
			+ "Metodo di pagamento: " + this.metodo + "\n" + "Data: " + this.data.toString() + "\n";
		return ricevuta;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
