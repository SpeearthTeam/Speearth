package model;

import java.util.ArrayList;
import java.util.HashMap;

public class RicercaReceiver {
	/**
	 * Istanza della classe
	 */
	private static RicercaReceiver instance;
	
	/**
	 * Lista di Sistemi Esterni sui quali effettuare la ricerca
	 */
	private ArrayList<SistemaEsterno> sistemi;
	
	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return RicercaReceiver
	 */
	public static RicercaReceiver getInstance() {
		if (instance == null)
			instance = new RicercaReceiver();
		return instance;
	}
	
	/**
	 * Costruttore di default
	 */
	public RicercaReceiver() {
		//una volta che l'Agenzia è autenticata vengono caricati i Sistemi Esterni nella lista
		//prima iterazione: i Sistemi Esterni sono già connessi
	}
	
	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<Alloggio> ricercaAlloggi(HashMap<String, String> parametri) {
		return null;
	}

	/**
	 * Effettua una ricerca di Biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<Biglietto> ricercaBiglietti(HashMap<String, String> parametri) {
		return null;
	}

	public ArrayList<SistemaEsterno> getSistemi() {
		return sistemi;
	}

	public void setSistemi(ArrayList<SistemaEsterno> sistemi) {
		this.sistemi = sistemi;
	}

}