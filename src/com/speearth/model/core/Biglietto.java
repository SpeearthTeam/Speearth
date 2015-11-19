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
 * Servizio biglietto
 */
@SuppressWarnings({ "all", "unchecked" })
public class Biglietto extends com.speearth.model.core.ServizioComponent {
	public Biglietto() {
	}
	
	private String fornitore;
	
	private String partenza;
	
	private String destinazione;
	
	private java.util.Date dataPartenzaAndata;
	
	private java.util.Date dataPartenzaRitorno;
	
	private java.util.Date dataArrivoAndata;
	
	private java.util.Date dataArrivoRitorno;
	
	private int numeroAdulti = 0;
	
	private int numeroBambini = 0;
	
	private String mezzo;
	
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
	 * Partenza
	 */
	public void setPartenza(String value) {
		this.partenza = value;
	}
	
	/**
	 * Partenza
	 */
	public String getPartenza() {
		return partenza;
	}
	
	/**
	 * Destinazione
	 */
	public void setDestinazione(String value) {
		this.destinazione = value;
	}
	
	/**
	 * Destinazione
	 */
	public String getDestinazione() {
		return destinazione;
	}
	
	/**
	 * Data di andata
	 */
	public void setDataPartenzaAndata(java.util.Date value) {
		this.dataPartenzaAndata = value;
	}
	
	/**
	 * Data di andata
	 */
	public java.util.Date getDataPartenzaAndata() {
		return dataPartenzaAndata;
	}
	
	/**
	 * Data di ritorno
	 */
	public void setDataPartenzaRitorno(java.util.Date value) {
		this.dataPartenzaRitorno = value;
	}
	
	/**
	 * Data di ritorno
	 */
	public java.util.Date getDataPartenzaRitorno() {
		return dataPartenzaRitorno;
	}
	
	/**
	 * Data di andata
	 */
	public void setDataArrivoAndata(java.util.Date value) {
		this.dataArrivoAndata = value;
	}
	
	/**
	 * Data di andata
	 */
	public java.util.Date getDataArrivoAndata() {
		return dataArrivoAndata;
	}
	
	/**
	 * Data di ritorno
	 */
	public void setDataArrivoRitorno(java.util.Date value) {
		this.dataArrivoRitorno = value;
	}
	
	/**
	 * Data di ritorno
	 */
	public java.util.Date getDataArrivoRitorno() {
		return dataArrivoRitorno;
	}
	
	/**
	 * Numero di adulti
	 */
	public void setNumeroAdulti(int value) {
		this.numeroAdulti = value;
	}
	
	/**
	 * Numero di adulti
	 */
	public int getNumeroAdulti() {
		return numeroAdulti;
	}
	
	/**
	 * Numero di bambini
	 */
	public void setNumeroBambini(int value) {
		this.numeroBambini = value;
	}
	
	/**
	 * Numero di bambini
	 */
	public int getNumeroBambini() {
		return numeroBambini;
	}
	
	/**
	 * Mezzo
	 */
	public void setMezzo(String value) {
		this.mezzo = value;
	}
	
	/**
	 * Mezzo
	 */
	public String getMezzo() {
		return mezzo;
	}
	
	/**
	 * Costruttore
	 */
	public Biglietto(String fornitore, String partenza, String destinazione, String mezzo) {
		this.fornitore = fornitore;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.mezzo = mezzo;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
