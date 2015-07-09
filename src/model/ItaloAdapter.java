package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ItaloAdapter implements AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static ItaloAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return ItaloAdapter
	 */
	public static ItaloAdapter getInstance() {
		if (instance == null)
			instance = new ItaloAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	public ItaloAdapter() {
	}

	/**
	 * Effettua l'autenticazione da parte dell'Agenzia verso il Sistema
	 * 
	 * @param username
	 * @param password
	 */
	@Override
	public boolean autentica(String username, String password) {
		// effettua il login sul Sistema con le credenziali dell'Agenzia
		return true;
	}

	/**
	 * Effettua una ricerca di Biglietti offerti da Italo secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	@Override
	public ArrayList<Biglietto> ricerca(HashMap<String, String> parametri) {
		// TODO Auto-generated method stub
		return null;
	}
}