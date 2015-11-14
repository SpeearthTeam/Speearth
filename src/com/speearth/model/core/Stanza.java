package com.speearth.model.core;

/**
 * 
 * Classe che modella una Stanza
 *
 */
public class Stanza {

	/**
	 * Tipologia di stanza: singola, doppia, tripla, quadrupla
	 */
	private String tipologia;

	/**
	 * Costrutturo di default
	 */
	public Stanza() {

	}

	/**
	 * Costruttore con parametri
	 * 
	 * @param tipologia
	 */
	public Stanza(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * Restituisce la tipologia
	 * 
	 * @return String
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * Imposta la tipologia
	 * 
	 * @param tipologia
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
