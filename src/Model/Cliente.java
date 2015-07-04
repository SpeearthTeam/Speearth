package Model;

public class Cliente {

	private int id;
	private String nome;
	private int codice_tessera;

	public Cliente() {
		// TODO - implement Cliente.Cliente
		throw new UnsupportedOperationException();
	}

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

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodice_tessera() {
		return this.codice_tessera;
	}

	/**
	 * 
	 * @param codice_tessera
	 */
	public void setCodice_tessera(int codice_tessera) {
		this.codice_tessera = codice_tessera;
	}

}