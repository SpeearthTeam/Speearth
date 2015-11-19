package com.speearth.model.core;

import java.io.IOException;
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
	private RegistroVendite registroVendite;

	/**
	 * Registro dei Clienti
	 */
	private RegistroClienti registroClienti;

	/**
	 * Registro degli Impiegati
	 */
	private RegistroImpiegati registroImpiegati;

	/**
	 * Catalogo delle Offerte
	 */
	private CatalogoOfferte catalogoOfferte;

	/**
	 * Lista di Transazioni generiche da far eseguire ai Sistemi Esterni secondo
	 * le richieste del Cliente
	 */
	private ArrayList<ITransazioniCommand> comandi;

	/**
	 * Costruttore
	 */
	protected AgenziaFacade() {
		this.registroVendite = RegistroVendite.getInstance();
		this.registroClienti = RegistroClienti.getInstance();
		this.registroImpiegati = RegistroImpiegati.getInstance();
		this.catalogoOfferte = CatalogoOfferte.getInstance();
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
	 * Restituisce il Registro dei Clienti
	 * 
	 * @return RegistroClienti
	 */
	public RegistroClienti getRegistroClienti() {
		return this.registroClienti;
	}

	/**
	 * Restituisce il Registro delle Vendite
	 * 
	 * @return RegistroVendite
	 */
	public RegistroVendite getRegistroVendite() {
		return this.registroVendite;
	}

	/**
	 * Restituisce il Registro degli Impiegati
	 * 
	 * @return RegistroImpiegati
	 */
	public RegistroImpiegati getRegistroImpiegati() {
		return this.registroImpiegati;
	}

	/**
	 * Restituisce il Catalogo delle Offerte
	 * 
	 * @return RegistroImpiegati
	 */
	public CatalogoOfferte getCatalogoOfferte() {
		return this.catalogoOfferte;
	}

	/**
	 * Effettua una generica Transazione aggiungendo un nuovo Comando alla lista
	 * di Comandi
	 * 
	 * @param comando
	 * @throws IOException
	 */
	public void effettuaTransazione(ITransazioniCommand comando) throws IOException {
		this.comandi.add(comando);
		this.comandi.remove(0).esegui();
	}

}