package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
	 * Restituisce un Impiegato da un id
	 * 
	 * @param id
	 * @return Impiegato
	 */
	public Impiegato cercaImpiegatoDaID(int id) {
		try {
			ImpiegatoCriteria impiegato = new ImpiegatoCriteria();
			impiegato.id.eq(id);
			return impiegato.uniqueImpiegato();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce un Impiegato dal suo Username
	 * 
	 * @param username
	 * @return Impiegato
	 */
	public Impiegato cercaImpiegatoDaUsername(String username) {
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

	/**
	 * Restituisce una lista di possibili Impiegati in base alla Stringa
	 * inserita
	 * 
	 * @param valore
	 * @return ArrayList<Impiegato>
	 */
	public ArrayList<Impiegato> cercaImpiegatiDaValore(String valore) {
		try {
			ImpiegatoCriteria impiegato = new ImpiegatoCriteria();
			if (valore != null && !valore.isEmpty()) {
				Junction condizioni = Restrictions.disjunction();
				String[] valori = valore.split(" ");
				for (String stringa : valori) {
					condizioni.add(Restrictions.like("username", stringa, MatchMode.START))
							.add(Restrictions.like("nome", stringa, MatchMode.START))
							.add(Restrictions.like("cognome", stringa, MatchMode.START))
							.add(Restrictions.like("codiceFiscale", stringa, MatchMode.ANYWHERE));
				}
				impiegato.add(condizioni);
			}
			return new ArrayList<>(Arrays.asList(impiegato.listImpiegato()));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Aggiunge un nuovo Impiegato nel Sistema
	 * 
	 * @param username
	 * @param password
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param ruolo
	 * @param stipendio
	 * @return Impiegato
	 */
	public Impiegato aggiungiImpiegato(String username, String password, String nome, String cognome, Date data_nascita,
			String codice_fiscale, String ruolo, float stipendio) {
		try {
			Impiegato impiegato = new Impiegato(username, password, nome, cognome, data_nascita, codice_fiscale, ruolo,
					stipendio);
			SpeearthPersistentManager.instance().saveObject(impiegato);
			return impiegato;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Modifica i dati di un Impiegato
	 * 
	 * @param username
	 * @param password
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param ruolo
	 * @param stipendio
	 * @return Impiegato
	 */
	public Impiegato modificaImpiegato(String username, String password, String nome, String cognome, Date data_nascita,
			String codice_fiscale, String ruolo, float stipendio) {
		Impiegato impiegato = this.cercaImpiegatoDaUsername(username);
		if (impiegato != null) {
			impiegato.setNome(nome);
			impiegato.setCognome(cognome);
			impiegato.setPassword(password);
			impiegato.setDataNascita(data_nascita);
			impiegato.setCodiceFiscale(codice_fiscale);
			impiegato.setRuolo(ruolo);
			impiegato.setStipendio(stipendio);
			try {
				SpeearthPersistentManager.instance().saveObject(impiegato);
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		return impiegato;
	}

	/**
	 * Elimina un Impiegato dal Sistema
	 * 
	 * @param impiegato
	 * @return boolean
	 */
	public boolean eliminaImpiegato(Impiegato impiegato) {
		try {
			SpeearthPersistentManager.instance().deleteObject(impiegato);
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

}
