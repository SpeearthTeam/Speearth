package com.speearth.model.core;

import java.util.ArrayList;

import com.speearth.model.transazioni.ITransazioniCommand;

/**
 * Classe che rappresenta l'Agenzia
 */
public class AgenziaFacade {
	/**
	 * Istanza della classe
	 */
	private static AgenziaFacade instance;

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
	 * Lista di Transazioni generiche da far eseguire ai Sistemi Esterni secondo le
	 * richieste del Cliente
	 */
	private ArrayList<ITransazioniCommand> comandi;

	/**
	 * Costruttore
	 */
	protected AgenziaFacade() {
		this.registro_vendite = RegistroVendite.getInstance();
		this.registro_clienti = RegistroClienti.getInstance();
		this.registratore_cassa = RegistratoreDiCassa.getInstance();
		this.registro_impiegati = RegistroImpiegati.getInstance();
		this.comandi = new ArrayList<ITransazioniCommand>();
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return AgenziaFacade
	 */
	public static AgenziaFacade getInstance() {
		if (instance == null)
			instance = new AgenziaFacade();
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
	 * Effettua una generica Transazione aggiungendo un nuovo Comando alla lista di Comandi
	 * 
	 * @param comando
	 */
	public void effettuaTransazione(ITransazioniCommand comando) {
		this.comandi.add(comando);
		this.comandi.remove(0).esegui();
	}

}