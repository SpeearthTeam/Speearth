package model;

import java.util.ArrayList;

/**
 * Strategy per il bonus
 */
public interface BonusStrategy {

	/**
	 * Calcola il Bonus per il cliente
	 * 
	 * @param cliente
	 */
	public Bonus calcola(ArrayList<Vendita> vendite);

}