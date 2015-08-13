package model.bonus;

import java.util.ArrayList;

import model.core.AgenziaFacade;
import model.core.Cliente;
import model.core.IServizioComponent;
import model.core.Vendita;

/**
 * Classe addetta alla gestione dei Bonus
 */
public class CalcolatoreBonus {
	/**
	 * Strategia di bonus: BonusSconto o Servizio
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
	public void applicaBonus(IServizioComponent servizio, IBonus bonus) {
		this.strategy.applica(servizio, bonus);
	}

}