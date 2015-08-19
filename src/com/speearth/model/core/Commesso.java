package com.speearth.model.core;

/**
 * Classe che descrive il commesso
 */
public class Commesso {

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
	 * Username
	 */
	private String username;

	/**
	 * Password
	 */
	private String password;

	/**
	 * Costruttore di default
	 */
	public Commesso() {

	}

	/**
	 * Costruttore completo
	 * 
	 * @param nome
	 * @param cognome
	 * @param username
	 * @param password
	 */
	public Commesso(String nome, String cognome, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	/**
	 * Restituisce l'id del Commesso
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id del Commesso
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome del Commesso
	 * 
	 * @return String
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Imposta il nome del Commesso
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il cognome del Commesso
	 * 
	 * @return String
	 */
	public String getCognome() {
		return this.cognome;
	}

	/**
	 * Imposta il cognome del Commesso
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Restituisce lo username del Commesso
	 * 
	 * @return String
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Imposta lo username del Commesso
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Restituisce la password del Commesso
	 * 
	 * @return String
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Imposta la password del Commesso
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}