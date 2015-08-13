package model.tools;

import java.util.ArrayList;

import model.business.ServizioComponent;

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