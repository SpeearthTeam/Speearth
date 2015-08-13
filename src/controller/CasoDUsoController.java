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
	 * Avvia un Frammento (Estensione o Inclusione) del Caso D'Uso
	 * 
	 * @param frammento
	 */
	public void avviaFrammento(CasoDUsoController frammento);

	/**
	 * Rimuove un Frammento (Estensione o Inclusione) dal Caso D'Uso
	 * 
	 * @param frammento
	 */
	public void rimuoviFrammento(CasoDUsoController frammento);

}
