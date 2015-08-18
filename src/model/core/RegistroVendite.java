package model.core;

import java.util.ArrayList;

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
		// TODO - implement RegistroVendite.getVendite
		return null;
	}
	
	/**
	 * Restituisce una Vendita dal suo id
	 * 
	 * @return Vendita
	 */
	public Vendita getVenditaDaID(int id) {
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