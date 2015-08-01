package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<ServizioComponent> ricercaAlloggi(HashMap<String, String> parametri) {

		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = SistemaEsternoFactory.getInstance()
				.getImpreseRicettive();
		ArrayList<ServizioComponent> alloggi = new ArrayList<ServizioComponent>();

		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {

			ArrayList<ServizioComponent> servizi;
			try {
				servizi = impresa_ricettiva.ricerca(parametri);
				for (ServizioComponent servizio : servizi)
					alloggi.add((Alloggio) servizio);
			} catch (IOException e) {
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
	public ArrayList<ServizioComponent> ricercaBiglietti(HashMap<String, String> parametri) {

		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = SistemaEsternoFactory.getInstance()
				.getAziendeDiTrasporto();
		ArrayList<ServizioComponent> biglietti = new ArrayList<ServizioComponent>();

		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {

			ArrayList<ServizioComponent> servizi;
			try {
				servizi = azienda_trasporto.ricerca(parametri);
				for (ServizioComponent servizio : servizi)
					biglietti.add((Biglietto) servizio);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return biglietti;
	}

}