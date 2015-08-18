package model.core.bonus;

/**
 * Bonus di tipologia sconto
 */
public class ScontoBonus implements IBonus {
	
	/**
	 * Sconto in percentuale
	 */
	private int sconto;

	/**
	 * Costruttore
	 */
	public ScontoBonus() {
	}

	/**
	 * Ritorna lo sconto
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