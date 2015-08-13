package model.tools;

import java.util.ArrayList;

import model.business.Bonus;
import model.business.ScontoBonus;
import model.business.ServizioComponent;
import model.business.Vendita;

/**
 * Strategy per il bonus sconto
 */
public class ScontoConcreteStrategy implements BonusStrategy {
	/**
	 * Metodo costruttore
	 */
	public ScontoConcreteStrategy() {
	}

	/**
	 * Calcola il bonus in base alle vendite e al loro ammontare
	 * 
	 * @param vendite
	 * @return ScontoBonus
	 */
	public ScontoBonus calcola(ArrayList<Vendita> vendite) {
		int sconto = 0;
		float ammontare = 0;

		int br6 = 0, br5 = 0, br4 = 0, br3 = 0;

		for (Vendita vendita : vendite) {
			ammontare = vendita.getPagamento().getAmmontare();

			if (ammontare > 500)
				br6++;

			if (ammontare > 100) {
				br3++;
				br4++;
				br5++;
			}
		}

		if (br3 > 2 || br6 > 2)
			sconto = 10;
		if (br4 > 4)
			sconto = 20;
		if (br5 > 5)
			sconto = 30;

		if (sconto > 0) {
			ScontoBonus bonus = new ScontoBonus();
			bonus.setSconto(sconto);
			return bonus;
		}

		return null;
	}

	/**
	 * Applica il Bonus al Servizio di un cliente
	 * 
	 * @param servizio
	 * @param bonus
	 */
	public void applica(ServizioComponent servizio, Bonus bonus) {
		int sconto = ((ScontoBonus) bonus).getSconto();
		float totale = servizio.getPrezzo();
		servizio.setPrezzo(totale - (totale * sconto) / 100);
	}

}