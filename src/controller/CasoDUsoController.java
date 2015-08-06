package controller;

/**
 * Interfaccia che rappresenta un Caso d'Uso
 */
public interface CasoDUsoController {
	/**
	 * Avvia il Caso d'uso
	 */
	public void avvia();

	/**
	 * Chiude il Caso d'Uso
	 */
	public void chiudi();

	/**
	 * Restituisce un Gancio del Caso d'Uso
	 * 
	 * @param i
	 * @return GancioController
	 */
	public GancioController getGancio(int i);
	
	/**
	 * Rimuove un Gancio da un Caso d'Uso
	 * 
	 * @param gancio
	 */
	public void rimuoviGancio(GancioController gancio);
}
