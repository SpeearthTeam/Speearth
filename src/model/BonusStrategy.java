package model;

import java.util.ArrayList;

/**
 * Strategy per il bonus
 */
public interface BonusStrategy {

	/**
	 * Calcola i bonus del cliente
	 * @param cliente
	 */
	public ArrayList<Bonus> calcola(Cliente cliente);
	
	/**
	 * Applica un bonus a un servizio
	 * @param servizio
	 * @param bonus
	 */
	public void applica(ServizioComponent servizio, Bonus bonus);

}