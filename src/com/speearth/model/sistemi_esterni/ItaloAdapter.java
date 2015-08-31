package com.speearth.model.sistemi_esterni;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
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
	 * Formatta l'URL completo per la richiesta REST in base ai parametri
	 * 
	 * @param parametri
	 * @return String
	 */
	@Override
	protected String formattaURL(HashMap<String, String> parametri) {
		// impostare le chiavi di ricerca nell'url
		// in un modo possibilmente più elegante :)
		// String url = this.getUrl() + "q=" + parametri.get("partenza");
		return Costanti.URL_ITALO + "index.php?action=search&category=tickets&provider=Italo";
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
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;		
		
		biglietto.setId(jsonBiglietto.optInt("id", 0));
		biglietto.setFornitore(jsonBiglietto.optString("fornitore"));
		biglietto.setPartenza(jsonBiglietto.optString("partenza"));
		biglietto.setDestinazione(jsonBiglietto.optString("destinazione"));
		biglietto.setDataPartenzaAndata(LocalDateTime.parse(jsonBiglietto.optString("data_partenza_andata"), formatter));
		biglietto.setDataPartenzaRitorno(LocalDateTime.parse(jsonBiglietto.optString("data_partenza_andata"), formatter));
		biglietto.setDataArrivoAndata(LocalDateTime.parse(jsonBiglietto.optString("data_arrivo_andata"), formatter));
		biglietto.setDataArrivoRitorno(LocalDateTime.parse(jsonBiglietto.optString("data_arrivo_andata"), formatter));
		biglietto.setNumeroAdulti(jsonBiglietto.optInt("numero_adulti"));
		biglietto.setNumerBambini(jsonBiglietto.optInt("numero_bambini"));
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

	/**
	 * Effettua una ricerca di biglietti offerti da Italo secondo i
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