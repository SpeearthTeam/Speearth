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
	 * Restituisce un Frammento (Estensione o Inclusione) del Caso D'Uso
	 * 
	 * @param i
	 * @return CasoDUsoController
	 */
	public CasoDUsoController getFrammento(int i);
	
	/**
	 * Aggiunge un Frammento (Estensione o Inclusione) al Caso D'Uso
	 * 
	 * @param gancio
	 */
	public void aggiungiFrammento(CasoDUsoController frammento);
	
	/**
	 * Rimuove un Frammento (Estensione o Inclusione) dal Caso D'Uso
	 * 
	 * @param gancio
	 */
	public void rimuoviFrammento(CasoDUsoController frammento);
	
	/**
	 * Restituisce il Caso D'Uso base di un Frammento (Estensione o Inclusione)
	 * 
	 * @return CasoDUsoController
	 */
	public CasoDUsoController getCasoDUsoBase();
}
