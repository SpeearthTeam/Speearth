package com.speearth.model.core;

/**
 * 
 * Classe che modella una Stanza tramite la tipologia e la relativa quantita
 *
 */
public class Stanza {

	/**
	 * Id
	 */
	private int id;

	/**
	 * Tipologia di stanza: singola, doppia, tripla, quadrupla
	 */
	private String tipologia;

	/**
	 * Quantita di una tipologia di stanza
	 */
	private int quantita;

	/**
	 * Costruttore di default
	 */
	public Stanza() {

	}

	/**
	 * Costruttore con parametro tipologia. Imposta internamente la quantita a 1
	 * 
	 * (Da usare quando si vuole creare una tipologia di stanza con quantita 1)
	 * 
	 * @param tipologia
	 */
	public Stanza(String tipologia) {
		this.tipologia = tipologia;
		this.quantita = 1;
	}

	/**
	 * Costruttore con parametri
	 * 
	 * @param tipologia
	 * @param quantita
	 */
	public Stanza(String tipologia, int quantita) {
		this.tipologia = tipologia;
		this.quantita = quantita;
	}

	/**
	 * Restituisce l'id della stanza
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id della stanza
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce la tipologia della stanza
	 * 
	 * @return String
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * Imposta la tipologia della stanza
	 * 
	 * @param tipologia
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * Restituisce la quantita della tipologia di stanza
	 * 
	 * @return
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * Imposta la quantita della tipologia di stanza
	 * 
	 * @param quantita
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
