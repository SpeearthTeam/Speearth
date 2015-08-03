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
	 * Restituisce tutti i Sistemi Esterni supportati dal Software
	 * 
	 * @return ArrayList<SistemaEsterno>
	 */
	public ArrayList<SistemaEsterno> getSistemiEsterni() {
		ArrayList<SistemaEsterno> sistemi_esterni = new ArrayList<SistemaEsterno>();
		
		sistemi_esterni.addAll(this.getAziendeDiTrasporto());
		sistemi_esterni.addAll(this.getImpreseRicettive());
		
		return sistemi_esterni;
	}
	
	/**
	 * Restituisce le Aziende di Trasporto supportate dal Software
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
	 * Restituisce le Imprese Ricettive supportate dal Software
	 * 
	 * @return ArrayList<ImpresaRicettivaAdapter>
	 */
	public ArrayList<ImpresaRicettivaAdapter> getImpreseRicettive() {
		ArrayList<ImpresaRicettivaAdapter> imprese_ricettive = new ArrayList<ImpresaRicettivaAdapter>();
		
		imprese_ricettive.add(BookingAdapter.getInstance());
		
		return imprese_ricettive;
	}

}
