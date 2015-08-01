package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Adapter per l'azienda di trasporto Trenitalia
 */
public class TrenitaliaAdapter implements AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static TrenitaliaAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return TrenitaliaAdapter
	 */
	public static TrenitaliaAdapter getInstance() {
		if (instance == null)
			instance = new TrenitaliaAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	protected TrenitaliaAdapter() {
	}

	/**
	 * Effettua l'autenticazione da parte dell'agenzia verso il sistema
	 */
	@Override
	public boolean autentica() {
		// effettua il login sul sistema con le credenziali dell'agenzia
		return true;
	}

	/**
	 * Effettua una ricerca di biglietti offerti da Trenitalia secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 * @throws IOException
	 */
	@Override
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) throws IOException {
		try {
			URL url = new URL("file://bo");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode());
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String output = "";
			String buffer;
			while ((buffer = reader.readLine()) != null) {
				output += buffer;			
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		ArrayList<ServizioComponent> biglietti = new ArrayList<ServizioComponent>();

		return biglietti;
	}
}