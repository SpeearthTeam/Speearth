package model;

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
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param username
	 * @param password
	 */
	public Commesso(int id, String nome, String cognome, String username, String password) {
		super();
		this.id = id;
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
	 * @return Commesso
	 */
	public Commesso setId(int id) {
		this.id = id;
		return this;
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
	 * @return Commesso
	 */
	public Commesso setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Restituisce il cognome del Commesso
	 * 
	 * @return String
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Imposta il cognome del Commesso
	 * 
	 * @param cognome
	 * @return Commesso
	 */
	public Commesso setCognome(String cognome) {
		this.cognome = cognome;
		return this;
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
	 * @return Commesso
	 */
	public Commesso setUsername(String username) {
		this.username = username;
		return this;
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
	 * @return Commesso
	 */
	public Commesso setPassword(String password) {
		this.password = password;
		return this;
	}

}