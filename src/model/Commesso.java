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
	 * Metodo costruttore
	 */
	public Commesso() {}

	/**
	 * Restituisce l'id
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id
	 * @param id
	 * @return Commesso
	 */
	public Commesso setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * Restituisce il nome
	 * @return String
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Imposta il nome
	 * @param nome
	 * @return Commesso
	 */
	public Commesso setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Restituisce il cognome
	 * @return String
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Imposta il cognome
	 * @param cognome
	 * @return Commesso
	 */
	public Commesso setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}
	
	/**
	 * Restituisce lo username
	 * @return String
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Imposta lo username
	 * @param username
	 * @return Commesso
	 */
	public Commesso setUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Restituisce la password
	 * @return String
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Imposta la password
	 * @param password
	 * @return Commesso
	 */
	public Commesso setPassword(String password) {
		this.password = password;
		return this;
	}


}