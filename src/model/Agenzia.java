package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe che gestisce l'agenzia
 */
public class Agenzia {

	/**
	 * Instanza della classe
	 */
	private static Agenzia instance;

	/**
	 * Registro delle vendite
	 */
	private RegistroVendite registro_vendite;

	/**
	 * Registro dei clienti
	 */
	private RegistroClienti registro_clienti;

	/**
	 * Registratore di cassa
	 */
	private RegistratoreDiCassa registratore_cassa;

	/**
	 * Metodo costruttore
	 */
	protected Agenzia() {
		this.registro_vendite = RegistroVendite.getInstance();
		this.registro_clienti = RegistroClienti.getInstance();
		this.registratore_cassa = RegistratoreDiCassa.getInstance();
	}

	/**
	 * Restituisce la singola instanza della classe
	 * 
	 * @return Agenzia
	 */
	public static Agenzia getInstance() {
		if (instance == null)
			instance = new Agenzia();
		return instance;
	}

	/**
	 * Ricerca gli alloggi
	 * 
	 * @param criteria
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<Alloggio> ricercaAlloggi(HashMap<String, String> criteria) {
		// TODO - implement Agenzia.ricercaAlloggi
		return null;
	}

	/**
	 * Ricerca i biglietti
	 * 
	 * @param criteria
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<Biglietto> ricercaBiglietti(HashMap<String, String> criteria) {
		// TODO - implement Agenzia.ricercaBiglietti
		return null;
	}

	/**
	 * Restituisce il registratore di cassa
	 * 
	 * @return RegistratoreDiCassa
	 */
	public RegistratoreDiCassa getCassa() {
		return registratore_cassa;
	}

	/**
	 * Imposta il registratore di cassa
	 * 
	 * @param cassa
	 * @return Agenzia
	 */
	public void setRegistratoreDiCassa(RegistratoreDiCassa cassa) {
		this.registratore_cassa = cassa;
	}

	/**
	 * Restituisce il registro dei clienti
	 * 
	 * @return RegistroClienti
	 */
	public RegistroClienti getRegistroClienti() {
		return registro_clienti;
	}

	/**
	 * Imposta il registro dei clienti
	 * 
	 * @param registro_clienti
	 * @return Agenzia
	 */
	public void setRegistroClienti(RegistroClienti registro_clienti) {
		this.registro_clienti = registro_clienti;
	}

	/**
	 * Restituisce il registro delle vendite
	 * 
	 * @return RegistroVendite
	 */
	public RegistroVendite getRegistroVendite() {
		return registro_vendite;
	}

	/**
	 * Imposta il registro delle vendite
	 * 
	 * @param registro_vendite
	 * @return Agenzia
	 */
	public void setRegistroVendite(RegistroVendite registro_vendite) {
		this.registro_vendite = registro_vendite;
	}

}