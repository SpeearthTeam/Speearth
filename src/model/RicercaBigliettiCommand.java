package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe rappresentante un Comando di ricerca Biglietti verso un'Azienda di Trasporto
 */
public class RicercaBigliettiCommand implements SistemaEsternoCommand<Biglietto> {
	/**
	 * Oggetto che deve eseguire il Comando
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
	 * Fa eseguire il comando al Receiver
	 * 
	 * @param parametri
	 */
	@Override
	public ArrayList<Biglietto> esegui() {
		return this.receiver.ricercaBiglietti(this.parametri);
	}

}