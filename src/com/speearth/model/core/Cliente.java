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
 * Classe che descrive il cliente
 */
@SuppressWarnings({ "all", "unchecked" })
public class Cliente {
	public Cliente() {
	}
	
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private java.util.Date dataNascita;
	
	private String codiceFiscale;
	
	private String codiceTessera;
	
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
	 * Nome
	 */
	public void setNome(String value) {
		this.nome = value;
	}
	
	/**
	 * Nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Cognome
	 */
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	/**
	 * Cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Data di nascita
	 */
	public void setDataNascita(java.util.Date value) {
		this.dataNascita = value;
	}
	
	/**
	 * Data di nascita
	 */
	public java.util.Date getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * Codice fiscale
	 */
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	/**
	 * Codice fiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	/**
	 * Codice della tessera
	 */
	public void setCodiceTessera(String value) {
		this.codiceTessera = value;
	}
	
	/**
	 * Codice della tessera
	 */
	public String getCodiceTessera() {
		return codiceTessera;
	}
	
	/**
	 * Costruttore completo
	 */
	public Cliente(int id, String nome, String cognome, java.util.Date data_nascita, String codice_fiscale, String codice_tessera) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.codiceFiscale = codice_fiscale;
		this.codiceTessera = codice_tessera;
	}
	
	/**
	 * Costruttore completo SENZA l'id
	 */
	public Cliente(String nome, String cognome, java.util.Date data_nascita, String codice_fiscale, String codice_tessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.codiceFiscale = codice_fiscale;
		this.codiceTessera = codice_tessera;
	}
	
	/**
	 * Costruttore ad-hoc per la creazione di un Cliente
	 */
	public Cliente(String nome, String cognome, java.util.Date data_nascita, String codice_fiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.codiceFiscale = codice_fiscale;
		
		java.util.Random rn = new java.util.Random();
		float risultato_float = 100000 +  rn.nextFloat() * 900000;
		int risultato_int = Math.round(risultato_float);
		this.codiceTessera = Integer.toString(risultato_int);
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
