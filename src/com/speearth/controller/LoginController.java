package com.speearth.controller;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Impiegato;

public class LoginController implements ICasoDUsoController {
	/**
	 * Unica istanza del Controller
	 */
	private static LoginController instance;

	/**
	 * Costruttore di default
	 */
	private LoginController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 */
	public static LoginController getInstance() {
		if (instance == null)
			instance = new LoginController();
		return instance;
	}

	/**
	 * Effettua l'autenticazione di un Utente verso il Sistema
	 * 
	 * @return boolean
	 */
	public Impiegato login(String username, String password) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().autentica(username, password);
	}

	/**
	 * Effettua la disconnessione dell'Utente dal Sistema
	 */
	public void logout() {
		AppFacadeController.getInstance().setUtente(null);
	}
}
