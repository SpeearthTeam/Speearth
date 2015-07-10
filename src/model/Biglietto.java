package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Servizio biglietto
 */
public class Biglietto implements ServizioComponent {

	/**
	 * Id
	 */
	private int id;
	
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
	private Date data_andata;
	
	/**
	 * Data di ritorno
	 */
	private Date data_ritorno;
	
	/**
	 * Numero di adulti
	 */
	private int numero_adulti;
	
	/**
	 * Numero di bambini
	 */
	private int numero_bambini;
	
	/**
	 * Prezzo
	 */
	private float prezzo;
	
	/**
	 * Prezzo totale
	 */
	private float totale;
	
	/**
	 * Mezzo
	 */
	private String mezzo;

	/**
	 * Costruttore di default
	 */
	public Biglietto() {
		setPrezzo(0);
		setTotale(0);
		setNumerBambini(0);
		setNumeroAdulti(0);
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
		this();
		setFornitore(fornitore);
		setPartenza(partenza);
		setDestinazione(destinazione);
		setMezzo(mezzo);
	}

	/**
	 * Restituisce l'id del biglietto
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Imposta l'id del biglietto
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il Fornitore del biglietto
	 * 
	 * @return String
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Imposta il Fornitore del biglietto
	 * 
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Restituisce la partenza del biglietto
	 * 
	 * @return String
	 */
	public String getPartenza() {
		return this.partenza;
	}

	/**
	 * Imposta la partenza del biglietto
	 * 
	 * @param partenza
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	/**
	 * Restituisce la destinazione del biglietto
	 * 
	 * @return String
	 */
	public String getDestinazione() {
		return this.destinazione;
	}

	/**
	 * Imposta la destinazione del biglietto
	 * 
	 * @param destinazione
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	/**
	 * Restituisce la data di andata del biglietto
	 * 
	 * @return Date
	 */
	public Date getDataAndata() {
		return this.data_andata;
	}

	/**
	 * Imposta la data di andata del biglietto
	 * 
	 * @param data_andata
	 */
	public void setDataAndata(Date data_andata) {
		this.data_andata = data_andata;
	}

	/**
	 * Restituisce la data di ritorno del biglietto
	 * 
	 * @return Date
	 */
	public Date getDataRitorno() {
		return this.data_ritorno;
	}

	/**
	 * Imposta la data di ritorno del biglietto
	 * 
	 * @param data_ritorno
	 */
	public void setDataRitorno(Date data_ritorno) {
		this.data_ritorno = data_ritorno;
	}

	/**
	 * Restituisce il numero di adulti del biglietto
	 * 
	 * @return int
	 */
	public int getNumeroAdulti() {
		return this.numero_adulti;
	}

	/**
	 * Imposta il numero di adulti del biglietto
	 * 
	 * @param numero_adulti
	 */
	public void setNumeroAdulti(int numero_adulti) {
		this.numero_adulti = numero_adulti;
	}

	/**
	 * Restituisce il numero di bambini del biglietto
	 * 
	 * @return int
	 */
	public int getNumeroBambini() {
		return this.numero_bambini;
	}

	/**
	 * Imposta il numero di bambini del biglietto
	 * 
	 * @param numero_bambini
	 */
	public void setNumerBambini(int numero_bambini) {
		this.numero_bambini = numero_bambini;
	}

	/**
	 * Restituisce il mezzo di trasporto del biglietto
	 * 
	 * @return String
	 */
	public String getMezzo() {
		return this.mezzo;
	}

	/**
	 * Imposta il mezzo di trasporto del biglietto
	 * 
	 * @param mezzo
	 */
	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}

	/**
	 * Restituisce il prezzo totale del biglietto
	 * 
	 * @return float
	 */
	@Override
	public float getTotale() {
		return this.totale;
	}

	/**
	 * Imposta il prezzo totale del biglietto
	 * 
	 * @param totale
	 */
	@Override
	public void setTotale(float totale) {
		this.totale = totale;
	}

	/**
	 * Restituisce il prezzo del biglietto
	 * 
	 * @return float
	 */
	@Override
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo del biglietto
	 * 
	 * @param prezzo
	 */
	@Override
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public void aggiungi(ServizioComponent servizio) {
		// Il metodo è vuoto in quanto classe foglia
	}

	@Override
	public void rimuovi(ServizioComponent servizio) {
		// Il metodo è vuoto in quanto classe foglia
	}

	@Override
	public void setServiziAnnidati(ArrayList<ServizioComponent> servizi) {
		// Il metodo è vuoto in quanto classe foglia
	}

	@Override
	public ArrayList<ServizioComponent> getServiziAnnidati() {
		// Il metodo restituisce null in quanto classe foglia
		return null;
	}

}