package model;

/**
 * Classe che rappresenta un Bonus applicabile a un Servizio
 */
public abstract class Bonus {
	/**
	 * Sconto
	 */
	protected int sconto;

	/**
	 * Restituisce lo sconto
	 * 
	 * @return int
	 */
	public int getSconto() {
		return this.sconto;
	}
}