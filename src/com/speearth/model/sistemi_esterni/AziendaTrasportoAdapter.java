package com.speearth.model.sistemi_esterni;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;

/**
 * Interfaccia rappresentante un'Azienda di Trasporto che fornisce Biglietti per
 * l'Agenzia
 */
public abstract class AziendaTrasportoAdapter extends SistemaEsterno {
	/**
	 * Crea un Biglietto da un oggetto JSON
	 * 
	 * @param jsonBiglietto
	 * @return Biglietto
	 * @throws JSONException
	 */
	protected abstract Biglietto creaBigliettoDaJSON(JSONObject jsonBiglietto) throws JSONException;

	/**
	 * Processa i Servizi da una risposta http
	 * 
	 * @param response
	 * @return ArrayList<ServizioComponent>
	 */
	@Override
	protected ArrayList<ServizioComponent> processaServiziDaRisposta(String response) {
		ArrayList<ServizioComponent> biglietti = new ArrayList<ServizioComponent>();
		if (response != null) {
			JSONArray jsonArray = new JSONArray(response);
			for (int i = 0; i < jsonArray.length(); i++) {
				biglietti.add(creaBigliettoDaJSON(jsonArray.getJSONObject(i)));
			}
		}
		return biglietti;
	}
}