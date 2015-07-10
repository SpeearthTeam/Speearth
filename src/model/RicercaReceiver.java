package model;

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
	 * Factory dei sistemi esterni
	 */
	private SistemaEsternoFactory sistema_esterno_factory;
	
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
	protected RicercaReceiver() {
		this.sistema_esterno_factory = SistemaEsternoFactory.getInstance();
	}
	
	/**
	 * Effettua una ricerca di Alloggi secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Alloggio>
	 */
	public ArrayList<Alloggio> ricercaAlloggi(HashMap<String, String> parametri) {
		
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = this.sistema_esterno_factory.getImpreseRicettive();
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();
		
		for (ImpresaRicettivaAdapter impresa_ricettiva : imprese_ricettive) {
			
			ArrayList<ServizioComponent> servizi = impresa_ricettiva.ricerca(parametri);
			for (ServizioComponent servizio : servizi)
				alloggi.add((Alloggio) servizio);
		}
		
		return alloggi;
	}

	/**
	 * Effettua una ricerca di biglietti secondo i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	public ArrayList<Biglietto> ricercaBiglietti(HashMap<String, String> parametri) {
		
		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = this.sistema_esterno_factory.getAziendeDiTrasporto();
		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
		
		for (AziendaTrasportoAdapter azienda_trasporto : aziende_trasporto) {
			
			ArrayList<ServizioComponent> servizi = azienda_trasporto.ricerca(parametri);
			for (ServizioComponent servizio : servizi)
				biglietti.add((Biglietto) servizio);
		}
		
		return biglietti;
	}

}