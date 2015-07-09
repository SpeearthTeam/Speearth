package model;

/**
 * Classe che rappresenta un Bonus applicabile a un Servizio
 */
public abstract class Bonus {
	private ServizioComponent servizio;

	public ServizioComponent getServizio() {
		return servizio;
	}

	public void setServizio(ServizioComponent servizio) {
		this.servizio = servizio;
	}
}