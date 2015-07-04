package Model;

public interface AziendaTrasportoAdapter extends SistemaEsterno {

	/**
	 * 
	 * @param parametri
	 */
	Biglietto[] ricerca(java.util.HashMap<String, String> parametri);

}