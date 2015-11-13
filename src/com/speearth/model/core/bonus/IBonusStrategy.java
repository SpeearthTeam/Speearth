package com.speearth.model.core.bonus;

import java.util.ArrayList;

import com.speearth.model.core.ServizioComponent;
import com.speearth.model.core.Vendita;

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
	public void applica(ServizioComponent servizio, IBonus bonus);

}