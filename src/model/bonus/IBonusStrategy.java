package model.bonus;

import java.util.ArrayList;

import model.core.IServizioComponent;
import model.core.Vendita;

/**
 * Strategy per il bonus
 */
public interface IBonusStrategy {
	/**
	 * Calcola il Bonus a cui ha diritto il Cliente
	 * 
	 * @param cliente
	 */
	public IBonus calcola(ArrayList<Vendita> vendite);

	/**
	 * Applica il Bonus al Servizio in prenotazione per un Cliente
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applica(IServizioComponent servizio, IBonus bonus);

}