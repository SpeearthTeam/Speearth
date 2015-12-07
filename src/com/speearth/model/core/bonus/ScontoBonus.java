package com.speearth.model.core.bonus;

/**
 * Bonus di tipologia Sconto
 */
public class ScontoBonus implements IBonus {
	/**
	 * Sconto in percentuale
	 */
	private int sconto;

	/**
	 * Costruttore di default
	 */
	public ScontoBonus() {
	}

	/**
	 * Restituisce lo sconto
	 * 
	 * @return int
	 */
	public int getSconto() {
		return this.sconto;
	}

	/**
	 * Imposta lo sconto
	 * 
	 * @param sconto
	 */
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
}