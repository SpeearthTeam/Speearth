package model.ricerca;

import java.util.ArrayList;

import model.core.IServizioComponent;

/**
 * Interfaccia rappresentante un generico comando di ricerca
 */
public interface IRicercaCommand {
	/**
	 * Fa eseguire il comando al receiver
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<IServizioComponent> esegui();

}