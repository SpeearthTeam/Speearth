package model;

/**
 * Registro dei clienti
 */
public class RegistroClienti {

	/**
	 * Instanza della classe
	 */
	private static RegistroClienti instance;

	/**
	 * Restituisce la singola instanza della classe
	 * @return RegistroClienti
	 */
	public static RegistroClienti getInstance() {
		if (instance == null)
			instance = new RegistroClienti();
		return instance;
	}

	/**
	 * Restituisce un cliente da un id
	 * @param id
	 * @return Cliente
	 */
	public Cliente getCliente(int id) {
		// TODO - implement RegistroClienti.getCliente
		return null;
	}

}