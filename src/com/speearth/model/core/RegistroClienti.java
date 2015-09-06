package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Date;

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
		// TODO
		return null;
	}

	/**
	 * Restituisce una lista di possibili Clienti in base alla Stringa inserita
	 * 
	 * @param nome
	 * @return ArrayList<Cliente>
	 */
	public ArrayList<Cliente> getClientiDaNome(String nome) {
		// TODO
		return null;
	}

	/**
	 * Restituisce un Cliente dal Codice della sua Tessera
	 * 
	 * @param codice
	 * @return Cliente
	 */
	public Cliente getClienteDaCodiceTessera(int codice) {
		// TODO - Cliente fittizio
		if (codice == 123456) {
			Cliente cliente = new Cliente("Mario", "Rossi", new Date(), "MRARSS80A01I804J", 123456);
			return cliente;
		}
		return null;
	}
}