package model;

/**
 * Bonus di tipologia sconto
 */
public class ScontoBonus extends Bonus {

	/**
	 * Sconto
	 */
	private int sconto;

	/**
	 * Restituisce lo sconto
	 * @return int
	 */
	public int getSconto() {
		return this.sconto;
	}

	/**
	 * Imposta lo sconto
	 * @param sconto
	 * @return ScontoBonus
	 */
	public ScontoBonus setSconto(int sconto) {
		this.sconto = sconto;
		return this;
	}

}