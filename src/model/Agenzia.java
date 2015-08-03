package model;

import java.util.ArrayList;

/**
 * Classe che rappresenta l'Agenzia
 */
public class Agenzia {
	/**
	 * Istanza della classe
	 */
	private static Agenzia instance;

	/**
	 * Registro delle Vendite
	 */
	private RegistroVendite registro_vendite;

	/**
	 * Registro dei Clienti
	 */
	private RegistroClienti registro_clienti;

	/**
	 * Registratore di Cassa
	 */
	private RegistratoreDiCassa registratore_cassa;

	/**
	 * Registro degli Impiegati
	 */
	private RegistroImpiegati registro_impiegati;

	/**
	 * Lista di Comandi da eseguire far eseguire ai Sistemi Esterni secondo le
	 * richieste del Cliente
	 */
	private ArrayList<RicercaCommand> comandi;

	/**
	 * Utente che sta utilizzando il Software al momento
	 */
	private Commesso utente = null;

	/**
	 * Costruttore
	 */
	protected Agenzia() {
		this.registro_vendite = RegistroVendite.getInstance();
		this.registro_clienti = RegistroClienti.getInstance();
		this.registratore_cassa = RegistratoreDiCassa.getInstance();
		this.registro_impiegati = RegistroImpiegati.getInstance();
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
	 * Restituisce il Registratore di Cassa
	 * 
	 * @return RegistratoreDiCassa
	 */
	public RegistratoreDiCassa getRegistratoreDiCassa() {
		return this.registratore_cassa;
	}

	/**
	 * Restituisce il Registro dei Clienti
	 * 
	 * @return RegistroClienti
	 */
	public RegistroClienti getRegistroClienti() {
		return this.registro_clienti;
	}

	/**
	 * Restituisce il Registro delle Vendite
	 * 
	 * @return RegistroVendite
	 */
	public RegistroVendite getRegistroVendite() {
		return this.registro_vendite;
	}

	/**
	 * Restituisce il Registro degli Impiegati
	 * 
	 * @return RegistroImpiegati
	 */
	public RegistroImpiegati getRegistroImpiegati() {
		return this.registro_impiegati;
	}

	/**
	 * Restituisce l'Utente che sta utilizzando il Software al momento
	 * 
	 * @return RegistroVendite
	 */
	public Commesso getUtente() {
		return utente;
	}

	/**
	 * Imposta l'Utente che sta utilizzando il Software al momento
	 * 
	 * @param utente
	 */
	public void setUtente(Commesso utente) {
		this.utente = utente;
	}

	/**
	 * Autentica un Utente del Software tramite username e password
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean autenticaUtente(String username, String password) {
		Commesso commesso = this.registro_impiegati.getCommessoDaUsername(username);
		if (commesso != null) {
			if (commesso.getPassword() == password) {
				this.setUtente(commesso);
				return true;
			}
		}
		return false;
	}

	/**
	 * Disautentica un Utente del Software
	 */
	public void disautenticaUtente() {
		this.setUtente(null);
	}

	/**
	 * Effettua una ricerca di Servizi aggiungendo un nuovo Comando di Ricerca
	 * alla lista di Comandi
	 * 
	 * @param comando
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> effettuaRicerca(RicercaCommand comando) {
		this.comandi.add(comando);
		return this.comandi.remove(0).esegui();
	}

}