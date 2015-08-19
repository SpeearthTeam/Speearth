package com.speearth;

import com.speearth.controller.AppFacadeController;

public class Main {
	/**
	 * Avvia l'Applicazione
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AppFacadeController.getInstance().avvia(args);
	}

}
