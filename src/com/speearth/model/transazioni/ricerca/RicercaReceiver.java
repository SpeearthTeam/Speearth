package com.speearth.model.transazioni.ricerca;

import java.io.IOException;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.HashMap;

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
	private RicercaReceiver() {
		this.risultato_ricerca = new ArrayList<IServizioComponent>();
	}

	/**
	 * Restituisce il risultato di un comando di Ricerca
	 * 
	 * @return ArrayList<IServizioComponent>
	 */
	public ArrayList<IServizioComponent> getRisultatoRicerca() {
		return this.risultato_ricerca;
	}

	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 * @throws HttpRetryException 
	 */
	public ArrayList<IServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) throws IOException {
		this.svuotaRisultatiRicerca();
		
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = SistemaEsternoFactory.getInstance()
				.getImpreseRicettive();
		
		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {
			
			ArrayList<IServizioComponent> servizi;
			servizi = impresa_ricettiva.ricerca(parametri);
			
			for (IServizioComponent servizio : servizi) {
				this.risultato_ricerca.add((Alloggio) servizio);
			}
		}
		
		return this.risultato_ricerca;
	}

	/**
	 * Effettua una ricerca di biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 * @throws HttpRetryException 
	 */
	public ArrayList<IServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) throws IOException {
		this.svuotaRisultatiRicerca();
		
		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = SistemaEsternoFactory.getInstance()
				.getAziendeDiTrasporto();
		
		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {
			
			ArrayList<IServizioComponent> servizi;
			servizi = azienda_trasporto.ricerca(parametri);
			
			for (IServizioComponent servizio : servizi) {
				this.risultato_ricerca.add((Biglietto) servizio);
			}
		}
		
		return this.risultato_ricerca;
	}

	/**
	 * Svuota i risultati di ricerca
	 */
	private void svuotaRisultatiRicerca() {
		this.risultato_ricerca.clear();
	}

}