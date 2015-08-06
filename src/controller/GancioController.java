package controller;

/**
 * Interfaccia che rappresenta un'Estensione o un'Inclusione del Caso d'Uso
 */
public interface GancioController extends CasoDUsoController {
	/**
	 * Restituisce il Caso d'Uso base al quale appartiene
	 * 
	 * @return CasoDUsoController
	 */
	public CasoDUsoController getBase();
}
