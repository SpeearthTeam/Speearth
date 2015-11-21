package com.speearth.controller;

import java.util.Date;

import org.orm.PersistentException;

import com.speearth.model.core.Cliente;
import com.speearth.model.core.Impiegato;
import com.speearth.model.core.SpeearthPersistentManager;

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

	@SuppressWarnings("deprecation")
	public void generaPreCondizioni() {
		Impiegato utente = new Impiegato("Tizio", "Caio", "tiziocaio85", "vbaybzvn");
		AppFacadeController.getInstance().setUtente(utente);

		Cliente cliente1 = new Cliente(0, "Filippo", "Tirabassi", new Date(1990, 4, 7), "TRBFPP90D07G878U", 123456);
		try {
			SpeearthPersistentManager.instance().saveObject(utente);
			SpeearthPersistentManager.instance().saveObject(cliente1);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
