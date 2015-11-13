package com.speearth.model.sistemi_esterni;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.ServizioComponent;

/**
 * Interfaccia rappresentante un'Impresa Ricettiva che fornisce Alloggi per
 * l'Agenzia
 */
public abstract class ImpresaRicettivaAdapter extends SistemaEsterno {

	/**
	 * Crea un Alloggio da un oggetto JSON
	 * 
	 * @param jsonAlloggio
	 * @return Alloggio
	 * @throws JSONException
	 */
	protected abstract Alloggio creaAlloggioDaJSON(JSONObject jsonAlloggio) throws JSONException;

	@Override
	protected ArrayList<ServizioComponent> processServicesFromResponse(String response) {
		ArrayList<ServizioComponent> alloggi = new ArrayList<ServizioComponent>();
		JSONArray jsonArray = new JSONArray(response);

		for (int i = 0; i < jsonArray.length(); i++) {
			alloggi.add(creaAlloggioDaJSON(jsonArray.getJSONObject(i)));
		}

		return alloggi;
	}
}