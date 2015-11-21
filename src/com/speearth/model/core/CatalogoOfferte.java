package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

/**
 * Classe addetta alla gestione dei Offerte dell'Agenzia
 */
public class CatalogoOfferte {
	/**
	 * Istanza della classe
	 */
	private static CatalogoOfferte instance;

	/**
	 * Costruttore di default
	 */
	protected CatalogoOfferte() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return CatalogoOfferte
	 */
	public static CatalogoOfferte getInstance() {
		if (instance == null)
			instance = new CatalogoOfferte();
		return instance;
	}

	/**
	 * Restituisce un Offerta da un id
	 * 
	 * @param id
	 * @return Offerta
	 */
	public Offerta getOffertaDaID(int id) {
		try {
			OffertaCriteria Offerta = new OffertaCriteria();
			Offerta.id.eq(id);
			return Offerta.uniqueOfferta();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce tutte le Offerte disponibili
	 * 
	 * @return ArrayList<Offerta>
	 */
	public ArrayList<Offerta> getOfferte() {
		try {
			return new ArrayList<>(Arrays.asList(new OffertaCriteria().listOfferta()));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Aggiunge una nuova Offerta nel Sistema
	 * 
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return boolean
	 */
	public boolean aggiungiOfferta(Offerta offerta) {
		try {
			SpeearthPersistentManager.instance().saveObject(offerta);
			SpeearthPersistentManager.instance().getSession().flush();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Elimina un Offerta dal Sistema
	 * 
	 * @param offerta
	 * @return boolean
	 */
	public boolean eliminaOfferta(Offerta offerta) {
		try {
			SpeearthPersistentManager.instance().deleteObject(offerta);
			SpeearthPersistentManager.instance().getSession().flush();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}
}