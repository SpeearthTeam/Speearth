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
	 * Costruttore
	 */
	public ScontoBonus() {
		this.sconto = 0;
	}

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
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

}