package model.tools;

import java.util.ArrayList;

import model.business.Bonus;
import model.business.ServizioComponent;
import model.business.Vendita;

/**
 * Strategy per il bonus
 */
public interface BonusStrategy {
	/**
	 * Calcola il Bonus a cui ha diritto il Cliente
	 * 
	 * @param cliente
	 */
	public Bonus calcola(ArrayList<Vendita> vendite);

	/**
	 * Applica il Bonus al Servizio in prenotazione per un Cliente
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applica(ServizioComponent servizio, Bonus bonus);

}