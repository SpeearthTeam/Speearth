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
	protected CalcolatoreBonus() {}

	/**
	 * Restituisce la singola instanza della classe
	 * @return CalcolatoreBonus
	 */
	public static CalcolatoreBonus getInstance() {
		if (instance == null)
			instance = new CalcolatoreBonus();
		return instance;
	}

	/**
	 * Restituisce i bonus del cliente
	 * @param cliente
	 * @return ArrayList<Bonus>
	 */
	public ArrayList<Bonus> getBonus(Cliente cliente) {
		ScontoConcreteStrategy bonus_strategy = new ScontoConcreteStrategy();
		return bonus_strategy.calcola(cliente);
	}

	/**
	 * Applica un bonus a un servizio
	 * @param servizio
	 * @param bonus
	 */
	public void applicaBonus(ServizioComponent servizio, Bonus bonus) {
		BonusStrategy bonus_strategy = null;
		
		if (bonus instanceof ScontoBonus)
			bonus_strategy = new ScontoConcreteStrategy();
		
		bonus_strategy.applica(servizio, bonus);
	}

}