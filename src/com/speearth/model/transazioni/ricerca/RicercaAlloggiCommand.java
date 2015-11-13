package com.speearth.model.transazioni.ricerca;

import java.io.IOException;
import java.util.HashMap;

import com.speearth.model.transazioni.ITransazioniCommand;

/**
 * Classe rappresentante un comando di ricerca alloggi verso un'impresa
 * ricettiva
 */
public class RicercaAlloggiCommand implements ITransazioniCommand {
	/**
	 * Oggetto che deve eseguire il comando
	 */
	private RicercaReceiver receiver;

	/**
	 * Parametri di ricerca
	 */
	private HashMap<String, String> parametri;

	/**
	 * Costruttore completo
	 * 
	 * @param receiver
	 * @param parametri
	 */
	public RicercaAlloggiCommand(RicercaReceiver receiver, HashMap<String, String> parametri) {
		this.receiver = receiver;
		this.parametri = parametri;
	}

	/**
	 * Restituisce il receiver
	 * 
	 * @return RicercaReceiver
	 */
	public RicercaReceiver getReceiver() {
		return this.receiver;
	}

	/**
	 * Imposta il receiver
	 * 
	 * @param receiver
	 */
	public void setReceiver(RicercaReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * Restituisce i parametri
	 * 
	 * @return HashMap<String, String>
	 */
	public HashMap<String, String> getParametri() {
		return this.parametri;
	}

	/**
	 * Imposta i parametri
	 * 
	 * @param parametri
	 */
	public void setParametri(HashMap<String, String> parametri) {
		this.parametri = parametri;
	}

	@Override
	public void esegui() throws IOException {
		this.receiver.ricercaAlloggi(this.parametri);
	}

}