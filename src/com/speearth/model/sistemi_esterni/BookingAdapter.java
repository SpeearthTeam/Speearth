package com.speearth.model.sistemi_esterni;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Alloggio;
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

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

		JSONObject rooms = jsonBiglietto.optJSONObject("rooms");
		Set<String> roomTypes = rooms.keySet();

		HashMap<String, Integer> stanze = new HashMap<String, Integer>();

		for (String type : roomTypes)
			stanze.put(type, jsonBiglietto.optInt(type));

		alloggio.setId(jsonBiglietto.optInt("id", 0));
		alloggio.setFornitore(jsonBiglietto.optString("provider"));
		alloggio.setLocalita(jsonBiglietto.optString("city"));
		alloggio.setDataPartenza(LocalDateTime.parse(jsonBiglietto.optString("departure_date"), formatter));
		alloggio.setDataArrivo(LocalDateTime.parse(jsonBiglietto.optString("arrival_date"), formatter));
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
