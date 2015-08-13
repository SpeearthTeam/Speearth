package model.sistemi_esterni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.core.Biglietto;
import model.core.IServizioComponent;

/**
 * Adapter per l'azienda di trasporto Italo
 */
public class ItaloAdapter extends AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static ItaloAdapter instance;
	
	/**
	 * URL di accesso alle API del Sistema Esterno Italo
	 */
	private String url = "file://bo";

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
		String url = this.getUrl() + "q=" + parametri.get("partenza");
		return url;
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
		return new Biglietto(jsonBiglietto.getString("fornitore"), jsonBiglietto.getString("partenza"),
				jsonBiglietto.getString("destinazione"), jsonBiglietto.getString("mezzo"));
	}

	/**
	 * Restituisce l'URL
	 * 
	 * @return String
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Imposta l'URL
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
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