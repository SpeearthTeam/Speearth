package com.speearth.controller;

import java.text.ParseException;
import java.util.Date;

import org.orm.PersistentException;

import com.speearth.model.core.Cliente;
import com.speearth.model.core.Impiegato;
import com.speearth.model.core.RegistroClienti;
import com.speearth.model.core.RegistroImpiegati;
import com.speearth.model.core.SpeearthPersistentManager;
import com.speearth.utility.Costanti;

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
		try {
			Impiegato imp = RegistroImpiegati.getInstance().cercaImpiegatoDaUsername("tiziocaio85");
			if (imp == null) {
				Date d = null;
				try {
					d = Costanti.FORMATO_DATA.parse("30-07-1985");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				imp = new Impiegato("tiziocaio85", "vbaybzvn", "Tizio", "Caio", d, "TZC123TZC123", "Commesso",
						(float) 1234.50);
				SpeearthPersistentManager.instance().saveObject(imp);
			}
			AppFacadeController.getInstance().setUtente(imp);

			Cliente cl = RegistroClienti.getInstance().cercaClienteDaCodiceTessera("123456");
			if (cl == null) {
				Date d = null;
				try {
					d = Costanti.FORMATO_DATA.parse("07-04-1990");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cl = new Cliente("Filippo", "Tirabassi", d, "TRBFPP90D07G878U", "123456");
				SpeearthPersistentManager.instance().saveObject(cl);
			}

		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
