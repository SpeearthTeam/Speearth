package model;

import java.util.ArrayList;

/**
 * Factory dei sistemi esterni
 */
public class SistemaEsternoFactory {
	
	/**
	 * Instanza della classe
	 */
	private static SistemaEsternoFactory instance;
	
	/**
	 * Restituisce la singola instanza della classe
	 * 
	 * @return SistemaEsternoFactory
	 */
	public static SistemaEsternoFactory getInstance() {
		if (instance == null)
			instance = new SistemaEsternoFactory();
		return instance;
	}
	
	/**
	 * Costruttore di default
	 */
	protected SistemaEsternoFactory() {
	}
	
	/**
	 * Restituisce tutti i sistemi esterni
	 * 
	 * @return ArrayList<SistemaEsterno>
	 */
	public ArrayList<SistemaEsterno> getSistemiEsterni() {
		ArrayList<SistemaEsterno> sistemi_esterni = new ArrayList<SistemaEsterno>();
		
		sistemi_esterni.add(TrenitaliaAdapter.getInstance());
		sistemi_esterni.add(ItaloAdapter.getInstance());
		
		return sistemi_esterni;
	}
	
	/**
	 * Restituisce le aziende di trasporto
	 * 
	 * @return ArrayList<AziendaTrasportoAdapter>
	 */
	public ArrayList<AziendaTrasportoAdapter> getAziendeDiTrasporto() {
		ArrayList<AziendaTrasportoAdapter> aziende_trasporto = new ArrayList<AziendaTrasportoAdapter>();
		
		aziende_trasporto.add(TrenitaliaAdapter.getInstance());
		aziende_trasporto.add(ItaloAdapter.getInstance());
		
		return aziende_trasporto;
	}
	
	/**
	 * Restituisce le imprese ricettive
	 * 
	 * @return ArrayList<ImpresaRicettivaAdapter>
	 */
	public ArrayList<ImpresaRicettivaAdapter> getImpreseRicettive() {
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = new ArrayList<ImpresaRicettivaAdapter>();
		return imprese_ricettive;
	}

}
