package model;

import java.util.ArrayList;

public class PacchettoComposite extends ServizioComponent {

	private ArrayList<ServizioComponent> servizi;

	public PacchettoComposite() {
	}

	@Override
	public float getTotale() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void aggiungi(ServizioComponent servizio) {
		this.servizi.add(servizio);
	}

	public void rimuovi(ServizioComponent servizio) {
		this.servizi.remove(servizio);
	}

	public ServizioComponent getServizio(int indice) {
		return this.servizi.get(indice);
	}

}