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

/**
 * Adapter per l'Impresa Ricettiva Booking
 */
public class BookingAdapter extends ImpresaRicettivaAdapter {
	/**
	 * Unica istanza della Classe
	 */
	private static BookingAdapter instance;

	/**
	 * Restituisce la singola istanza della Classe
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
		for (int i = 0; i < rooms.length(); ++i) {
			JSONObject room = rooms.getJSONObject(i);
			Stanza stanza = new Stanza(room.getString("type"));
			stanze.add(stanza);
		}
		alloggio.setFornitore(jsonBiglietto.optString("provider"));
		alloggio.setLocalita(jsonBiglietto.optString("city"));
		try {
			alloggio.setDataPartenza(Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("departure_date")));
			alloggio.setDataArrivo(Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("arrival_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		alloggio.setStanze(stanze);
		alloggio.setPrezzo((float) jsonBiglietto.optInt("price"));
		return alloggio;
	}

	/**
	 * Restituisce l'url di ricerca del Sistema Esterno
	 */
	@Override
	protected String getUrlRicerca() {
		return Costanti.URL_BOOKING;
	}

	/**
	 * Serializza i parametri per esseri inviati in una richiesta
	 * 
	 * @param parameters
	 * @return String
	 */
	@Override
	protected String serializzaParametri(HashMap<String, String> parameters) {
		String parametri_serializzati = super.serializzaParametri(parameters);
		if (!parametri_serializzati.isEmpty())
			parametri_serializzati += "&";
		return parametri_serializzati + "action=search&category=accomodations";
	}
}
