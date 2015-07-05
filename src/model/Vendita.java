package model;

import java.util.Date;

/**
 * Classe che descrive la vendita
 */
public class Vendita {

	/**
	 * Id
	 */
	private int id;
	
	/**
	 * Data
	 */
	private Date data;
	
	/**
	 * Pagamento relativo alla vendita
	 */
	private Pagamento pagamento;

	/**
	 * Metodo costruttore
	 */
	public Vendita() {}

	/**
	 * Restituisce l'id della vendita
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id della vendita
	 * @param id
	 * @return Vendita
	 */
	public Vendita setId(int id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Restituisce la data della vendita
	 * @return Date
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * Imposta la data della vendita
	 * @param data
	 * @return Vendita
	 */
	public Vendita setData(Date data) {
		this.data = data;
		return this;
	}
	
	/**
	 * Restituisce il pagamento
	 * @return Pagamento
	 */
	public Pagamento getPagamento() {
		return this.pagamento;
	}
	
	/**
	 * Imposta il pagamento
	 * @param pagamento
	 * @return Vendita
	 */
	public Vendita setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
		return this;
	}

}