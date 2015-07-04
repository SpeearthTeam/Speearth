package model;

import java.util.Date;

public class Pagamento {

	private int id;
	private float ammontare;
	private Date data;

	public Pagamento() {
		// TODO - implement Pagamento.Pagamento
		throw new UnsupportedOperationException();
	}

	public String generaRicevuta() {
		// TODO - implement Pagamento.generaRicevuta
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public float getAmmontare() {
		return this.ammontare;
	}

	/**
	 * 
	 * @param ammontare
	 */
	public void setAmmontare(float ammontare) {
		this.ammontare = ammontare;
	}

	public Date getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

}