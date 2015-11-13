package com.speearth.model.core;

import java.time.LocalDateTime;

/**
 * Servizio biglietto
 */
public class Biglietto extends ServizioComponent {

	/**
	 * Fornitore
	 */
	private String fornitore;

	/**
	 * Partenza
	 */
	private String partenza;

	/**
	 * Destinazione
	 */
	private String destinazione;

	/**
	 * Data di andata
	 */
	private LocalDateTime dataPartenzaAndata;

	/**
	 * Data di ritorno
	 */
	private LocalDateTime dataPartenzaRitorno;

	/**
	 * Data di andata
	 */
	private LocalDateTime dataArrivoAndata;

	/**
	 * Data di ritorno
	 */
	private LocalDateTime dataArrivoRitorno;

	/**
	 * Numero di adulti
	 */
	private int numeroAdulti = 0;

	/**
	 * Numero di bambini
	 */
	private int numeroBambini = 0;

	/**
	 * Mezzo
	 */
	private String mezzo;

	/**
	 * Costruttore di default
	 */
	public Biglietto() {

	}

	/**
	 * Costruttore
	 *
	 * @param fornitore
	 * @param partenza
	 * @param destinazione
	 * @param mezzo
	 */
	public Biglietto(String fornitore, String partenza, String destinazione, String mezzo) {
		this.fornitore = fornitore;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.mezzo = mezzo;
	}

	/**
	 * Restituisce l'id del Biglietto
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id del Biglietto
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il Fornitore del Biglietto
	 * 
	 * @return String
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Imposta il Fornitore del Biglietto
	 * 
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Restituisce la partenza del Biglietto
	 * 
	 * @return String
	 */
	public String getPartenza() {
		return this.partenza;
	}

	/**
	 * Imposta la partenza del Biglietto
	 * 
	 * @param partenza
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	/**
	 * Restituisce la destinazione del Biglietto
	 * 
	 * @return String
	 */
	public String getDestinazione() {
		return this.destinazione;
	}

	/**
	 * Imposta la destinazione del Biglietto
	 * 
	 * @param destinazione
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	/**
	 * Restituisce la data di partenza nell'andata del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataPartenzaAndata() {
		return this.dataPartenzaAndata;
	}

	/**
	 * Imposta la data di partenza nell'andata del Biglietto
	 * 
	 * @param dataPartenzaAndata
	 */
	public void setDataPartenzaAndata(LocalDateTime data_andata) {
		this.dataPartenzaAndata = data_andata;
	}

	/**
	 * Restituisce la data di partenza nel ritorno del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataPartenzaRitorno() {
		return this.dataPartenzaRitorno;
	}

	/**
	 * Imposta la data di partenza nel ritorno del Biglietto
	 * 
	 * @param dataPartenzaRitorno
	 */
	public void setDataPartenzaRitorno(LocalDateTime data_ritorno) {
		this.dataPartenzaRitorno = data_ritorno;
	}

	/**
	 * Restituisce la data di arrivo nell'andata del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataArrivoAndata() {
		return dataArrivoAndata;
	}

	/**
	 * Imposta la data di partenza nel ritorno del Biglietto
	 * 
	 * @param data_arrivo_andata
	 */
	public void setDataArrivoAndata(LocalDateTime data_arrivo_andata) {
		this.dataArrivoAndata = data_arrivo_andata;
	}

	/**
	 * Restituisce la data di arrivo nel ritorno del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataArrivoRitorno() {
		return dataArrivoRitorno;
	}

	/**
	 * Imposta la data di arrivo nel ritorno del Biglietto
	 * 
	 * @param data_arrivo_ritorno
	 */
	public void setDataArrivoRitorno(LocalDateTime data_arrivo_ritorno) {
		this.dataArrivoRitorno = data_arrivo_ritorno;
	}

	/**
	 * Restituisce il numero di adulti del Biglietto
	 * 
	 * @return int
	 */
	public int getNumeroAdulti() {
		return this.numeroAdulti;
	}

	/**
	 * Imposta il numero di adulti del Biglietto
	 * 
	 * @param numero_adulti
	 */
	public void setNumeroAdulti(int numero_adulti) {
		this.numeroAdulti = numero_adulti;
	}

	/**
	 * Restituisce il numero di bambini del Biglietto
	 * 
	 * @return int
	 */
	public int getNumeroBambini() {
		return this.numeroBambini;
	}

	/**
	 * Imposta il numero di bambini del Biglietto
	 * 
	 * @param numero_bambini
	 */
	public void setNumerBambini(int numero_bambini) {
		this.numeroBambini = numero_bambini;
	}

	/**
	 * Restituisce il mezzo di trasporto del Biglietto
	 * 
	 * @return String
	 */
	public String getMezzo() {
		return this.mezzo;
	}

	/**
	 * Imposta il mezzo di trasporto del Biglietto
	 * 
	 * @param mezzo
	 */
	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}

}