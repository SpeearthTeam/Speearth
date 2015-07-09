package model;

import java.util.Date;
import java.util.HashMap;

public class Alloggio implements ServizioComponent {

	private int id;
	private String fornitore;
	private String localita;
	private Date data_arrivo;
	private Date data_partenza;
	private java.util.HashMap<String, Integer> stanze;
	private float prezzo;

	/**
	 * Costruttore di default
	 */
	public Alloggio() {
	}

	/**
	 * Costruttore completo
	 * 
	 * @param id
	 * @param fornitore
	 * @param localita
	 * @param data_arrivo
	 * @param data_partenza
	 * @param stanze
	 * @param prezzo
	 */
	public Alloggio(int id, String fornitore, String localita, Date data_arrivo, Date data_partenza,
			HashMap<String, Integer> stanze, float prezzo) {
		super();
		this.id = id;
		this.fornitore = fornitore;
		this.localita = localita;
		this.data_arrivo = data_arrivo;
		this.data_partenza = data_partenza;
		this.stanze = stanze;
		this.prezzo = prezzo;
	}

	/**
	 * Restituisce l'id dell'Alloggio
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id dell'Alloggio
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il Fornitore dell'Alloggio
	 * 
	 * @return String
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Imposta il Fornitore dell'Alloggio
	 * 
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Restituisce la Data di arrivo
	 * 
	 * @return Date
	 */
	public String getLocalita() {
		return this.localita;
	}

	/**
	 * Imposta la località dell'Alloggio
	 * 
	 * @param localita
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	/**
	 * Restituisce la Data di arrivo
	 * 
	 * @return Date
	 */
	public Date getData_arrivo() {
		return this.data_arrivo;
	}

	/**
	 * Imposta la Data di arrivo
	 * 
	 * @param data_arrivo
	 */
	public void setData_arrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	/**
	 * Restituisce la Data di partenza
	 * 
	 * @return Date
	 */
	public Date getData_partenza() {
		return this.data_partenza;
	}

	/**
	 * Imposta la Data di partenza
	 * 
	 * @param data_partenza
	 */
	public void setData_partenza(Date data_partenza) {
		this.data_partenza = data_partenza;
	}

	/**
	 * Restituisce l'insieme di Stanze dell'Alloggio
	 * 
	 * @return HashMap<String, Integer>
	 */
	public HashMap<String, Integer> getStanze() {
		return this.stanze;
	}

	/**
	 * Imposta l'insieme di Stanze dell'Alloggio
	 * 
	 * @param stanze
	 */
	public void setStanze(HashMap<String, Integer> stanze) {
		this.stanze = stanze;
	}

	/**
	 * Restituisce il prezzo totale dell'Alloggio
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		return this.getPrezzo();
	}

	/**
	 * Imposta il prezzo totale dell'Alloggio
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.setPrezzo(totale);
	}

	/**
	 * Restituisce il prezzo dell'Alloggio
	 * 
	 * @return
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Imposta il prezzo dell'Alloggio
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Il metodo non si applica in quanto classe Foglia
	 */
	@Override
	public void aggiungi(ServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto classe Foglia
	 */
	@Override
	public void rimuovi(ServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto classe Foglia
	 */
	@Override
	public ServizioComponent getServizio(int indice) {
		return null;
	}

}