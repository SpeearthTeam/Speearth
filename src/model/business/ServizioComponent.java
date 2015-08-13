package model.business;

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
	 * Aggiunge un Componente al Servizio composito
	 * 
	 * @param servizio
	 */
	public void aggiungi(ServizioComponent servizio);

	/**
	 * Rimuove un Componente dal Servizio composito
	 */
	public void rimuovi(ServizioComponent servizio);

	/**
	 * Restituisce un particolare Servizio del Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio(int i);

	/**
	 * Imposta la lista di Servizi che compongono il Pacchetto
	 * 
	 * @param servizi
	 */
	public void setListaServizi(ArrayList<ServizioComponent> servizi);

	/**
	 * Restituisce la lista di Servizi che compongono il Pacchetto
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> getListaServizi();
}