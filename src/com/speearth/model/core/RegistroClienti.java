package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

/**
 * Classe addetta alla gestione dei Clienti dell'Agenzia
 */
public class RegistroClienti {
	/**
	 * Unica istanza della Classe
	 */
	private static RegistroClienti instance;

	/**
	 * Costruttore di default
	 */
	protected RegistroClienti() {
	}

	/**
	 * Restituisce la singola istanza della Classe
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
	public ArrayList<Cliente> cercaClientiDaValore(String valore) {
		try {
			ClienteCriteria cliente = new ClienteCriteria();

			if (valore != null && !valore.isEmpty()) {

				Junction condizioni = Restrictions.disjunction();
				String[] valori = valore.split(" ");

				for (String stringa : valori) {
					condizioni.add(Restrictions.like("nome", stringa, MatchMode.START))
							.add(Restrictions.like("cognome", stringa, MatchMode.START))
							.add(Restrictions.like("codiceTessera", stringa, MatchMode.START))
							.add(Restrictions.like("codiceFiscale", stringa, MatchMode.ANYWHERE));
				}

				cliente.add(condizioni);
			}

			return new ArrayList<>(Arrays.asList(cliente.listCliente()));
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
	public Cliente cercaClienteDaCodiceTessera(String codice) {
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
	 * @return Cliente
	 */
	public Cliente aggiungiCliente(String nome, String cognome, Date data_nascita, String codice_fiscale) {
		try {
			Cliente cliente = new Cliente(nome, cognome, data_nascita, codice_fiscale);
			SpeearthPersistentManager.instance().saveObject(cliente);
			return cliente;
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Modifica i dati di un Cliente gi� registrato nel Sistema
	 * 
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return Cliente
	 */
	public Cliente modificaCliente(int id, String nome, String cognome, Date data_nascita, String codice_fiscale) {
		Cliente cliente = this.cercaClienteDaID(id);
		if (cliente != null) {
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setDataNascita(data_nascita);
			cliente.setCodiceFiscale(codice_fiscale);
			try {
				SpeearthPersistentManager.instance().saveObject(cliente);
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
		return cliente;
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