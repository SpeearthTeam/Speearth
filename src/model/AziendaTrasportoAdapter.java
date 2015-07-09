package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interfaccia rappresentante un'Azienda di Trasporto che fornisce Biglietti per
 * l'Agenzia
 */
public interface AziendaTrasportoAdapter extends SistemaEsterno<Biglietto> {
	/**
	 * Effettua una ricerca di Servizi offerti dall'Azienda di trasporto secondo
	 * i parametri
	 * 
	 * @param parametri
	 * @return ArrayList<Biglietto>
	 */
	@Override
	public ArrayList<Biglietto> ricerca(HashMap<String, String> parametri);

}