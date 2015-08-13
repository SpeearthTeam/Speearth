package model.tools;

import java.util.ArrayList;

import model.business.AgenziaFacade;
import model.business.Bonus;
import model.business.Cliente;
import model.business.ServizioComponent;
import model.business.Vendita;

/**
 * Classe addetta alla gestione dei Bonus
 */
public class CalcolatoreBonus {
	/**
	 * Strategia di bonus: BonusSconto o Servizio
	 */
	private BonusStrategy strategy;

	/**
	 * Costruttore
	 * 
	 * @param strategy
	 */
	public CalcolatoreBonus(BonusStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Restituisce il Bonus pi� vantaggioso per il Cliente
	 * 
	 * @param cliente
	 * @return Bonus
	 */
	public Bonus getBonus(Cliente cliente) {
		ArrayList<Vendita> vendite = AgenziaFacade.getInstance().getRegistroVendite().getVenditeDaCliente(cliente);
		return this.strategy.calcola(vendite);
	}

	/**
	 * Applica un Bonus a un Servizio
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applicaBonus(ServizioComponent servizio, Bonus bonus) {
		this.strategy.applica(servizio, bonus);
	}

}