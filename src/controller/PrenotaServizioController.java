package controller;

import java.util.ArrayList;

import model.AgenziaFacade;
import model.Bonus;
import model.BonusStrategy;
import model.CalcolatoreBonus;
import model.Cliente;
import model.ScontoConcreteStrategy;
import model.ServizioComponent;

/**
 * Controller per il Caso d'Uso PrenotaServizio
 */
public class PrenotaServizioController implements CasoDUsoController {
	/**
	 * Istanza della classe
	 */
	private static PrenotaServizioController instance;

	/**
	 * Elenco di Estensioni e/o Inclusioni nel Caso d'Uso
	 */
	private ArrayList<GancioController> ganci;

	/**
	 * Servizio in prenotazione
	 */
	private ServizioComponent servizio;

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
		this.ganci.clear();
		this.servizio = null;
	}

	/**
	 * Avvia l'Estensione PrenotaBiglietto
	 */
	public void prenotaBiglietto() {
		this.ganci.add(new PrenotaBigliettoController());
		this.ganci.get(this.ganci.size()).avvia();
	}

	/**
	 * Avvia l'Estensione PrenotaAlloggio
	 */
	public void prenotaAlloggio() {
		this.ganci.add(new PrenotaAlloggioController());
		this.ganci.get(this.ganci.size()).avvia();
	}

	/**
	 * Avvia l'Estensione PrenotaPacchetto
	 */
	public void prenotaPacchetto() {
		this.ganci.add(new PrenotaPacchettoController());
		this.ganci.get(this.ganci.size()).avvia();
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
	public Bonus calcolaBonus(Cliente cliente) {
		// TODO - a livello di MODEL non c'è ancora un metodo per scegliere il
		// bonus migliore tra più strategy
		ScontoConcreteStrategy strategy_sconto = new ScontoConcreteStrategy();
		CalcolatoreBonus calcolatore_sconto = new CalcolatoreBonus(strategy_sconto);
		return calcolatore_sconto.getBonus(cliente);
	}

	/**
	 * Applica il Bonus al Servizio in prenotazione
	 * 
	 * @param bonus
	 */
	public ServizioComponent applicaBonus(Bonus bonus, BonusStrategy strategy) {
		// TODO - come faccio a sapere quale strategy mi serve per applicare il
		// bonus?
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
	 * Restituisce l'elenco di Ganci
	 */
	public ArrayList<GancioController> getGanci() {
		return ganci;
	}

	/**
	 * Imposta l'elenco di Ganci
	 * 
	 * @param ganci
	 */
	public void setGanci(ArrayList<GancioController> ganci) {
		this.ganci = ganci;
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
	 * Restituisce un Gancio del Caso d'Uso
	 * 
	 * @param i
	 * @return GancioController
	 */
	@Override
	public GancioController getGancio(int i) {
		return this.ganci.get(i);
	}

	/**
	 * Rimuove un Gancio da un Caso d'Uso
	 * 
	 * @param gancio
	 */
	@Override
	public void rimuoviGancio(GancioController gancio) {
		this.ganci.remove(gancio);
	}
}
