package model;

import java.util.ArrayList;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * Classe addetta alla gestione delle vendite
 */
public class RegistroVendite {

	/**
	 * Instanza della classe
	 */
	private static RegistroVendite instance;

	/**
	 * Metodo costruttore
	 */
	protected RegistroVendite() {}

	/**
	 * Restituisce la singola instanza della classe
	 * @return RegistroVendite
	 */
	public static RegistroVendite getInstance() {
		if (instance == null)
			instance = new RegistroVendite();
		return instance;
	}

	/**
	 * Restituisce le vendite associate al cliente
	 * @param cliente
	 * @return ArrayList<Vendita>
	 */
	public ArrayList<Vendita> getVendite(Cliente cliente) {
		// TODO - implement RegistroVendite.getVendite
		return null;
	}

	/**
	 * Registra una vendita
	 * @param vendita
	 */
	public void registraVendita(Vendita vendita) {
		// TODO - implement RegistroVendite.registraVendita
	}

}