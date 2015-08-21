package com.speearth;

import com.speearth.controller.AppFacadeController;

public class Main {
	/**
	 * Avvia l'Applicazione
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AppFacadeController.getInstance().avvia(args);
	}

}
