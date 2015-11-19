package com.speearth.controller;

import java.util.Date;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Cliente;

/**
 * Controller per il Caso d'Uso Gestisci Clienti
 */
public class GestisciClientiController implements ICasoDUsoController {
	/**
	 * Unica istanza del Controller
	 */
	private static GestisciClientiController instance;

	/**
	 * Costruttore di default
	 */
	private GestisciClientiController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 */
	public GestisciClientiController getInstance() {
		if (instance == null)
			instance = new GestisciClientiController();
		return instance;
	}

	/**
	 * Restituisce una lista di Clienti in base a un valore
	 * 
	 * @param valore
	 * @return Cliente[]
	 */
	public Cliente[] cercaCliente(String valore) {
		return AgenziaFacade.getInstance().getRegistroClienti().cercaClientiDaValore(valore);
	}

	/**
	 * Aggiunge un nuovo Cliente nel Sistema
	 * 
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return boolean
	 */
	public boolean aggiungiCliente(String nome, String cognome, Date data_nascita, String codice_fiscale) {
		return AgenziaFacade.getInstance().getRegistroClienti().aggiungiCliente(nome, cognome, data_nascita,
				codice_fiscale);
	}

	/**
	 * Modifica i dati di un Cliente
	 * 
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @return boolean
	 */
	public boolean modificaCliente(int id, String nome, String cognome, Date data_nascita, String codice_fiscale) {
		return AgenziaFacade.getInstance().getRegistroClienti().modificaCliente(id, nome, cognome, data_nascita,
				codice_fiscale);
	}

	/**
	 * Elimina un Cliente dal Sistema
	 * 
	 * @param cliente
	 * @return boolean
	 */
	public boolean eliminaCliente(Cliente cliente) {
		return AgenziaFacade.getInstance().getRegistroClienti().eliminaCliente(cliente);
	}
}
