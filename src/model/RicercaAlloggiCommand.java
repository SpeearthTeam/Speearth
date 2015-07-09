package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe rappresentante un Comando di ricerca Alloggi verso un'Impresa
 * Ricettiva
 */
public class RicercaAlloggiCommand implements SistemaEsternoCommand<Alloggio> {
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
	public RicercaAlloggiCommand(RicercaReceiver receiver, HashMap<String, String> parametri) {
		this.receiver = receiver;
		this.parametri = parametri;
	}

	/**
	 * Fa eseguire il comando al Receiver
	 * 
	 * @param parametri
	 */
	@Override
	public ArrayList<Alloggio> esegui() {
		return this.receiver.ricercaAlloggi(this.parametri);
	}

}