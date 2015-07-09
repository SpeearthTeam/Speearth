package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interfaccia rappresentante un'Impresa Ricettiva che fornisce Alloggi per
 * l'Agenzia
 */
public interface ImpresaRicettivaAdapter extends SistemaEsterno<Alloggio> {
	/**
	 * Restituisce una lista di Alloggi secondo i parametri di ricerca
	 * 
	 * @param parametri
	 */
	public ArrayList<Alloggio> ricerca(HashMap<String, String> parametri);

}