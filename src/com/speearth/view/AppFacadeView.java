package com.speearth.view;

/**
 * Classe di accesso alle funzionalità del layer View
 */
public class AppFacadeView {
	/**
	 * Unica instanza della facade
	 */
	private static AppFacadeView instance;
	
	/**
	 * Costruttore di default
	 */
	private AppFacadeView() {
	}
	
	/**
	 * Restituisce l'instanza della facade
	 */
	public static AppFacadeView getInstance() {
		if (instance == null)
			instance = new AppFacadeView();
		return instance;
	}

}
