package model.sistemi_esterni;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import model.core.Biglietto;

/**
 * Adapter per l'azienda di trasporto Trenitalia
 */
public class TrenitaliaAdapter extends AziendaTrasportoAdapter {
	/**
	 * Istanza della classe
	 */
	private static TrenitaliaAdapter instance;

	/**
	 * URL di accesso alle API del Sistema Esterno Trenitalia
	 */
	private String url = "file://bo";

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
}