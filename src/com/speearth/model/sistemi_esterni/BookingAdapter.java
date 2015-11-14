package com.speearth.model.sistemi_esterni;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Stanza;
import com.speearth.utility.Costanti;

public class BookingAdapter extends ImpresaRicettivaAdapter {
	/**
	 * Istanza della classe
	 */
	private static BookingAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return BookingAdapter
	 */
	public static BookingAdapter getInstance() {
		if (instance == null)
			instance = new BookingAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	protected BookingAdapter() {

	}

	/**
	 * Crea un Alloggio da un oggetto JSON
	 * 
	 * @param jsonAlloggio
	 * @return Alloggio
	 * @throws JSONException
	 */
	@Override
	protected Alloggio creaAlloggioDaJSON(JSONObject jsonBiglietto) throws JSONException {
		Alloggio alloggio = new Alloggio();

		ArrayList<Stanza> stanze = new ArrayList<>();
		JSONArray rooms = jsonBiglietto.optJSONArray("rooms");
		
		System.out.println(rooms.toString());

		for (int i = 0; i < rooms.length(); ++i) {
			JSONObject room = rooms.getJSONObject(i);
			Stanza stanza = new Stanza(room.getString("type"));
			stanze.add(stanza);
		}

		alloggio.setId(jsonBiglietto.optInt("id", 0));
		alloggio.setFornitore(jsonBiglietto.optString("provider"));
		alloggio.setLocalita(jsonBiglietto.optString("city"));
		try {
			alloggio.setDataPartenza(Costanti.FORMATO_DATA.parse(jsonBiglietto.optString("departure_date")));
			alloggio.setDataArrivo(Costanti.FORMATO_DATA.parse(jsonBiglietto.optString("arrival_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		alloggio.setStanze(stanze);
		alloggio.setPrezzo((float) jsonBiglietto.optInt("price"));

		return alloggio;
	}

	/**
	 * Effettua l'autenticazione da parte dell'agenzia verso il sistema
	 */
	@Override
	public boolean autentica() {
		// effettua il login sul sistema con le credenziali dell'agenzia
		return true;
	}

	@Override
	protected String getSearchUrl() {
		return Costanti.URL_BOOKING;
	}

	@Override
	protected String serializeParameters(HashMap<String, String> parameters) {
		String parametri_serializzati = super.serializeParameters(parameters);

		if (!parametri_serializzati.isEmpty())
			parametri_serializzati += "&";

		return parametri_serializzati + "action=search&category=accomodations";
	}
}
