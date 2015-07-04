package Model;

public interface BonusStrategy {

	/**
	 * 
	 * @param cliente
	 */
	Bonus[] calcola(Cliente cliente);

}