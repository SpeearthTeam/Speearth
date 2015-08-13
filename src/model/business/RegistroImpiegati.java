package model.business;

/**
 * Classe addetta alla gestione del Personale dell'Agenzia
 */
public class RegistroImpiegati {
	/**
	 * Istanza della classe
	 */
	private static RegistroImpiegati instance;

	/**
	 * Costruttore di default
	 */
	protected RegistroImpiegati() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return RegistroClienti
	 */
	public static RegistroImpiegati getInstance() {
		if (instance == null)
			instance = new RegistroImpiegati();
		return instance;
	}

	/**
	 * Restituisce un Commesso da un id
	 * 
	 * @param id
	 * @return Commesso
	 */
	public Commesso getCommessoDaID(int id) {
		//TODO
		return null;
	}

	/**
	 * Restituisce un Commesso dal suo Username
	 * 
	 * @param username
	 * @return Commesso
	 */
	public Commesso getCommessoDaUsername(String username) {
		return new Commesso("Bu", "Bu", "bubu", "passbubu");
	}
}
