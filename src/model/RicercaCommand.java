package model;

import java.util.ArrayList;

/**
 * Interfaccia rappresentante un generico comando di ricerca
 */
public interface RicercaCommand {
	/**
	 * Fa eseguire il comando al receiver
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> esegui();

}