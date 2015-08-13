package model.core;

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
	private Date data_nascita;

	/**
	 * Codice fiscale
	 */
	private String codice_fiscale;

	/**
	 * Codice della tessera
	 */
	private int codice_tessera;

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
		this.data_nascita = data_nascita;
		this.codice_fiscale = codice_fiscale;
		this.codice_tessera = codice_tessera;
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
		return this.data_nascita;
	}

	/**
	 * Imposta la data di nascita del Cliente
	 * 
	 * @param data_nascita
	 */
	public void setDataNascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	/**
	 * Restituisce il codice fiscale del Cliente
	 * 
	 * @return String
	 */
	public String getCodiceFiscale() {
		return this.codice_fiscale;
	}

	/**
	 * Imposta il codice fiscale del Cliente
	 * 
	 * @param codice_fiscale
	 */
	public void setCodiceFiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	/**
	 * Restituisce il codice della tessera del Cliente
	 * 
	 * @return String
	 */
	public int getCodiceTessera() {
		return this.codice_tessera;
	}

	/**
	 * Imposta il codice della tessera del Cliente
	 * 
	 * @param codice_tessera
	 */
	public void setCodiceTessera(int codice_tessera) {
		this.codice_tessera = codice_tessera;
	}

}