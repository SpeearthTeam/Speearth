package com.speearth.model.core;

import java.util.ArrayList;

/**
 * Interfaccia di un Servizio
 */
public abstract class ServizioComponent {

	/**
	 * Id
	 */
	protected int id;

	/**
	 * Prezzo
	 */
	protected float prezzo = 0;

	/**
	 * Restituisce l'id del servizio
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Imposta l'id del servizio
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Restituisce il prezzo del servizio
	 * 
	 * @return float
	 */
	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * Imposta il prezzo del servizio
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Aggiunge un Componente al Servizio composito
	 * 
	 * @param servizio
	 */
	public void aggiungi(ServizioComponent servizio) {

	}

	/**
	 * Rimuove un Componente dal Servizio composito
	 */
	public void rimuovi(ServizioComponent servizio) {

	}

	/**
	 * Restituisce il servizio i-esimo del pacchetto. Nel comportamento di
	 * default restituisce null, per Biglietto e Alloggio. Nel caso del
	 * pacchetto va fatto l'override.
	 * 
	 * @return ServizioComponent
	 */
	public ServizioComponent getServizio(int i) {
		return null;
	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	public void setListaServizi(ArrayList<ServizioComponent> servizi) {

	}

	/**
	 * Il metodo non si applica in quanto questa classe non è composita
	 */
	public ArrayList<ServizioComponent> getListaServizi() {
		return null;
	}

}