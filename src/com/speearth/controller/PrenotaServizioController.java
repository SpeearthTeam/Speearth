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
	 * Unica instanza del controller
	 */
	private static PrenotaServizioController instance;

	/**
	 * Costruttore di default
	 */
	private PrenotaServizioController() {
	}
	
	/**
	 * Restituisce l'instanza del controller
	 */
	public static PrenotaServizioController getInstance() {
		if (instance == null)
			instance = new PrenotaServizioController();
		return instance;
	}

	/**
	 * Avvia il Caso d'Uso
	 */
	@Override
	public void avvia() {
		// TODO
	}

	/**
	 * Chiude il Caso D'Uso
	 */
	@Override
	public void chiudi() {
		// TODO
		this.servizio = null;
	}

	/**
	 * Avvia l'Estensione PrenotaBiglietto
	 */
	public PrenotaBigliettoController getPrenotaBigliettoController() {
		return PrenotaBigliettoController.getInstance();
	}

	/**
	 * Avvia l'Estensione PrenotaAlloggio
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Avvia l'Estensione PrenotaPacchetto
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
		return AgenziaFacade.getInstance().getRegistroClienti().getClienteDaCodiceTessera(codice_tessera);
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
	public String effettuaPagamento(Cliente cliente, String metodo) {
		return AgenziaFacade.getInstance().getRegistratoreDiCassa().effettuaPagamento(this.servizio, cliente,
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
}
