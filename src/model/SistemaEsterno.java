package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interfaccia rappresentante un Sistema Esterno che fornisce Servizi per l'Agenzia
 */
@SuppressWarnings("hiding")
public interface SistemaEsterno<ServizioComponent> {
	/**
	 * Effettua l'autenticazione da parte dell'Agenzia verso il Sistema
	 * 
	 * @param username
	 * @param password
	 */
	public boolean autentica(String username, String password);
	
	/**
	 * Effettua una ricerca di Servizi offerti dal Sistema Esterno secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri);
}