package model.transazioni;

/**
 * 
 * Interfaccia rappresentante una generica Transazioni che l'Agenzia deve effettuare
 * 
 */
public interface ITransazioniCommand {
	
	/**
	 * 
	 * Fa eseguire il comando al receiver
	 * 
	 */
	public void esegui();

}