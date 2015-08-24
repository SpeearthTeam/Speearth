package com.speearth.view;

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
