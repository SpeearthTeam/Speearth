package com.speearth.model.core;

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
	 * Effettua un Pagamento di un Servizio TODO il Commesso va recuperato dalla Sessione =======> Controller
	 * 
	 * @param servizio
	 * @param cliente
	 * @param commesso
	 * @param metodo
	 */
	public String effettuaPagamento(IServizioComponent servizio, Cliente cliente, Commesso commesso, String metodo) {
		float ammontare = servizio.getPrezzo();
		Pagamento pagamento = new Pagamento(ammontare, metodo);
		Vendita vendita = new Vendita(cliente, pagamento, commesso, servizio);

		AgenziaFacade.getInstance().getRegistroVendite().registraVendita(vendita);
		return pagamento.generaRicevuta();
	}

}