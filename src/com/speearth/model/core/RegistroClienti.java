package com.speearth.model.core;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

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
	public Cliente cercaClienteDaID(int id) {
		try {
			ClienteCriteria cliente = new ClienteCriteria();
			cliente.id.eq(id);
			return cliente.uniqueCliente();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce una lista di possibili Clienti in base alla Stringa inserita
	 * 
	 * @param valore
	 * @return ArrayList<Cliente>
	 */
	public Cliente[] cercaClientiDaValore(String valore) {
		try {
			ClienteCriteria cliente = new ClienteCriteria();
			Criterion nome = Restrictions.like("Nome", valore);
			Criterion cognome = Restrictions.like("Cognome", valore);
			Criterion codice_fiscale = Restrictions.like("CodiceFiscale", valore);
			Junction condizioni = Restrictions.disjunction();
			condizioni.add(nome).add(cognome).add(codice_fiscale);
			cliente.add(condizioni);
			return cliente.listCliente();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce un Cliente dal Codice della sua Tessera
	 * 
	 * @param codice
	 * @return Cliente
	 */
	public Cliente cercaClienteDaCodiceTessera(int codice) {
		try {
			ClienteCriteria cliente = new ClienteCriteria();
			cliente.codiceTessera.eq(codice);
			return cliente.uniqueCliente();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Aggiunge un nuovo Cliente nel Sistema
	 * 
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return boolean
	 */
	public boolean aggiungiCliente(String nome, String cognome, Date data_nascita, String codice_fiscale) {
		try {
			SpeearthPersistentManager.instance().saveObject(new Cliente(nome, cognome, data_nascita, codice_fiscale));
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Modifica i dati di un Cliente
	 * 
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return boolean
	 */
	public boolean modificaCliente(int id, String nome, String cognome, Date data_nascita, String codice_fiscale) {
		Cliente cliente = this.cercaClienteDaID(id);
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setDataNascita(data_nascita);
		cliente.setCodiceFiscale(codice_fiscale);
		try {
			SpeearthPersistentManager.instance().getSession()
					.saveOrUpdate(cliente);
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Elimina un Cliente dal Sistema
	 * 
	 * @param cliente
	 * @return boolean
	 */
	public boolean eliminaCliente(Cliente cliente) {
		try {
			SpeearthPersistentManager.instance().deleteObject(cliente);
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}
}