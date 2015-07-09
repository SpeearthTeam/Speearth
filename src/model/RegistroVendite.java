package model;

import java.util.ArrayList;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * Classe addetta alla gestione delle vendite
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
	public ArrayList<Vendita> getVendite(Cliente cliente) {
		// TODO - implement RegistroVendite.getVendite
		return null;
	}

	/**
	 * Registra una Vendita
	 * 
	 * @param vendita
	 */
	public void registraVendita(Vendita vendita) {
		// TODO - implement RegistroVendite.registraVendita
	}

}