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
			Impiegato imp1 = RegistroImpiegati.getInstance().cercaImpiegatoDaUsername("tiziocaio85");
			Impiegato imp2 = RegistroImpiegati.getInstance().cercaImpiegatoDaUsername("dariolampa220");
			Impiegato imp3 = RegistroImpiegati.getInstance().cercaImpiegatoDaUsername("richardbenson666");
			if (imp1 == null) {
				Date d1 = null;
				try {
					d1 = Costanti.FORMATO_DATA.parse("30-07-1985");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				imp1 = new Impiegato("tiziocaio85", "vbaybzvn", "Tizio", "Caio", d1, "TZC123TZC123", "Commesso",
						(float) 1234.50);
				SpeearthPersistentManager.instance().saveObject(imp1);
			}
			if (imp2 == null) {
				Date d2 = null;
				try {
					d2 = Costanti.FORMATO_DATA.parse("01-01-1960");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				imp2 = new Impiegato("dariolampa220", "blablabla", "Dario", "Lampa", d2, "MLLMNDMMNS456",
						"Responsabile Offerte", (float) 1234.50);
				SpeearthPersistentManager.instance().saveObject(imp2);
			}
			if (imp3 == null) {
				Date d3 = null;
				try {
					d3 = Costanti.FORMATO_DATA.parse("10-03-1955");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				imp3 = new Impiegato("richardbenson666", "unpolloh", "Richard", "Benson", d3, "TDVSPVNTR33333",
						"Direttore", (float) 6666.66);
				SpeearthPersistentManager.instance().saveObject(imp3);
			}
			AppFacadeController.getInstance().setUtente(imp3);

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
