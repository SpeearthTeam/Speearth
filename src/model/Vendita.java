package model;

import java.util.Date;

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
	 * Cliente
	 */
	private Cliente cliente;

	/**
	 * Pagamento relativo alla vendita
	 */
	private Pagamento pagamento;

	/**
	 * Commesso
	 */
	private Commesso commesso;

	/**
	 * Servizio
	 */
	private ServizioComponent servizio;

	/**
	 * Costruttore di default
	 */
	public Vendita() {
	}

	/**
	 * Costruttore completo
	 * 
	 * @param id
	 * @param data
	 * @param cliente
	 * @param pagamento
	 * @param commesso
	 * @param servizio
	 */
	public Vendita(int id, Date data, Cliente cliente, Pagamento pagamento, Commesso commesso,
			ServizioComponent servizio) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.pagamento = pagamento;
		this.commesso = commesso;
		this.servizio = servizio;
	}

	/**
	 * Restituisce l'id della Vendita
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id della Vendita
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce la data della Vendita
	 * 
	 * @return Date
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * Imposta la data della Vendita
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Restituisce il Cliente della Vendita
	 * 
	 * @return Cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Imposta il Cliente che della Vendita
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Restituisce il Pagamento della Vendita
	 * 
	 * @return Pagamento
	 */
	public Pagamento getPagamento() {
		return this.pagamento;
	}

	/**
	 * Imposta il Pagamento della Vendita
	 * 
	 * @param pagamento
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * Restituisce il Commesso che ha effettuato la Vendita
	 * 
	 * @return Commesso
	 */
	public Commesso getCommesso() {
		return commesso;
	}

	/**
	 * Imposta il Commesso che ha effettuato la Vendita
	 * 
	 * @param commesso
	 */
	public void setCommesso(Commesso commesso) {
		this.commesso = commesso;
	}

	/**
	 * Restituisce il Servizio della Vendita
	 * 
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio() {
		return servizio;
	}

	/**
	 * Imposta il Servizio della Vendita
	 * 
	 * @param servizio
	 */
	public void setServizio(ServizioComponent servizio) {
		this.servizio = servizio;
	}

}