package com.speearth.controller;

import java.util.ArrayList;
import java.util.Date;

import com.speearth.model.core.AgenziaFacade;
import com.speearth.model.core.Impiegato;

/**
 * Controller per il Caso d'Uso Gestisci Impiegati
 */
public class GestisciImpiegatiController implements ICasoDUsoController {
	/**
	 * Unica istanza del Controller
	 */
	private static GestisciImpiegatiController instance;

	/**
	 * Costruttore di default
	 */
	private GestisciImpiegatiController() {
	}

	/**
	 * Restituisce l'istanza del Controller
	 * 
	 * @return GestisciImpiegatiController
	 */
	public static GestisciImpiegatiController getInstance() {
		if (instance == null)
			instance = new GestisciImpiegatiController();
		return instance;
	}

	/**
	 * Restituisce un Impiegato dal suo username
	 * 
	 * @param username
	 * @return ArrayList<Impiegato>
	 */
	public Impiegato cercaImpiegatoDaUsername(String username) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().cercaImpiegatoDaUsername(username);
	}

	/**
	 * Restituisce una lista di Impiegati in base a un valore
	 * 
	 * @param valore
	 * @return ArrayList<Impiegato>
	 */
	public ArrayList<Impiegato> cercaImpiegato(String valore) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().cercaImpiegatiDaValore(valore);
	}

	/**
	 * Aggiunge un nuovo Impiegato nel Sistema
	 * 
	 * @param username
	 * @param password
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param ruolo
	 * @param stipendio
	 * @return Impiegato
	 */
	public Impiegato aggiungiImpiegato(String username, String password, String nome, String cognome, Date data_nascita,
			String codice_fiscale, String ruolo, float stipendio) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().aggiungiImpiegato(username, password, nome, cognome,
				data_nascita, codice_fiscale, ruolo, stipendio);
	}

	/**
	 * Modifica i dati di un Impiegato gi� registrato nel Sistema
	 * 
	 * @param username
	 * @param password
	 * @param nome
	 * @param cognome
	 * @param data_nascita
	 * @param codice_fiscale
	 * @param ruolo
	 * @param stipendio
	 * @return Impiegato
	 */
	public Impiegato modificaImpiegato(String username, String password, String nome, String cognome, Date data_nascita,
			String codice_fiscale, String ruolo, float stipendio) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().modificaImpiegato(username, password, nome, cognome,
				data_nascita, codice_fiscale, ruolo, stipendio);
	}

	/**
	 * Elimina un Impiegato dal Sistema
	 * 
	 * @param impiegato
	 * @return boolean
	 */
	public boolean eliminaImpiegato(Impiegato impiegato) {
		return AgenziaFacade.getInstance().getRegistroImpiegati().eliminaImpiegato(impiegato);
	}
}