package model;

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
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param codice_tessera
	 */
	public Cliente(int id, String nome, String cognome, Date data_nascita, String codice_fiscale, int codice_tessera) {
		super();
		this.id = id;
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
	 * @return Cliente
	 */
	public Cliente setId(int id) {
		this.id = id;
		return this;
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
	 * @return Cliente
	 */
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Restituisce il cognome del Cliente
	 * 
	 * @return String
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Imposta il cognome del Cliente
	 * 
	 * @param cognome
	 * @return Cliente
	 */
	public Cliente setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	/**
	 * Restituisce la data di nascita del Cliente
	 * 
	 * @return Date
	 */
	public Date getDataNascita() {
		return data_nascita;
	}

	/**
	 * Imposta la data di nascita del Cliente
	 * 
	 * @param data_nascita
	 * @return Cliente
	 */
	public Cliente setDataNascita(Date data_nascita) {
		this.data_nascita = data_nascita;
		return this;
	}

	/**
	 * Restituisce il codice fiscale del Cliente
	 * 
	 * @return String
	 */
	public String getCodiceFiscale() {
		return codice_fiscale;
	}

	/**
	 * Imposta il codice fiscale del Cliente
	 * 
	 * @param codice_fiscale
	 * @return Cliente
	 */
	public Cliente setCodiceFiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
		return this;
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
	 * @return Cliente
	 */
	public Cliente setCodiceTessera(int codice_tessera) {
		this.codice_tessera = codice_tessera;
		return this;
	}

}