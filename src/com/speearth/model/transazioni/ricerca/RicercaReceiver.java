package com.speearth.model.transazioni.ricerca;

import java.io.IOException;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.HashMap;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.ServizioComponent;
import com.speearth.model.sistemi_esterni.AziendaTrasportoAdapter;
import com.speearth.model.sistemi_esterni.ImpresaRicettivaAdapter;
import com.speearth.model.sistemi_esterni.SistemaEsternoFactory;

/**
 * Receiver dei Command di ricerca
 */
public class RicercaReceiver {
	/**
	 * Unica istanza della Classe
	 */
	private static RicercaReceiver instance;

	/**
	 * Risultato del comando di Ricerca
	 */
	private ArrayList<ServizioComponent> risultato_ricerca;

	/**
	 * Restituisce la singola istanza della Classe
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
		this.risultato_ricerca = new ArrayList<ServizioComponent>();
	}

	/**
	 * Restituisce il risultato di un comando di Ricerca
	 * 
	 * @return ArrayList<IServizioComponent>
	 */
	public ArrayList<ServizioComponent> getRisultatoRicerca() {
		return this.risultato_ricerca;
	}

	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 * @throws HttpRetryException
	 */
	public ArrayList<ServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) throws IOException {
		this.svuotaRisultatiRicerca();
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = SistemaEsternoFactory.getInstance()
				.getImpreseRicettive();
		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {
			ArrayList<ServizioComponent> servizi;
			servizi = impresa_ricettiva.ricerca(parametri);
			for (ServizioComponent servizio : servizi) {
				this.risultato_ricerca.add((Alloggio) servizio);
			}
		}
		return this.risultato_ricerca;
	}

	/**
	 * Effettua una ricerca di Biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 * @throws HttpRetryException
	 */
	public ArrayList<ServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) throws IOException {
		this.svuotaRisultatiRicerca();
		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = SistemaEsternoFactory.getInstance()
				.getAziendeDiTrasporto();
		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {
			ArrayList<ServizioComponent> servizi;
			servizi = azienda_trasporto.ricerca(parametri);
			for (ServizioComponent servizio : servizi) {
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