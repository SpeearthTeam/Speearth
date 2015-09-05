package com.speearth.controller;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Cliente;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.core.bonus.CalcolatoreBonus;
import com.speearth.model.core.bonus.IBonus;
import com.speearth.model.core.bonus.IBonusStrategy;
import com.speearth.model.core.bonus.ScontoConcreteStrategy;

/**
 * Controller per il Caso d'Uso PrenotaServizio
 */
public class PrenotaServizioController implements ICasoDUsoController {
	/**
	 * Servizio in prenotazione
	 */
	private IServizioComponent servizio;

	/**
	 * Cliente che sta per acquistare il Servizio
	 */
	private Cliente cliente;

	/**
	 * Unica istanza del controller
	 */
	private static PrenotaServizioController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaServizioController() {
	}

	/**
	 * Restituisce l'istanza del controller
	 */
	public static PrenotaServizioController getInstance() {
		if (instance == null)
			instance = new PrenotaServizioController();
		return instance;
	}

	/**
	 * Restituisce il Controller di PrenotaBiglietto
	 */
	public PrenotaBigliettoController getPrenotaBigliettoController() {
		return PrenotaBigliettoController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaAlloggio
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaPacchetto
	 */
	public PrenotaPacchettoController getPrenotaPacchettoController() {
		return PrenotaPacchettoController.getInstance();
	}

	/**
	 * Identifica un Cliente dallo storico dell'Agenzia tramite il codice della
	 * sua tessera
	 * 
	 * @param codice_tessera
	 * @return Cliente
	 */
	public Cliente identificaCliente(String codice_tessera) {
		this.setCliente(AgenziaFacade.getInstance().getRegistroClienti().getClienteDaCodiceTessera(codice_tessera));
		return this.cliente;
	}

	/**
	 * Calcola il miglior Bonus per il Cliente
	 * 
	 * @param cliente
	 * @return Bonus
	 */
	public IBonus calcolaBonus(Cliente cliente) {
		ScontoConcreteStrategy strategy_sconto = new ScontoConcreteStrategy();
		CalcolatoreBonus calcolatore_sconto = new CalcolatoreBonus(strategy_sconto);
		return calcolatore_sconto.getBonus(cliente);
	}

	/**
	 * Applica il Bonus al Servizio in prenotazione
	 * 
	 * @param bonus
	 */
	public IServizioComponent applicaBonus(IBonus bonus, IBonusStrategy strategy) {
		CalcolatoreBonus calcolatore = new CalcolatoreBonus(strategy);
		calcolatore.applicaBonus(this.servizio, bonus);
		return this.servizio;
	}

	/**
	 * Effettua il Pagamento per il Servizio verso l'Agenzia
	 * 
	 * @param cliente
	 * @param metodo
	 * @return String
	 */
	public String effettuaPagamento(String metodo) {
		return AgenziaFacade.getInstance().getRegistratoreDiCassa().effettuaPagamento(this.servizio, this.cliente,
				AppFacadeController.getInstance().getUtente(), metodo);
	}

	/**
	 * Restituisce il Servizio in prenotazione
	 * 
	 * @return ServizioComponent
	 */
	public IServizioComponent getServizio() {
		return this.servizio;
	}

	/**
	 * Imposta il Servizio in prenotazione
	 * 
	 * @param servizio
	 */
	public void setServizio(IServizioComponent servizio) {
		this.servizio = servizio;
	}

	/**
	 * Restituisce il Cliente
	 * 
	 * @return Cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Imposta il Cliente
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
