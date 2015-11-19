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
 * Il pacchetto è un insieme di servizi eterogenei
 */
@SuppressWarnings({ "all", "unchecked" })
public class PacchettoComposite extends com.speearth.model.core.ServizioComponent {
	public PacchettoComposite() {
	}
	
	private java.util.ArrayList<ServizioComponent> listaServizi = new java.util.ArrayList<>();
	
	/**
	 * Servizi che compongono il pacchetto
	 */
	public java.util.ArrayList<ServizioComponent> getListaServizi() {
		return listaServizi;
	}
	
	
	/**
	 * Costruisce un pacchetto da una lista di servizi
	 */
	public PacchettoComposite(java.util.ArrayList<ServizioComponent> servizi) {
		this.listaServizi = servizi;
	}
	
	/**
	 * Aggiunge un Servizio al pacchetto
	 */
	@Override	
	public void aggiungi(com.speearth.model.core.ServizioComponent servizio) {
		this.listaServizi.add(servizio);
		this.prezzo += servizio.getPrezzo();
	}
	
	/**
	 * Rimuove un Servizio dal pacchetto
	 */
	@Override	
	public void rimuovi(com.speearth.model.core.ServizioComponent servizio) {
		if (this.listaServizi.contains(servizio)) {
			this.prezzo -= servizio.getPrezzo();
			this.listaServizi.remove(servizio);
		}
	}
	
	/**
	 * Imposta la lista di Servizi che compongono il Pacchetto
	 */
	@Override	
	public void setListaServizi(java.util.ArrayList<ServizioComponent> servizi) {
		this.listaServizi = servizi;
		
		float prezzo = 0;
		for (ServizioComponent servizio : this.listaServizi)
			prezzo += servizio.getPrezzo();
		this.setPrezzo(prezzo);
	}
	
	/**
	 * Restituisce il servizio i-esimo del pacchetto. Nel comportamento di
	 * default restituisce null, per Biglietto e Alloggio. Nel caso del
	 * pacchetto va fatto l'override.
	 */
	public com.speearth.model.core.ServizioComponent getServizio(int i) {
		return listaServizi.get(i);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
