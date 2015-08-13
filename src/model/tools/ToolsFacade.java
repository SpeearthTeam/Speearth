package model.tools;

import java.util.ArrayList;

public class ToolsFacade {
	/**
	 * Istanza della classe
	 */
	private static ToolsFacade instance;

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return ToolsFacade
	 */
	public static ToolsFacade getInstance() {
		if (instance == null)
			instance = new ToolsFacade();
		return instance;
	}

	/**
	 * Restituisce il Receiver per le operazioni di ricerca verso Sistemi
	 * Esterni
	 * 
	 * @return RicercaReceiver
	 */
	public RicercaReceiver getRicercaRiceiver() {
		return RicercaReceiver.getInstance();
	}

	/**
	 * Restituisce le Aziende di Trasporto su un preciso Mezzo
	 * 
	 * @param mezzo
	 * @return ArrayList<AziendaTrasportoAdapter>
	 */
	public ArrayList<AziendaTrasportoAdapter> getAziendePerMezzo(String mezzo) {
		return null;
	}

	/**
	 * Restituisce le Imprese Ricettive di una precisa tipologia
	 * 
	 * @param tipologia
	 * @return ArrayList<ImpresaRicettivaAdapter>
	 */
	public ArrayList<ImpresaRicettivaAdapter> getImpresePerTipologia(String tipologia) {
		return null;
	}

}
