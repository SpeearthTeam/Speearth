package model;

import java.util.ArrayList;
import java.util.HashMap;

public interface ImpresaRicettivaAdapter extends SistemaEsterno {
	/**
	 * Restituisce una lista di Alloggi secondo i parametri di ricerca
	 * 
	 * @param parametri
	 */
	public ArrayList<Alloggio> ricerca(HashMap<String, String> parametri);

}