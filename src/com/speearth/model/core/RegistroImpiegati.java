package com.speearth.model.core;

import org.orm.PersistentException;

/**
 * Classe addetta alla gestione del Personale dell'Agenzia
 */
public class RegistroImpiegati {
	/**
	 * Istanza della classe
	 */
	private static RegistroImpiegati instance;

	/**
	 * Costruttore di default
	 */
	protected RegistroImpiegati() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return RegistroClienti
	 */
	public static RegistroImpiegati getInstance() {
		if (instance == null)
			instance = new RegistroImpiegati();
		return instance;
	}

	/**
	 * Restituisce un Commesso da un id
	 * 
	 * @param id
	 * @return Commesso
	 */
	public Impiegato getCommessoDaID(int id) {
		// TODO
		return null;
	}

	/**
	 * Restituisce un Commesso dal suo Username
	 * 
	 * @param username
	 * @return Commesso
	 */
	public Impiegato getCommessoDaUsername(String username) {
		ImpiegatoCriteria criteria;
		try {
			criteria = new ImpiegatoCriteria();
			criteria.username.eq(username);
			return criteria.uniqueImpiegato();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
