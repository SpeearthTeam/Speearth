package model;

/**
 * Classe astratta di un servizio
 */
public abstract class ServizioComponent {

	/**
	 * Id
	 */
	private int id;
	
	/**
	 * Fornitore
	 */
	private String fornitore;
	
	/**
	 * Prezzo
	 */
	private float prezzo;
	
	/**
	 * Totale
	 */
	private float totale;

	/**
	 * Metodo costruttore
	 */
	public ServizioComponent() {}

	/**
	 * Restituisce l'id
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id
	 * @param id
	 * @return ServizioComponent
	 */
	public ServizioComponent setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * Restituisce il nome del fornitore
	 * @return String
	 */
	public String getFornitore() {
		return this.fornitore;
	}

	/**
	 * Imposta il nome del fornitore
	 * @param fornitore
	 * @return ServizioComponent
	 */
	public ServizioComponent setFornitore(String fornitore) {
		this.fornitore = fornitore;
		return this;
	}

	/**
	 * Restituisce il prezzo
	 * @return float
	 */
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo
	 * @param prezzo
	 * @return ServizioComponent
	 */
	public ServizioComponent setPrezzo(float prezzo) {
		this.prezzo = prezzo;
		return this;
	}
	
	/**
	 * Restituisce il totale
	 * @return float
	 */
	public float getTotale() {
		return this.totale;
	}
	
	/**
	 * Imposta il totale
	 * @param totale
	 * @return ServizioComponent
	 */
	public ServizioComponent setTotale(float totale) {
		this.totale = totale;
		return this;
	}

}