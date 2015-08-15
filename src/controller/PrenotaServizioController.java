package controller;

import model.core.AgenziaFacade;
import model.core.Cliente;
import model.core.IServizioComponent;
import model.core.bonus.CalcolatoreBonus;
import model.core.bonus.IBonus;
import model.core.bonus.IBonusStrategy;
import model.core.bonus.ScontoConcreteStrategy;

/**
 * Controller per il Caso d'Uso PrenotaServizio
 */
public class PrenotaServizioController implements ICasoDUsoController {
	/**
	 * Istanza della classe
	 */
	private static PrenotaServizioController instance;

	/**
	 * Eventuale Frammento (Estensione e/o Inclusione) del Caso d'Uso
	 */
	private ICasoDUsoController frammento;

	/**
	 * Servizio in prenotazione
	 */
	private IServizioComponent servizio;

	/**
	 * Costruttore di default
	 */
	public PrenotaServizioController() {
	}

	/**
	 * Restituisce la singola instanza della classe
	 * 
	 * @return AppFacadeController
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
	public void prenotaBiglietto() {
		this.avviaFrammento(new PrenotaBigliettoController());
	}

	/**
	 * Avvia l'Estensione PrenotaAlloggio
	 */
	public void prenotaAlloggio() {
		this.avviaFrammento(new PrenotaAlloggioController());
	}

	/**
	 * Avvia l'Estensione PrenotaPacchetto
	 */
	public void prenotaPacchetto() {
		this.avviaFrammento(new PrenotaPacchettoController());
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

	/**
	 * Aggiunge un Frammento (Estensione o Inclusione) al Caso D'Uso
	 * 
	 * @param frammento
	 */
	@Override
	public void avviaFrammento(ICasoDUsoController frammento) {
		this.frammento = frammento;
		this.frammento.avvia();
	}

	/**
	 * Rimuove un Frammento (Estensione o Inclusione) dal Caso D'Uso
	 * 
	 * @param frammento
	 */
	@Override
	public void rimuoviFrammento(ICasoDUsoController frammento) {
		this.frammento = null;
	}
}
