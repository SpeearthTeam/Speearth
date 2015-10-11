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

import com.speearth.model.core.IServizioComponent;

/**
 * Interfaccia rappresentante un sistema esterno che fornisce servizi per
 * l'agenzia
 */
public abstract class SistemaEsterno {
	/**
	 * Effettua l'autenticazione da parte dell'Agenzia verso il Sistema
	 */
	public abstract boolean autentica();

	/**
	 * Effettua una ricerca di servizi offerti dal sistema esterno secondo i
	 * parametri
	 * 
	 * @param parametri
	 * @return ArrayList<ServizioComponent>
	 * @throws HttpRetryException
	 */
	public ArrayList<IServizioComponent> ricerca(HashMap<String, String> parametri) throws IOException {
		String url = getSearchUrl();
		String parameters = serializeParameters(parametri);
		String response = sendRequest(url, parameters);
		return processServicesFromResponse(response);
	};
	
	/**
	 * Restituisce l'url di ricerca del sistema esterno
	 */
	protected abstract String getSearchUrl();
	
	/**
	 * Serializza i parametri per esseri inviati in una richiesta
	 * 
	 * @param parameters
	 * @return Parametri serializzati
	 */
	protected String serializeParameters(HashMap<String, String> parameters) {
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
		
		// Se ci sono parametri concatenati allora si elimina l'ultima concatenazione "&"
		if (parameters_name.size() > 0)
			parameters_buffer.deleteCharAt(parameters_buffer.length() - 1);
		
		return parameters_buffer.toString();
	};
	
	/**
	 * Invia una richiesta http ad un sistema esterno
	 * 
	 * @param url
	 * @param parameters  Parametri serializzati
	 * @return Restituisce la risposta del sistema esterno
	 * @throws IOException
	 */
	protected String sendRequest(String url, String parameters) throws IOException {
		try {
			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			
			//add reuqest header
			connection.setRequestMethod("POST");
			//connection.setRequestProperty("Accept", "application/json");
			
			// Send post request
			connection.setDoOutput(true);
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(parameters);
			writer.flush();
			writer.close();

			if (connection.getResponseCode() != 200) {
				throw new HttpRetryException("Connection response: " + connection.getResponseMessage(), connection.getResponseCode());
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
	 * Processa i servizi da una risposta http
	 * 
	 * @param response
	 * @return Lista di ServizioComponent
	 */
	protected abstract ArrayList<IServizioComponent> processServicesFromResponse(String response);
}