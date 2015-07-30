package model;

import java.util.ArrayList;

/**
 * Strategy per il bonus
 */
public interface BonusStrategy {

	/**
	 * Calcola il Bonus a cui ha diritto il cliente il cliente
	 * 
	 * @param cliente
	 */
	public Bonus calcola(ArrayList<Vendita> vendite);
	
	/**
	 * Applica il Bonus al Servizio di un cliente
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applica(ServizioComponent servizio, Bonus bonus);

}