/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.speearth.model.core;

/**
 * Interfaccia di un Servizio
 */
@SuppressWarnings({ "all", "unchecked" })
public abstract class ServizioComponent {
	public ServizioComponent() {
	}
	
	protected int id;
	
	protected float prezzo = 0f;
	
	/**
	 * Id
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * Id
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * Prezzo
	 */
	public void setPrezzo(float value) {
		this.prezzo = value;
	}
	
	/**
	 * Prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}
	
	/**
	 * Aggiunge un Componente al Servizio composito
	 */
	public void aggiungi(com.speearth.model.core.ServizioComponent servizio) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Rimuove un Componente dal Servizio composito
	 */
	public void rimuovi(com.speearth.model.core.ServizioComponent servizio) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Restituisce il servizio i-esimo del pacchetto. Nel comportamento di
	 * default restituisce null, per Biglietto e Alloggio. Nel caso del
	 * pacchetto va fatto l'override.
	 */
	public com.speearth.model.core.ServizioComponent getServizio(int i) {
		return null;
	}
	
	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	public void setListaServizi(java.util.ArrayList<ServizioComponent> servizi) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	public java.util.List<ServizioComponent> getListaServizi() {
		return null;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
