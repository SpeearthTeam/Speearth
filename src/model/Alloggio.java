package model;

import java.util.Date;
import java.util.HashMap;

public class Alloggio extends ServizioComponent {

	private String localita;
	private Date data_arrivo;
	private Date data_partenza;
	private java.util.HashMap<String, Integer> stanze;

	public Alloggio() {
	}

	public Alloggio(String localita, Date data_arrivo, Date data_partenza, HashMap<String, Integer> stanze) {
		super();
		this.localita = localita;
		this.data_arrivo = data_arrivo;
		this.data_partenza = data_partenza;
		this.stanze = stanze;
	}

	public String getLocalita() {
		return this.localita;
	}

	/**
	 * 
	 * @param localita
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public Date getData_arrivo() {
		return this.data_arrivo;
	}

	/**
	 * 
	 * @param data_arrivo
	 */
	public void setData_arrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	public Date getData_partenza() {
		return this.data_partenza;
	}

	/**
	 * 
	 * @param data_partenza
	 */
	public void setData_partenza(Date data_partenza) {
		this.data_partenza = data_partenza;
	}

	public HashMap<String, Integer> getStanze() {
		return this.stanze;
	}

	/**
	 * 
	 * @param stanze
	 */
	public void setStanze(HashMap<String, Integer> stanze) {
		this.stanze = stanze;
	}

	@Override
	public float getTotale() {
		return this.getPrezzo();
	}

}