package model;

/**
 * Registratore di cassa
 */
public class RegistratoreDiCassa {

	/**
	 * Instanza della classe
	 */
	private static RegistratoreDiCassa instance;

	/**
	 * Restiuisce la singola instanza della classe
	 * @return RegistratoreDiCassa
	 */
	public static RegistratoreDiCassa getInstance() {
		if (instance == null)
			instance = new RegistratoreDiCassa();
		return instance;
	}

}