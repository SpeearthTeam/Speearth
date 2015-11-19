package com.speearth.model.sistemi_esterni;

import java.text.ParseException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;

/**
 * Adapter per l'azienda di trasporto Italo
 */
public class ItaloAdapter extends AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static ItaloAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return ItaloAdapter
	 */
	public static ItaloAdapter getInstance() {
		if (instance == null)
			instance = new ItaloAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	protected ItaloAdapter() {

	}

	/**
	 * Crea un Biglietto da un oggetto JSON
	 * 
	 * @param jsonBiglietto
	 * @return Biglietto
	 * @throws JSONException
	 */
	@Override
	protected Biglietto creaBigliettoDaJSON(JSONObject jsonBiglietto) throws JSONException {

		Biglietto biglietto = new Biglietto();

		// biglietto.setId(jsonBiglietto.optInt("id", 0));
		biglietto.setFornitore(jsonBiglietto.optString("fornitore"));
		biglietto.setPartenza(jsonBiglietto.optString("partenza"));
		biglietto.setDestinazione(jsonBiglietto.optString("destinazione"));
		try {
			biglietto.setDataPartenzaAndata(
					Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("data_partenza_andata")));
			biglietto.setDataPartenzaRitorno(
					Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("data_partenza_andata")));
			biglietto.setDataArrivoAndata(Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("data_arrivo_andata")));
			biglietto.setDataArrivoRitorno(Costanti.FORMATO_DATA_ORA.parse(jsonBiglietto.optString("data_arrivo_andata")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		biglietto.setNumeroAdulti(jsonBiglietto.optInt("numero_adulti"));
		biglietto.setNumeroBambini(jsonBiglietto.optInt("numero_bambini"));
		biglietto.setPrezzo((float) jsonBiglietto.optInt("prezzo"));

		return biglietto;

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
		return Costanti.URL_ITALO;
	}

	@Override
	protected String serializeParameters(HashMap<String, String> parameters) {
		String parametri_serializzati = super.serializeParameters(parameters);

		if (!parametri_serializzati.isEmpty())
			parametri_serializzati += "&";

		return parametri_serializzati + "action=search&category=tickets&provider=Italo";
	}
}