package com.speearth.model.transazioni;

import java.io.IOException;

/**
 * Interfaccia rappresentante una generica Transazione effettuata dall'Agenzia
 */
public interface ITransazioniCommand {
	/**
	 * Fa eseguire il Command al rispettivo Receiver
	 * 
	 * @throws IOException
	 */
	public void esegui() throws IOException;
}