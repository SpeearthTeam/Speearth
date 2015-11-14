package com.speearth.model.core;

import java.util.Date;
import java.util.HashMap;

/**
 * Servizio alloggio
 */
public class Alloggio extends ServizioComponent {

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
	private Date dataArrivo;

	/**
	 * Data di partenza
	 */
	private Date dataPartenza;

	/**
	 * Stanze dell'alloggio
	 */
	private HashMap<String, Integer> stanze;

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
		return this.dataArrivo;
	}

	/**
	 * Imposta la data di arrivo
	 * 
	 * @param data_arrivo
	 */
	public void setDataArrivo(Date data_arrivo) {
		this.dataArrivo = data_arrivo;
	}

	/**
	 * Restituisce la data di partenza
	 * 
	 * @return Date
	 */
	public Date getDataPartenza() {
		return this.dataPartenza;
	}

	/**
	 * Imposta la data di partenza
	 * 
	 * @param data_partenza
	 */
	public void setDataPartenza(Date data_partenza) {
		this.dataPartenza = data_partenza;
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

}