package com.speearth.model.transazioni.ricerca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
import com.speearth.model.sistemi_esterni.AziendaTrasportoAdapter;
import com.speearth.model.sistemi_esterni.ImpresaRicettivaAdapter;
import com.speearth.model.sistemi_esterni.SistemaEsternoFactory;

/**
 * Receiver del sistema di ricerca
 */
public class RicercaReceiver {
	
	/**
	 * Istanza della classe
	 */
	private static RicercaReceiver instance;
	
	/**
	 * Risultato del comando Ricerca
	 */
	private ArrayList<IServizioComponent> risultato_ricerca;

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return RicercaReceiver
	 */
	public static RicercaReceiver getInstance() {
		if (instance == null)
			instance = new RicercaReceiver();
		return instance;
	}
	
	/**
	 * Costruttore di default
	 */
	private RicercaReceiver(){}
	
	/**
	 * Restituisce il risultato di un comando di Ricerca
	 * 
	 * @return ArrayList<IServizioComponent>
	 */
	public ArrayList<IServizioComponent> getRisultatoRicerca(){
		return this.risultato_ricerca;
	}
	
	/**
	 * Imposta il risultato di un comando di Ricerca Alloggi
	 * 
	 * @param parametri
	 */
	private void setRisultatoRicercaAlloggi(HashMap<String, String> parametri){
		
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = SistemaEsternoFactory.getInstance()
				.getImpreseRicettive();

		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {

			ArrayList<IServizioComponent> servizi;
			try {
				servizi = impresa_ricettiva.ricerca(parametri);
				for (IServizioComponent servizio : servizi)
					this.risultato_ricerca.add((Alloggio) servizio);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<IServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) {
		
		this.setRisultatoRicercaAlloggi(parametri);
		return this.risultato_ricerca;
		
	}

	/**
	 * Imposta il risultato di un comando di Ricerca Biglietti
	 * 
	 * @param parametri
	 */
	private void setRisultatoRicercaBiglietti(HashMap<String, String> parametri){
		
		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = SistemaEsternoFactory.getInstance()
				.getAziendeDiTrasporto();

		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {

			ArrayList<IServizioComponent> servizi;
			try {
				servizi = azienda_trasporto.ricerca(parametri);
				for (IServizioComponent servizio : servizi)
					this.risultato_ricerca.add((Biglietto) servizio);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Effettua una ricerca di biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<IServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) {

		this.setRisultatoRicercaBiglietti(parametri);
		return this.risultato_ricerca;
		
	}

}