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
 * Classe che modella una Offerta
 */
@SuppressWarnings({ "all", "unchecked" })
public class Offerta extends com.speearth.model.core.PacchettoComposite {
	public Offerta() {
	}
	
	private java.util.Date dataInizio;
	
	private java.util.Date dataFine;
	
	private String nome;
	
	/**
	 * Data di inizio offerta
	 */
	public void setDataInizio(java.util.Date value) {
		this.dataInizio = value;
	}
	
	/**
	 * Data di inizio offerta
	 */
	public java.util.Date getDataInizio() {
		return dataInizio;
	}
	
	/**
	 * Data di fine offerta
	 */
	public void setDataFine(java.util.Date value) {
		this.dataFine = value;
	}
	
	/**
	 * Data di fine offerta
	 */
	public java.util.Date getDataFine() {
		return dataFine;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Costruttore con parametri
	 */
	public Offerta(java.util.Date dataInizio, java.util.Date dataFine, String nome) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.nome = nome;
	}
	
	/**
	 * Applica lo sconto
	 */
	public void applicaSconto(float percentuale) {
		this.prezzo = this.prezzo - (this.prezzo * percentuale / 100);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
