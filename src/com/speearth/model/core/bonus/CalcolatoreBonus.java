package com.speearth.model.core.bonus;

import java.util.ArrayList;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Cliente;
import com.speearth.model.core.ServizioComponent;
import com.speearth.model.core.Vendita;

/**
 * Classe addetta alla gestione dei Bonus
 */
public class CalcolatoreBonus {
	/**
	 * Strategia di calcolo del Bonus
	 */
	private IBonusStrategy strategy;

	/**
	 * Costruttore
	 * 
	 * @param strategy
	 */
	public CalcolatoreBonus(IBonusStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Restituisce il Bonus più vantaggioso per il Cliente
	 * 
	 * @param cliente
	 * @return Bonus
	 */
	public IBonus getBonus(Cliente cliente) {
		ArrayList<Vendita> vendite = AgenziaFacade.getInstance().getRegistroVendite().getVenditeDaCliente(cliente);
		return this.strategy.calcola(vendite);
	}

	/**
	 * Applica un Bonus a un Servizio
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applicaBonus(ServizioComponent servizio, IBonus bonus) {
		this.strategy.applica(servizio, bonus);
	}
}