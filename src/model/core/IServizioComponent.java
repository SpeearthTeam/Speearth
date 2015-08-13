package model.core;

import java.util.ArrayList;

/**
 * Interfaccia di un Servizio
 */
public interface IServizioComponent {

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
	public void aggiungi(IServizioComponent servizio);

	/**
	 * Rimuove un Componente dal Servizio composito
	 */
	public void rimuovi(IServizioComponent servizio);

	/**
	 * Restituisce un particolare Servizio del Pacchetto
	 * 
	 * @return ServizioComponent
	 */
	public IServizioComponent getServizio(int i);

	/**
	 * Imposta la lista di Servizi che compongono il Pacchetto
	 * 
	 * @param servizi
	 */
	public void setListaServizi(ArrayList<IServizioComponent> servizi);

	/**
	 * Restituisce la lista di Servizi che compongono il Pacchetto
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<IServizioComponent> getListaServizi();
}