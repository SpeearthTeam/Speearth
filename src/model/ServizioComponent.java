package model;

public abstract class ServizioComponent {

	private int id;
	private String fornitore;
	private float prezzo;

	public ServizioComponent() {
		// TODO - implement ServizioComponent.ServizioComponent
		throw new UnsupportedOperationException();
	}

	public abstract float getTotale();

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getFornitore() {
		return this.fornitore;
	}

	/**
	 * 
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}