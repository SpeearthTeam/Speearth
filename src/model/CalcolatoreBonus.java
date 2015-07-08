package model;

import java.util.ArrayList;

/**
 * Classe addetta alla gestione dei bonus
 */
public class CalcolatoreBonus {

	/**
	 * Instanza della classe
	 */
	private static CalcolatoreBonus instance;

	/**
	 * Metodo costruttore
	 */
	protected CalcolatoreBonus() {
	}

	/**
	 * Restituisce la singola instanza della classe
	 * 
	 * @return CalcolatoreBonus
	 */
	public static CalcolatoreBonus getInstance() {
		if (instance == null)
			instance = new CalcolatoreBonus();
		return instance;
	}

	/**
	 * Restituisce il Bonus più vantaggioso per il Cliente
	 * 
	 * @param cliente
	 * @return Bonus
	 */
	public Bonus getBonus(Cliente cliente) {
		// inzializza una lista di Bonus
		ArrayList<Bonus> lista_bonus = new ArrayList<Bonus>();
		ArrayList<Vendita> vendite = Agenzia.getInstance().getRegistroVendite().getVendite(cliente);

		// crea le Strategy disponibili
		ScontoConcreteStrategy sconto_strategy = new ScontoConcreteStrategy();

		// aggiunge i Bonus calcolati dalle Strategy alla lista
		lista_bonus.add(sconto_strategy.calcola(vendite));

		// calcola il Bonus migliore tra quelli calcolati
		
		// Prima iterazione: evitiamo il calcolo del Bonus migliore in quanto
		// disponiamo di una sola Strategy
		return lista_bonus.get(0);
	}

	/**
	 * Applica un Bonus a un Servizio
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applicaBonus(ServizioComponent servizio, Bonus bonus) {
		if (bonus.getServizio() != null) {
			// aggiungi il Servizio al Pacchetto
		}
		
		servizio.setTotale(servizio.getPrezzo() * ((ScontoBonus) bonus).getSconto() / 100);
	}

}