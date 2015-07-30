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
	 */
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

}