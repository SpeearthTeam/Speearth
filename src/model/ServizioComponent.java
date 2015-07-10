package model;

import java.util.ArrayList;

/**
 * Interfaccia di un Servizio
 */
public interface ServizioComponent {
	
	/**
	 * Restituisce il prezzo del servizio
	 * 
	 * @return float
	 */
	public float getPrezzo();
	
	/**
	 * Imposta il prezzo del servizio
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo);
	
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
	 * Imposta i servizi annidati
	 * 
	 * @param servizi
	 */
	public void setServiziAnnidati(ArrayList<ServizioComponent> servizi);

	/**
	 * Restituisce i servizi annidati di un servizio
	 * 
	 * @return ServizioComponent
	 */
	public ArrayList<ServizioComponent> getServiziAnnidati();
}