package model.tools;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import model.business.Alloggio;

public class BookingAdapter extends ImpresaRicettivaAdapter {
	/**
	 * Istanza della classe
	 */
	private static BookingAdapter instance;

	/**
	 * URL di accesso alle API del Sistema Esterno Booking
	 */
	private String url = "file://bo";

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
	 * Formatta l'URL completo per la richiesta REST in base ai parametri
	 * 
	 * @param parametri
	 * @return String
	 */
	@Override
	protected String formattaURL(HashMap<String, String> parametri) {
		// impostare le chiavi di ricerca nell'url
		// in un modo possibilmente più elegante :)
		String url = this.getUrl() + "q=" + parametri.get("localita");
		return url;
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
		// l'attributo stanze va convertito appositamente prima di creare
		// l'oggetto Alloggio
		return null;
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
