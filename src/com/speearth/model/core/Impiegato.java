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
 * Classe che descrive il commesso
 */
@SuppressWarnings({ "all", "unchecked" })
public class Impiegato {
	public Impiegato() {
	}
	
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private String username;
	
	private String password;
	
	private java.util.Date dataNascita;
	
	private String codiceFiscale;
	
	private String ruolo;
	
	private float stipendio;
	
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
	 * Username
	 */
	public void setUsername(String value) {
		this.username = value;
	}
	
	/**
	 * Username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Password
	 */
	public void setPassword(String value) {
		this.password = value;
	}
	
	/**
	 * Password
	 */
	public String getPassword() {
		return password;
	}
	
	public void setDataNascita(java.util.Date value) {
		this.dataNascita = value;
	}
	
	public java.util.Date getDataNascita() {
		return dataNascita;
	}
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setRuolo(String value) {
		this.ruolo = value;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public void setStipendio(float value) {
		this.stipendio = value;
	}
	
	public float getStipendio() {
		return stipendio;
	}
	
	/**
	 * Costruttore completo
	 */
	public Impiegato(String username, String password, String nome, String cognome, java.util.Date data_nascita, String codice_fiscale, String ruolo, float stipendio) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.codiceFiscale = codice_fiscale;
		this.ruolo = ruolo;
		this.stipendio = stipendio;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
