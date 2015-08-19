package model.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servizio biglietto
 */
public class Biglietto implements IServizioComponent {

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
	private LocalDateTime data_partenza_andata;

	/**
	 * Data di ritorno
	 */
	private LocalDateTime data_partenza_ritorno;

	/**
	 * Data di andata
	 */
	private LocalDateTime data_arrivo_andata;

	/**
	 * Data di ritorno
	 */
	private LocalDateTime data_arrivo_ritorno;

	/**
	 * Numero di adulti
	 */
	private int numero_adulti = 0;

	/**
	 * Numero di bambini
	 */
	private int numero_bambini = 0;

	/**
	 * Prezzo
	 */
	private float prezzo = 0;

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
		return this.data_partenza_andata;
	}

	/**
	 * Imposta la data di partenza nell'andata del Biglietto
	 * 
	 * @param data_partenza_andata
	 */
	public void setDataPartenzaAndata(LocalDateTime data_andata) {
		this.data_partenza_andata = data_andata;
	}

	/**
	 * Restituisce la data di partenza nel ritorno del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataPartenzaRitorno() {
		return this.data_partenza_ritorno;
	}

	/**
	 * Imposta la data di partenza nel ritorno del Biglietto
	 * 
	 * @param data_partenza_ritorno
	 */
	public void setDataPartenzaRitorno(LocalDateTime data_ritorno) {
		this.data_partenza_ritorno = data_ritorno;
	}

	/**
	 * Restituisce la data di arrivo nell'andata del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataArrivoAndata() {
		return data_arrivo_andata;
	}

	/**
	 * Imposta la data di partenza nel ritorno del Biglietto
	 * 
	 * @param data_arrivo_andata
	 */
	public void setDataArrivoAndata(LocalDateTime data_arrivo_andata) {
		this.data_arrivo_andata = data_arrivo_andata;
	}

	/**
	 * Restituisce la data di arrivo nel ritorno del Biglietto
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getDataArrivoRitorno() {
		return data_arrivo_ritorno;
	}

	/**
	 * Imposta la data di arrivo nel ritorno del Biglietto
	 * 
	 * @param data_arrivo_ritorno
	 */
	public void setDataArrivoRitorno(LocalDateTime data_arrivo_ritorno) {
		this.data_arrivo_ritorno = data_arrivo_ritorno;
	}

	/**
	 * Restituisce il numero di adulti del Biglietto
	 * 
	 * @return int
	 */
	public int getNumeroAdulti() {
		return this.numero_adulti;
	}

	/**
	 * Imposta il numero di adulti del Biglietto
	 * 
	 * @param numero_adulti
	 */
	public void setNumeroAdulti(int numero_adulti) {
		this.numero_adulti = numero_adulti;
	}

	/**
	 * Restituisce il numero di bambini del Biglietto
	 * 
	 * @return int
	 */
	public int getNumeroBambini() {
		return this.numero_bambini;
	}

	/**
	 * Imposta il numero di bambini del Biglietto
	 * 
	 * @param numero_bambini
	 */
	public void setNumerBambini(int numero_bambini) {
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
	 * Restituisce il prezzo del Biglietto
	 * 
	 * @return float
	 */
	@Override
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo del Biglietto
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
	public void aggiungi(IServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void rimuovi(IServizioComponent servizio) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public IServizioComponent getServizio(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public void setListaServizi(ArrayList<IServizioComponent> servizi) {
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	@Override
	public ArrayList<IServizioComponent> getListaServizi() {
		return null;
	}

}