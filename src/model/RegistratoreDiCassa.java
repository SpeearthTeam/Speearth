package model;

/**
 * Registratore di cassa
 */
public class RegistratoreDiCassa {

	/**
	 * Istanza della classe
	 */
	private static RegistratoreDiCassa instance;

	/**
	 * Restiuisce la singola istanza della classe
	 * @return RegistratoreDiCassa
	 */
	public static RegistratoreDiCassa getInstance() {
		if (instance == null)
			instance = new RegistratoreDiCassa();
		return instance;
	}

}