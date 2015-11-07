package com.speearth.model.core;

import java.util.Date;

/**
 * Classe rappresentante una Vendita effettuata dall'Agenzia
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
	private Impiegato commesso;

	/**
	 * Servizio
	 */
	private IServizioComponent servizio;

	/**
	 * Costruttore di default
	 */
	public Vendita() {
	}

	/**
	 * Costruttore con parametri
	 * 
	 * @param cliente
	 * @param pagamento
	 * @param commesso
	 * @param servizio
	 */
	public Vendita(Cliente cliente, Pagamento pagamento, Impiegato commesso,
			IServizioComponent servizio) {
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
		return this.cliente;
	}

	/**
	 * Imposta il Cliente alla Vendita
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
	public Impiegato getCommesso() {
		return this.commesso;
	}

	/**
	 * Imposta il Commesso che sta effettuando la Vendita
	 * 
	 * @param commesso
	 */
	public void setCommesso(Impiegato commesso) {
		this.commesso = commesso;
	}

	/**
	 * Restituisce il Servizio della Vendita
	 * 
	 * @return ServizioComponent
	 */
	public IServizioComponent getServizio() {
		return this.servizio;
	}

	/**
	 * Imposta il Servizio alla Vendita
	 * 
	 * @param servizio
	 */
	public void setServizio(IServizioComponent servizio) {
		this.servizio = servizio;
	}

}