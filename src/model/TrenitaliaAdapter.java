package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Adapter per l'azienda di trasporto Trenitalia
 */
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
	protected TrenitaliaAdapter() {
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
	 * Effettua una ricerca di biglietti offerti da Trenitalia secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) {
		ArrayList<ServizioComponent> biglietti = new ArrayList<ServizioComponent>();
		biglietti.add(new Biglietto());
		
		return biglietti;
	}
}