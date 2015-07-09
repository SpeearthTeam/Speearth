package model;

/**
 * Interfaccia di un Servizio
 */
public interface ServizioComponent {
	/**
	 * Restituisce il prezzo totale del Servizio
	 * 
	 * @return float
	 */
	public float getTotale();

	/**
	 * Imposta il prezzo totale del Servizio
	 * 
	 * @param totale
	 */
	public void setTotale(float totale);

	/**
	 * Aggiunge un Componente al Servizio composito
	 * 
	 * @param ServizioComponent
	 */
	public void aggiungi(ServizioComponent servizio);

	/**
	 * Rimuove un Componente dal Servizio composito
	 */
	public void rimuovi(ServizioComponent servizio);

	/**
	 * Restituisce un Componente incluso nel Servizio composito
	 * 
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio(int indice);
}