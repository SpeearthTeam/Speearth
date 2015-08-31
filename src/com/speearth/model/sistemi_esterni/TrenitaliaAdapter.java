package com.speearth.model.sistemi_esterni;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;

/**
 * Adapter per l'azienda di trasporto Trenitalia
 */
public class TrenitaliaAdapter extends AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static TrenitaliaAdapter instance;

	/**
	 * Restituisce la signola istanza della classe
	 * 
	 * @return TrenitaliaAdapter
	 */
	public static TrenitaliaAdapter getInstance() {
		if (instance == null)
			instance = new TrenitaliaAdapter();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	protected TrenitaliaAdapter() {
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
		return Costanti.URL_TRENITALIA + "index.php?action=search&category=tickets&provider=Trenitalia";
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
}