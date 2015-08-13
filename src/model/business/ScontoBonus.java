package model.business;

/**
 * Bonus di tipologia sconto
 */
public class ScontoBonus implements Bonus {
	/**
	 * Sconto in percentuale
	 */
	private int sconto;

	/**
	 * Costruttore
	 */
	public ScontoBonus() {
	}

	public int getSconto() {
		return sconto;
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