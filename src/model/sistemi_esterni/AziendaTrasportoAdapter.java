package model.sistemi_esterni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import model.core.Biglietto;
import model.core.IServizioComponent;

/**
 * Interfaccia rappresentante un'Azienda di Trasporto che fornisce Biglietti per
 * l'Agenzia
 */
public abstract class AziendaTrasportoAdapter implements ISistemaEsterno {
	/**
	 * Formatta l'URL completo per la richiesta REST in base ai parametri
	 * 
	 * @param parametri
	 * @return String
	 */
	protected abstract String formattaURL(HashMap<String, String> parametri);

	/**
	 * Crea un Biglietto da un oggetto JSON
	 * 
	 * @param jsonBiglietto
	 * @return Biglietto
	 * @throws JSONException
	 */
	protected abstract Biglietto creaBigliettoDaJSON(JSONObject jsonBiglietto) throws JSONException;

	/**
	 * Effettua una query verso il Sistema Esterno in base ai parametri
	 * 
	 * @param parametri
	 * @return JSONArray
	 */
	protected JSONArray effettuaQuery(HashMap<String, String> parametri) {
		try {
			URL url = new URL(this.formattaURL(parametri));
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

			JSONTokener jsonTokener = new JSONTokener(output);
			JSONArray jsonArray = new JSONArray(jsonTokener);

			return jsonArray;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Effettua una ricerca di Biglietti offerti dall'Azienda secondo i
	 * parametri e ne restituisce un elenco usufruibile dall'Agenzia
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 * @throws IOException
	 * @throws JSONException
	 */
	@Override
	public ArrayList<IServizioComponent> ricerca(HashMap<String, String> parametri) throws IOException, JSONException {
		JSONArray jsonArray = this.effettuaQuery(parametri);
		ArrayList<IServizioComponent> biglietti = new ArrayList<IServizioComponent>();

		for (int i = 0; i < jsonArray.length(); i++) {
			biglietti.add(this.creaBigliettoDaJSON(jsonArray.getJSONObject(i)));
		}
		return biglietti;
	}
}