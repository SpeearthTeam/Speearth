package com.speearth.model.transazioni;

import java.io.IOException;

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
	public void esegui() throws IOException;

}