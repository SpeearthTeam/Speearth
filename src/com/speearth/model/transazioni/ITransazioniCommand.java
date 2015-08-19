package com.speearth.model.transazioni;

/**
 * 
 * Interfaccia rappresentante una generica Transazione che l'Agenzia deve effettuare
 * 
 */
public interface ITransazioniCommand {
	
	/**
	 * 
	 * Fa eseguire il comando al receiver
	 * 
	 */
	public void esegui();

}