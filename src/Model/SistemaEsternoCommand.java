package Model;

import java.util.HashMap;

public interface SistemaEsternoCommand {

	/**
	 * 
	 * @param parametri
	 */
	ServizioComponent[] esegui(HashMap<String, String> parametri);

}