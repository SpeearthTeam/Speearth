package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

/**
 * Classe addetta alla gestione delle Vendite
 */
public class RegistroVendite {
	/**
	 * Unica istanza della Classe
	 */
	private static RegistroVendite instance;

	/**
	 * Costruttore di default
	 */
	protected RegistroVendite() {
	}

	/**
	 * Restituisce la singola istanza della Classe
	 * 
	 * @return RegistroVendite
	 */
	public static RegistroVendite getInstance() {
		if (instance == null)
			instance = new RegistroVendite();
		return instance;
	}

	/**
	 * Restituisce le Vendite associate al Cliente
	 * 
	 * @param cliente
	 * @return ArrayList<Vendita>
	 */
	public ArrayList<Vendita> getVenditeDaCliente(Cliente cliente) {
		try {
			VenditaCriteria vendita = new VenditaCriteria();
			vendita.clienteId.eq(cliente.getId());
			return new ArrayList<>(Arrays.asList(vendita.listVendita()));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce una Vendita dal suo id
	 * 
	 * @return Vendita
	 */
	public Vendita getVenditaDaID(int id) {
		try {
			VenditaCriteria vendita;
			vendita = new VenditaCriteria();
			vendita.id.eq(id);
			return vendita.uniqueVendita();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Registra una Vendita
	 * 
	 * @param metodo
	 * @param cliente
	 * @param commesso
	 * @param servizio
	 * @return String
	 */
	public String registraVendita(String metodo, Cliente cliente, Impiegato commesso, ServizioComponent servizio) {
		try {
			Pagamento pagamento = new Pagamento(servizio.getPrezzo(), metodo);
			Vendita vendita = new Vendita(cliente, pagamento, commesso, servizio);
			SpeearthPersistentManager.instance().saveObject(vendita);
			return vendita.getPagamento().generaRicevuta();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
}