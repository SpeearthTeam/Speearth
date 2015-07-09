package model;

import java.util.ArrayList;

/**
 * Interfaccia rappresentante un generico comando verso un Sistema Esterno
 */
@SuppressWarnings("hiding")
public interface SistemaEsternoCommand<ServizioComponent> {
	/**
	 * Fa eseguire il Comando
	 * 
	 * @return ArrayList<ServizioComponent>
	 */
	public ArrayList<ServizioComponent> esegui();

}