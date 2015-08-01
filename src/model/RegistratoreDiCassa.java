package model;

/**
 * Registratore di cassa
 */
public class RegistratoreDiCassa {

	/**
	 * Istanza della classe
	 */
	private static RegistratoreDiCassa instance;

	/**
	 * Restiuisce la singola istanza della classe
	 * 
	 * @return RegistratoreDiCassa
	 */
	public static RegistratoreDiCassa getInstance() {
		if (instance == null)
			instance = new RegistratoreDiCassa();
		return instance;
	}

	/**
	 * Effettua un Pagamento di un Servizio
	 * 
	 * @param servizio
	 * @param cliente
	 * @param metodo
	 */
	public String effettuaPagamento(ServizioComponent servizio, Cliente cliente, String metodo) {
		// andrebbe recuperato dalla Sessione dell'agenzia
		Commesso commesso = new Commesso();

		float ammontare = servizio.getTotale();
		Pagamento pagamento = new Pagamento(ammontare, metodo);
		Vendita vendita = new Vendita(cliente, pagamento, commesso, servizio);
		
		Agenzia.getInstance().getRegistroVendite().registraVendita(vendita);
		return pagamento.generaRicevuta();
	}

}