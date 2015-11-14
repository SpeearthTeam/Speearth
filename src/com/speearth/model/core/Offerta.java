package com.speearth.model.core;

import java.util.Date;

/**
 * 
 * Classe che modella una Offerta
 *
 */
public class Offerta extends PacchettoComposite {

	/**
	 * Data di inizio offerta
	 */
	private Date dataInizio;

	/**
	 * Data di fine offerta
	 */
	private Date dataFine;

	/**
	 * Costruttore con parametri
	 * 
	 * @param dataInizio
	 * @param dataFine
	 */
	public Offerta(Date dataInizio, Date dataFine) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	/**
	 * Restituisce la data di inizio offerta
	 * 
	 * @return Date
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * Imposta la data di inizio offerta
	 * 
	 * @param dataInizio
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * Restituisce la data di fine offerta
	 * 
	 * @return Date
	 */
	public Date getDataFine() {
		return dataFine;
	}

	/**
	 * Imposta la data di fine offerta
	 * 
	 * @param dataFine
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
