package Model;

public interface SistemaEsternoCommand {

	/**
	 * 
	 * @param parametri
	 */
	Servizio[] esegui(HashMap<String, String> parametri);

}