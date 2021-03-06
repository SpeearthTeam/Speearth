package com.speearth.model.transazioni.ricerca;

import java.io.IOException;
import java.util.HashMap;

import com.speearth.model.transazioni.ITransazioniCommand;

/**
 * Classe rappresentante un comando di ricerca Biglietti verso un'Azienda di
 * Trasporto
 */
public class RicercaBigliettiCommand implements ITransazioniCommand {
	/**
	 * Receiver del Command
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
	public RicercaBigliettiCommand(RicercaReceiver receiver, HashMap<String, String> parametri) {
		this.receiver = receiver;
		this.parametri = parametri;
	}

	/**
	 * Restituisce il Receiver
	 * 
	 * @return RicercaReceiver
	 */
	public RicercaReceiver getReceiver() {
		return this.receiver;
	}

	/**
	 * Imposta il Receiver
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

	/**
	 * Fa eseguire il Command al rispettivo Receiver
	 * 
	 * @throws IOException
	 */
	@Override
	public void esegui() throws IOException {
		this.receiver.ricercaBiglietti(this.parametri);
	}

}