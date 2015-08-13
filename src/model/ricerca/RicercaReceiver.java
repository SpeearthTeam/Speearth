package model.ricerca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import model.core.Alloggio;
import model.core.Biglietto;
import model.core.IServizioComponent;
import model.sistemi_esterni.AziendaTrasportoAdapter;
import model.sistemi_esterni.ImpresaRicettivaAdapter;
import model.sistemi_esterni.SistemaEsternoFactory;

/**
 * Receiver del sistema di ricerca
 */
public class RicercaReceiver {
	/**
	 * Istanza della classe
	 */
	private static RicercaReceiver instance;

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
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<IServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) {

		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = SistemaEsternoFactory.getInstance()
				.getImpreseRicettive();
		ArrayList<IServizioComponent> alloggi = new ArrayList<IServizioComponent>();

		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {

			ArrayList<IServizioComponent> servizi;
			try {
				servizi = impresa_ricettiva.ricerca(parametri);
				for (IServizioComponent servizio : servizi)
					alloggi.add((Alloggio) servizio);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return alloggi;
	}

	/**
	 * Effettua una ricerca di biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<IServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) {

		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = SistemaEsternoFactory.getInstance()
				.getAziendeDiTrasporto();
		ArrayList<IServizioComponent> biglietti = new ArrayList<IServizioComponent>();

		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {

			ArrayList<IServizioComponent> servizi;
			try {
				servizi = azienda_trasporto.ricerca(parametri);
				for (IServizioComponent servizio : servizi)
					biglietti.add((Biglietto) servizio);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return biglietti;
	}

}