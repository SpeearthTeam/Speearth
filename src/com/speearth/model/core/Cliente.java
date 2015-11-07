package com.speearth.model.core;

import java.util.Date;

/**
 * Classe che descrive il cliente
 */
public class Cliente {

	/**
	 * Id
	 */
	private int id;

	/**
	 * Nome
	 */
	private String nome;

	/**
	 * Cognome
	 */
	private String cognome;

	/**
	 * Data di nascita
	 */
	private Date dataNascita;

	/**
	 * Codice fiscale
	 */
	private String codiceFiscale;

	/**
	 * Codice della tessera
	 */
	private int codiceTessera;

	/**
	 * Costruttore di default
	 */
	public Cliente() {
	}

	/**
	 * Costruttore completo
	 * 
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param codice_tessera
	 */
	public Cliente(String nome, String cognome, Date data_nascita, String codice_fiscale, int codice_tessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = data_nascita;
		this.codiceFiscale = codice_fiscale;
		this.codiceTessera = codice_tessera;
	}

	/**
	 * Restituisce l'id del Cliente
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id del Cliente
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome del Cliente
	 * 
	 * @return String
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Imposta il nome del Cliente
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il cognome del Cliente
	 * 
	 * @return String
	 */
	public String getCognome() {
		return this.cognome;
	}

	/**
	 * Imposta il cognome del Cliente
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Restituisce la data di nascita del Cliente
	 * 
	 * @return Date
	 */
	public Date getDataNascita() {
		return this.dataNascita;
	}

	/**
	 * Imposta la data di nascita del Cliente
	 * 
	 * @param data_nascita
	 */
	public void setDataNascita(Date data_nascita) {
		this.dataNascita = data_nascita;
	}

	/**
	 * Restituisce il codice fiscale del Cliente
	 * 
	 * @return String
	 */
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	/**
	 * Imposta il codice fiscale del Cliente
	 * 
	 * @param codice_fiscale
	 */
	public void setCodiceFiscale(String codice_fiscale) {
		this.codiceFiscale = codice_fiscale;
	}

	/**
	 * Restituisce il codice della tessera del Cliente
	 * 
	 * @return String
	 */
	public int getCodiceTessera() {
		return this.codiceTessera;
	}

	/**
	 * Imposta il codice della tessera del Cliente
	 * 
	 * @param codice_tessera
	 */
	public void setCodiceTessera(int codice_tessera) {
		this.codiceTessera = codice_tessera;
	}

}