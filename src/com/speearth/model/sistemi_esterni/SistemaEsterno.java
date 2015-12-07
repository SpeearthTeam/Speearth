package com.speearth.model.sistemi_esterni;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONException;

import com.speearth.model.core.ServizioComponent;

/**
 * Interfaccia rappresentante un Sistema Esterno che fornisce servizi per
 * l'Agenzia
 */
public abstract class SistemaEsterno {
	/**
	 * Effettua una ricerca di servizi offerti dal sistema esterno secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 * @throws IOException
	 */
	public ArrayList<ServizioComponent> ricerca(HashMap<String, String> parametri) throws IOException {
		String url = getUrlRicerca();
		String parameters = serializzaParametri(parametri);
		String response = sendRequest(url, parameters);
		return processaServiziDaRisposta(response);
	};

	/**
	 * Invia una richiesta http ad un sistema esterno
	 * 
	 * @param url
	 * @param parameters
	 *            Parametri serializzati
	 * @return Restituisce la risposta del sistema esterno
	 * @throws IOException
	 */
	protected String sendRequest(String url, String parameters) throws IOException {
		try {
			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(parameters);
			writer.flush();
			writer.close();
			if (connection.getResponseCode() != 200) {
				throw new HttpRetryException("Connection response: " + connection.getResponseMessage(),
						connection.getResponseCode());
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String buffer;
			StringBuffer response = new StringBuffer();
			while ((buffer = reader.readLine()) != null) {
				response.append(buffer);
			}
			reader.close();
			return response.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	};

	/**
	 * Processa i Servizi da una risposta http
	 * 
	 * @param response
	 * @return ArrayList<ServizioComponent>
	 */
	protected abstract ArrayList<ServizioComponent> processaServiziDaRisposta(String response);

	/**
	 * Restituisce l'url di ricerca del Sistema Esterno
	 * 
	 * @return String
	 */
	protected abstract String getUrlRicerca();

	/**
	 * Serializza i parametri per esseri inviati in una richiesta
	 * 
	 * @param parameters
	 * @return String
	 */
	protected String serializzaParametri(HashMap<String, String> parameters) {
		StringBuffer parameters_buffer = new StringBuffer();
		Set<String> parameters_name = parameters.keySet();
		for (String parameter_name : parameters_name) {
			String value = parameters.get(parameter_name);
			if (value != null) {
				try {
					parameters_buffer.append(parameter_name + "=" + URLEncoder.encode(value, "UTF-8") + "&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		// Se ci sono parametri concatenati si elimina l'ultima concatenazione
		// "&"
		if (parameters_name.size() > 0)
			parameters_buffer.deleteCharAt(parameters_buffer.length() - 1);
		return parameters_buffer.toString();
	}
}