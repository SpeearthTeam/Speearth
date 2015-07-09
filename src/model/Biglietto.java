package model;

import java.util.Date;

public class Biglietto implements ServizioComponent {

	private int id;
	private String fornitore;
	private String partenza;
	private String destinazione;
	private Date data_andata;
	private Date data_ritorno;
	private int numero_adulti;
	private int numero_bambini;
	private float prezzo;
	private String mezzo;

	/**
	 * Costruttore di default
	 */
	public Biglietto() {
	}

	/**
	 * Costruttore completo
	 * 
	 * @param id
	 * @param fornitore
	 * @param partenza
	 * @param destinazione
	 * @param data_andata
	 * @param data_ritorno
	 * @param numero_adulti
	 * @param numero_bambini
	 * @param prezzo
	 * @param mezzo
	 */
	public Biglietto(int id, String fornitore, String partenza, String destinazione, Date data_andata,
			Date data_ritorno, int numero_adulti, int numero_bambini, float prezzo, String mezzo) {
		super();
		this.id = id;
		this.fornitore = fornitore;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.data_andata = data_andata;
		this.data_ritorno = data_ritorno;
		this.numero_adulti = numero_adulti;
		this.numero_bambini = numero_bambini;
		this.prezzo = prezzo;
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
	 * @return
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
	 * Restituisce la data di andata del Biglietto
	 * 
	 * @return Date
	 */
	public Date getData_andata() {
		return this.data_andata;
	}

	/**
	 * Imposta la data di andata del Biglietto
	 * 
	 * @param data_andata
	 */
	public void setData_andata(Date data_andata) {
		this.data_andata = data_andata;
	}

	/**
	 * Restituisce la data di ritorno del Biglietto
	 * 
	 * @return Date
	 */
	public Date getData_ritorno() {
		return this.data_ritorno;
	}

	/**
	 * 
	 * @param data_ritorno
	 */
	public void setData_ritorno(Date data_ritorno) {
		this.data_ritorno = data_ritorno;
	}

	/**
	 * Restituisce il numero di adulti del Biglietto
	 * 
	 * @return int
	 */
	public int getNumero_adulti() {
		return this.numero_adulti;
	}

	/**
	 * Imposta il numero di adulti del Biglietto
	 * 
	 * @param numero_adulti
	 */
	public void setNumero_adulti(int numero_adulti) {
		this.numero_adulti = numero_adulti;
	}

	/**
	 * Restituisce il numero di bambini del Biglietto
	 * 
	 * @return int
	 */
	public int getNumero_bambini() {
		return this.numero_bambini;
	}

	/**
	 * Imposta il numero di bambini del Biglietto
	 * 
	 * @param numero_bambini
	 */
	public void setNumero_bambini(int numero_bambini) {
		this.numero_bambini = numero_bambini;
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

	/**
	 * Restituisce il prezzo totale del Biglietto
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		return this.getPrezzo();
	}

	/**
	 * Imposta il prezzo totale del Biglietto
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.setPrezzo(totale);
	}

	/**
	 * Restituisce il prezzo del Biglietto
	 * 
	 * @return float
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Imposta il prezzo del Biglietto
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