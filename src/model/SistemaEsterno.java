package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

/**
 * Interfaccia rappresentante un sistema esterno che fornisce servizi per
 * l'agenzia
 */
public interface SistemaEsterno {
	/**
	 * Effettua l'autenticazione da parte dell'Agenzia verso il Sistema
	 */
	public boolean autentica();

	/**
	 * Effettua una ricerca di servizi offerti dal sistema esterno secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) throws IOException, JSONException;
}