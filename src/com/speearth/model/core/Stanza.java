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
 * Classe che modella una Stanza tramite la tipologia e la relativa quantita
 */
@SuppressWarnings({ "all", "unchecked" })
public class Stanza {
	public Stanza() {
	}
	
	private int id;
	
	private String tipologia;
	
	private int quantita;
	
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
	 * Tipologia di stanza: singola, doppia, tripla, quadrupla
	 */
	public void setTipologia(String value) {
		this.tipologia = value;
	}
	
	/**
	 * Tipologia di stanza: singola, doppia, tripla, quadrupla
	 */
	public String getTipologia() {
		return tipologia;
	}
	
	/**
	 * Quantita di una tipologia di stanza
	 */
	public void setQuantita(int value) {
		this.quantita = value;
	}
	
	/**
	 * Quantita di una tipologia di stanza
	 */
	public int getQuantita() {
		return quantita;
	}
	
	/**
	 * Costruttore con parametro tipologia. Imposta internamente la quantita a 1
	 * 
	 * (Da usare quando si vuole creare una tipologia di stanza con quantita 1
	 */
	public Stanza(String tipologia) {
		this.tipologia = tipologia;
		this.quantita = 1;
	}
	
	/**
	 * Costruttore con parametri
	 */
	public Stanza(String tipologia, int quantita) {
		this.tipologia = tipologia;
		this.quantita = quantita;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
