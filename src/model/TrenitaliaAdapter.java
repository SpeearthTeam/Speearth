package model;

import java.util.ArrayList;
import java.util.HashMap;

public class TrenitaliaAdapter implements AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static TrenitaliaAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return TrenitaliaAdapter
	 */
	public static TrenitaliaAdapter getInstance() {
		if (instance == null)
			instance = new TrenitaliaAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	public TrenitaliaAdapter() {
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
	 * Effettua una ricerca di Biglietti offerti da Trenitalia secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	public ArrayList<Biglietto> ricerca(HashMap<String, String> parametri) {
		// TODO Auto-generated method stub
		return null;
	}
}