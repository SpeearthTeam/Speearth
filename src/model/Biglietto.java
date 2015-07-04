package model;

import java.util.Date;

public class Biglietto extends ServizioComponent {

	private String partenza;
	private String destinazione;
	private Date data_andata;
	private Date data_ritorno;
	private int numero_adulti;
	private int numero_bambini;
	private String mezzo;

	public Biglietto() {
		// TODO - implement Biglietto.Biglietto
		throw new UnsupportedOperationException();
	}

	public String getPartenza() {
		return this.partenza;
	}

	/**
	 * 
	 * @param partenza
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getDestinazione() {
		return this.destinazione;
	}

	/**
	 * 
	 * @param destinazione
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public Date getData_andata() {
		return this.data_andata;
	}

	/**
	 * 
	 * @param data_andata
	 */
	public void setData_andata(Date data_andata) {
		this.data_andata = data_andata;
	}

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

	public int getNumero_adulti() {
		return this.numero_adulti;
	}

	/**
	 * 
	 * @param numero_adulti
	 */
	public void setNumero_adulti(int numero_adulti) {
		this.numero_adulti = numero_adulti;
	}

	public int getNumero_bambini() {
		return this.numero_bambini;
	}

	/**
	 * 
	 * @param numero_bambini
	 */
	public void setNumero_bambini(int numero_bambini) {
		this.numero_bambini = numero_bambini;
	}

	public String getMezzo() {
		return this.mezzo;
	}

	/**
	 * 
	 * @param mezzo
	 */
	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}

	@Override
	public float getTotale() {
		// TODO Auto-generated method stub
		return 0;
	}

}