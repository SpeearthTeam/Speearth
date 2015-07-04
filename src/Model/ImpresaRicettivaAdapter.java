package Model;

public interface ImpresaRicettivaAdapter extends SistemaEsterno {

	/**
	 * 
	 * @param parametri
	 */
	Alloggio[] ricerca(HashMap<String, String> parametri);

}