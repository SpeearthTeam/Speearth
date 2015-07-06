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
	 * Metodo costruttore
	 */
	public Vendita() {}
	
	/**
	 * Metodo costruttore
	 * @param servizio
	 * @param cliente
	 * @param pagamento
	 * @param commesso
	 */
	public Vendita(ServizioComponent servizio, Cliente cliente, Pagamento pagamento, Commesso commesso) {
		setServizio(servizio);
		setCliente(cliente);
		setPagamento(pagamento);
		setCommesso(commesso);
		setData(new Date());
	}

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
	 * Restituisce il cliente
	 * @return Cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Imposta il cliente
	 * @param cliente
	 * @return Vendita
	 */
	public Vendita setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	/**
	 * Restituisce il commesso
	 * @return Commesso
	 */
	public Commesso getCommesso() {
		return commesso;
	}

	/**
	 * Imposta il commesso
	 * @param commesso
	 * @return Vendita
	 */
	public Vendita setCommesso(Commesso commesso) {
		this.commesso = commesso;
		return this;
	}

	/**
	 * Restituisce il servizio
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio() {
		return servizio;
	}

	/**
	 * Imposta il servizio
	 * @param servizio
	 * @return Vendita
	 */
	public Vendita setServizio(ServizioComponent servizio) {
		this.servizio = servizio;
		return this;
	}

}