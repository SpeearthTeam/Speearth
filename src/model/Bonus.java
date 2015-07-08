package model;

public abstract class Bonus {
	private ServizioComponent servizio;

	public ServizioComponent getServizio() {
		return servizio;
	}

	public void setServizio(ServizioComponent servizio) {
		this.servizio = servizio;
	}
}