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
 * Classe rappresentante una Vendita effettuata dall'Agenzia
 */
@SuppressWarnings({ "all", "unchecked" })
public class Vendita {
	public Vendita() {
	}
	
	private int id;
	
	private com.speearth.model.core.Impiegato impiegato;
	
	private com.speearth.model.core.ServizioComponent servizio;
	
	private com.speearth.model.core.Pagamento pagamento;
	
	private com.speearth.model.core.Cliente cliente;
	
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
	 * Cliente
	 */
	public void setCliente(com.speearth.model.core.Cliente value) {
		this.cliente = value;
	}
	
	/**
	 * Cliente
	 */
	public com.speearth.model.core.Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Pagamento relativo alla vendita
	 */
	public void setPagamento(com.speearth.model.core.Pagamento value) {
		this.pagamento = value;
	}
	
	/**
	 * Pagamento relativo alla vendita
	 */
	public com.speearth.model.core.Pagamento getPagamento() {
		return pagamento;
	}
	
	public void setServizio(com.speearth.model.core.ServizioComponent value) {
		this.servizio = value;
	}
	
	public com.speearth.model.core.ServizioComponent getServizio() {
		return servizio;
	}
	
	public void setImpiegato(com.speearth.model.core.Impiegato value) {
		this.impiegato = value;
	}
	
	public com.speearth.model.core.Impiegato getImpiegato() {
		return impiegato;
	}
	
	/**
	 * Costruttore con parametri
	 */
	public Vendita(com.speearth.model.core.Cliente cliente, com.speearth.model.core.Pagamento pagamento, com.speearth.model.core.Impiegato impiegato, com.speearth.model.core.ServizioComponent servizio) {
		this.cliente = cliente;
		this.pagamento = pagamento;
		this.impiegato = impiegato;
		this.servizio = servizio;
		this.data = new java.util.Date();
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
