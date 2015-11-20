package com.speearth.model.core;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

/**
 * Classe addetta alla gestione delle Vendite
 */
public class RegistroVendite {

	/**
	 * Istanza della classe
	 */
	private static RegistroVendite instance;

	/**
	 * Costruttore di default
	 */
	protected RegistroVendite() {

	}

	/**
	 * Restituisce la singola istanza della classe
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
			ArrayList<Vendita> vendite = new ArrayList<>(Arrays.asList(vendita.listVendita()));
			return vendite;
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
	 * @param vendita
	 */
	public void registraVendita(Vendita vendita) {
		try {
			SpeearthPersistentManager.instance().saveObject(vendita);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

}