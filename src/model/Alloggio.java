package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Servizio alloggio
 */
public class Alloggio implements ServizioComponent {

	/**
	 * Id
	 */
	private int id;

	/**
	 * Fornitore
	 */
	private String fornitore;

	/**
	 * Località
	 */
	private String localita;

	/**
	 * Data di arrivo
	 */
	private Date data_arrivo;

	/**
	 * Data di partenza
	 */
	private Date data_partenza;

	/**
	 * Stanze dell'alloggio
	 */
	private HashMap<String, Integer> stanze;

	/**
	 * Prezzo
	 */
	private float prezzo = 0;

	/**
	 * Prezzo totale
	 */
	private float totale = 0;

	/**
	 * Costruttore di default
	 */
	public Alloggio() {
	}

	/**
	 * Costruttore
	 * 
	 * @param fornitore
	 * @param localita
	 * @param stanze
	 */
	public Alloggio(String fornitore, String localita, HashMap<String, Integer> stanze) {
		this.fornitore = fornitore;
		this.localita = localita;
		this.stanze = stanze;
	}

	/**
	 * Restituisce l'id dell'alloggio
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id dell'alloggio
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il fornitore dell'alloggio
	 * 
	 * @return String
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Imposta il fornitore dell'alloggio
	 * 
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Restituisce la località dell'alloggio
	 * 
	 * @return Date
	 */
	public String getLocalita() {
		return this.localita;
	}

	/**
	 * Imposta la località dell'alloggio
	 * 
	 * @param localita
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	/**
	 * Restituisce la data di arrivo
	 * 
	 * @return Date
	 */
	public Date getDataArrivo() {
		return this.data_arrivo;
	}

	/**
	 * Imposta la data di arrivo
	 * 
	 * @param data_arrivo
	 */
	public void setDataArrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	/**
	 * Restituisce la data di partenza
	 * 
	 * @return Date
	 */
	public Date getDataPartenza() {
		return this.data_partenza;
	}

	/**
	 * Imposta la data di partenza
	 * 
	 * @param data_partenza
	 */
	public void setDataPartenza(Date data_partenza) {
		this.data_partenza = data_partenza;
	}

	/**
	 * Restituisce l'insieme di stanze dell'alloggio
	 * 
	 * @return HashMap<String, Integer>
	 */
	public HashMap<String, Integer> getStanze() {
		return this.stanze;
	}

	/**
	 * Imposta l'insieme di stanze dell'alloggio
	 * 
	 * @param stanze
	 */
	public void setStanze(HashMap<String, Integer> stanze) {
		this.stanze = stanze;
	}

	/**
	 * Restituisce il prezzo totale dell'alloggio
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		return this.totale;
	}

	/**
	 * Imposta il prezzo totale dell'alloggio
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.totale = totale;
	}

	/**
	 * Restituisce il prezzo dell'alloggio
	 * 
	 * @return
	 */
	@Override
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo dell'alloggio
	 * 
	 * @param prezzo
	 */
	@Override
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void aggiungi(ServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void rimuovi(ServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public ServizioComponent getServizio(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void setListaServizi(ArrayList<ServizioComponent> servizi) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public ArrayList<ServizioComponent> getListaServizi() {
		return null;
	}

}