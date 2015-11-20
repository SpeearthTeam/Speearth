package com.speearth.controller;

/**
 * Controller di utilità per il Caso d'Uso di Startup
 */
public class StartupController implements ICasoDUsoController {
	private static StartupController instance;
	
	private StartupController() {
	}
	
	public static StartupController getInstance() {
		if (instance == null)
			instance = new StartupController();
		return instance;
	}
	
	public void generaPreCondizioni() {
		
	}
}
