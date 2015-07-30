package model;

import java.util.ArrayList;

/**
 * Classe che rappresenta l'Agenzia
 */
public class Agenzia {

	/**
	 * Instanza della classe
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
	 * Lista di Comandi da eseguire far eseguire ai Sistemi Esterni secondo le
	 * richieste del Cliente
	 */
	private ArrayList<RicercaCommand> comandi;

	/**
	 * Costruttore
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
	 * Restituisce il Registratore di Cassa
	 * 
	 * @return RegistratoreDiCassa
	 */
	public RegistratoreDiCassa getCassa() {
		return this.registratore_cassa;
	}

	/**
	 * Imposta il Registratore di Cassa
	 * 
	 * @param cassa
	 */
	public void setRegistratoreDiCassa(RegistratoreDiCassa cassa) {
		this.registratore_cassa = cassa;
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
	 * Imposta il Registro dei Clienti
	 * 
	 * @param registro_clienti
	 */
	public void setRegistroClienti(RegistroClienti registro_clienti) {
		this.registro_clienti = registro_clienti;
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
	 * Imposta il Registro delle Vendite
	 * 
	 * @param registro_vendite
	 */
	public void setRegistroVendite(RegistroVendite registro_vendite) {
		this.registro_vendite = registro_vendite;
	}

	/**
	 * Aggiunge un nuovo Comando alla lista di Comandi
	 * 
	 * @param comando
	 */
	public void aggiungiComando(RicercaCommand comando) {
		this.comandi.add(comando);
		this.comandi.remove(0).esegui();
	}

}