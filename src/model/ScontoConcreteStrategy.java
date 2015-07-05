package model;

import java.util.ArrayList;

/**
 * Strategy per il bonus sconto
 */
public class ScontoConcreteStrategy implements BonusStrategy {

	/**
	 * Registro delle vendite
	 */
	private RegistroVendite registro_vendite;
	
	/**
	 * Metodo costruttore
	 */
	public ScontoConcreteStrategy() {
		this.registro_vendite = RegistroVendite.getInstance();
	}

	@Override
	public ArrayList<Bonus> calcola(Cliente cliente) {
		ArrayList<Bonus> lista_bonus = new ArrayList<Bonus>();
		ArrayList<Vendita> vendite = this.registro_vendite.getVendite(cliente);
		
		Bonus bonus = this.calcolaBonusDalleVendite(vendite);
		
		if (bonus != null)
			lista_bonus.add(bonus);

		return lista_bonus;
	}

	@Override
	public void applica(ServizioComponent servizio, Bonus bonus) {
		int sconto = ((ScontoBonus) bonus).getSconto();
		
		float totale = servizio.getPrezzo() * sconto / 100;
		
		servizio.setTotale(totale);
	}
	
	/**
	 * Calcola il bonus in base alle vendite e al loro ammontare
	 * @param vendite
	 * @return ScontoBonus
	 */
	private ScontoBonus calcolaBonusDalleVendite(ArrayList<Vendita> vendite) {
		ScontoBonus bonus = null;
		int sconto = 0;
		float ammontare = 0;
		
		int br6 = 0,
			br5 = 0,
			br4 = 0,
			br3 = 0;

		for (Vendita vendita : vendite)
		{
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
			bonus = new ScontoBonus();
			bonus.setSconto(sconto);
		}
		
		return bonus;
	}

}