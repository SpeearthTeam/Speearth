package Model;

public class Alloggio extends ServizioComponent {

	private string localita;
	private Date data_arrivo;
	private Date data_partenza;
	private java.util.HashMap<String, Integer> stanze;

	public Alloggio() {
		// TODO - implement Alloggio.Alloggio
		throw new UnsupportedOperationException();
	}

	public string getLocalita() {
		return this.localita;
	}

	/**
	 * 
	 * @param localita
	 */
	public void setLocalita(string localita) {
		this.localita = localita;
	}

	public Date getData_arrivo() {
		return this.data_arrivo;
	}

	/**
	 * 
	 * @param data_arrivo
	 */
	public void setData_arrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	public Date getData_partenza() {
		return this.data_partenza;
	}

	/**
	 * 
	 * @param data_partenza
	 */
	public void setData_partenza(Date data_partenza) {
		this.data_partenza = data_partenza;
	}

	public HashMap<String, Integer> getStanze() {
		// TODO - implement Alloggio.getStanze
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param stanze
	 */
	public void setStanze(HashMap<String, Integer> stanze) {
		// TODO - implement Alloggio.setStanze
		throw new UnsupportedOperationException();
	}

}