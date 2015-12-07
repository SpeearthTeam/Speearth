package com.speearth.controller;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Cliente;
import com.speearth.model.core.ServizioComponent;
import com.speearth.model.core.bonus.CalcolatoreBonus;
import com.speearth.model.core.bonus.IBonus;
import com.speearth.model.core.bonus.IBonusStrategy;
import com.speearth.model.core.bonus.ScontoConcreteStrategy;

/**
 * Controller per il Caso d'Uso PrenotaServizio
 */
public class PrenotaServizioController implements ICasoDUsoController {
	/**
	 * Unica istanza del Controller
	 */
	private static PrenotaServizioController instance;

	/**
	 * Servizio in prenotazione
	 */
	private ServizioComponent servizio;

	/**
	 * Cliente che sta per acquistare il Servizio
	 */
	private Cliente cliente;

	/**
	 * Costruttore di default
	 */
	private PrenotaServizioController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 * 
	 * @return PrenotaServizioController
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
	 * 
	 * @return PrenotaAlloggioController
	 */
	public PrenotaAlloggioController getPrenotaAlloggioController() {
		return PrenotaAlloggioController.getInstance();
	}

	/**
	 * Restituisce il Controller di PrenotaPacchetto
	 * 
	 * @return PrenotaPacchettoController
	 */
	public PrenotaPacchettoController getPrenotaPacchettoController() {
		return PrenotaPacchettoController.getInstance();
	}
	
	/**
	 * Restituisce il Controller di AcquistaOfferta
	 * 
	 * @return AcquistaOffertaController
	 */
	public AcquistaOffertaController getAcquistaOffertaController() {
		return AcquistaOffertaController.getInstance();
	}

	/**
	 * Restituisce il Controller di GestisciClienti
	 * 
	 * @return GestisciClientiController
	 */
	public GestisciClientiController getGestisciClientiController() {
		return GestisciClientiController.getInstance();
	}

	/**
	 * Identifica un Cliente dallo storico dell'Agenzia tramite il codice della
	 * sua Tessera
	 * 
	 * @param i
	 * @return Cliente
	 */
	public Cliente identificaCliente(String i) {
		this.setCliente(AgenziaFacade.getInstance().getRegistroClienti().cercaClienteDaCodiceTessera(i));
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
	public ServizioComponent applicaBonus(IBonus bonus, IBonusStrategy strategy) {
		CalcolatoreBonus calcolatore = new CalcolatoreBonus(strategy);
		calcolatore.applicaBonus(this.servizio, bonus);
		return this.servizio;
	}

	/**
	 * Effettua il Pagamento per il Servizio verso l'Agenzia
	 * 
	 * @param metodo
	 * @return String
	 */
	public String effettuaPagamento(String metodo) {
		return AgenziaFacade.getInstance().getRegistroVendite().registraVendita(metodo, this.getCliente(),
				AppFacadeController.getInstance().getUtente(), this.getServizio());
	}

	/**
	 * Restituisce il Servizio in prenotazione
	 * 
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio() {
		return this.servizio;
	}

	/**
	 * Imposta il Servizio in prenotazione
	 * 
	 * @param servizio
	 */
	public void setServizio(ServizioComponent servizio) {
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

	/**
	 * Ristabilisce lo stato di partenza del Caso D'Uso
	 */
	public void reset() {
		this.cliente = null;
		this.servizio = null;
	}
}
