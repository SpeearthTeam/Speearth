package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Adapter per l'azienda di trasporto Italo
 */
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
	protected ItaloAdapter() {
	}

	/**
	 * Effettua l'autenticazione da parte dell'agenzia verso il sistema
	 */
	@Override
	public boolean autentica() {
		// effettua il login sul sistema con le credenziali dell'agenzia
		return true;
	}

	/**
	 * Effettua una ricerca di biglietti offerti da Italo secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) {
		ArrayList<ServizioComponent> biglietti = new ArrayList<ServizioComponent>();
		return biglietti;
	}
}