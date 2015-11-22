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
 * Servizio alloggio
 */
@SuppressWarnings({ "all", "unchecked" })
public class Alloggio extends com.speearth.model.core.ServizioComponent {
	public Alloggio() {
	}
	
	private String fornitore;
	
	private String localita;
	
	private java.util.Date dataArrivo;
	
	private java.util.Date dataPartenza;
	
	private java.util.List<com.speearth.model.core.Stanza> stanze = new java.util.ArrayList<com.speearth.model.core.Stanza>();
	
	/**
	 * Fornitore
	 */
	public void setFornitore(String value) {
		this.fornitore = value;
	}
	
	/**
	 * Fornitore
	 */
	public String getFornitore() {
		return fornitore;
	}
	
	/**
	 * Località
	 */
	public void setLocalita(String value) {
		this.localita = value;
	}
	
	/**
	 * Località
	 */
	public String getLocalita() {
		return localita;
	}
	
	/**
	 * Data di arrivo
	 */
	public void setDataArrivo(java.util.Date value) {
		this.dataArrivo = value;
	}
	
	/**
	 * Data di arrivo
	 */
	public java.util.Date getDataArrivo() {
		return dataArrivo;
	}
	
	/**
	 * Data di partenza
	 */
	public void setDataPartenza(java.util.Date value) {
		this.dataPartenza = value;
	}
	
	/**
	 * Data di partenza
	 */
	public java.util.Date getDataPartenza() {
		return dataPartenza;
	}
	
	/**
	 * Stanze dell'alloggio
	 */
	public void setStanze(java.util.List<com.speearth.model.core.Stanza> value) {
		this.stanze = value;
	}
	
	/**
	 * Stanze dell'alloggio
	 */
	public java.util.List<com.speearth.model.core.Stanza> getStanze() {
		return stanze;
	}
	
	
	/**
	 * Costruttore
	 */
	public Alloggio(String fornitore, String localita, java.util.ArrayList<Stanza> stanze) {
		this.fornitore = fornitore;
		this.localita = localita;
		this.stanze = stanze;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
