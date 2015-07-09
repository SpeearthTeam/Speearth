package model;

import java.util.ArrayList;

/**
 * Classe addetta alla gestione dei Clienti dell'Agenzia
 */
public class RegistroClienti {

	/**
	 * Istanza della classe
	 */
	private static RegistroClienti instance;
	
	/**
	 * Costruttore di default
	 */
	protected RegistroClienti() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return RegistroClienti
	 */
	public static RegistroClienti getInstance() {
		if (instance == null)
			instance = new RegistroClienti();
		return instance;
	}

	/**
	 * Restituisce un Cliente da un id
	 * 
	 * @param id
	 * @return Cliente
	 */
	public Cliente getClienteDaID(int id) {
		// TODO - implement RegistroClienti.getCliente
		return null;
	}
	
	/**
	 * Restituisce una lista di possibili Clienti in base alla Stringa inserita
	 * 
	 * @param nome
	 * @return ArrayList<Cliente>
	 */
	public ArrayList<Cliente> getClientiDaNome(String nome) {
		return null;
	}

}