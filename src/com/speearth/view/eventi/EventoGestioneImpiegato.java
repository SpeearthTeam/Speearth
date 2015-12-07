package com.speearth.view.eventi;

import com.speearth.model.core.Impiegato;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Classe per gestire l'Evento di selezione di un Impiegato da una Lista
 */
public class EventoGestioneImpiegato extends Event {
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 7669073866088315641L;

	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneImpiegato> ELIMINA_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"ELIMINA_IMPIEGATO");
	
	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneImpiegato> MODIFICA_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"MODIFICA_IMPIEGATO");
	
	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneImpiegato> AGGIUNGI_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"SALVA_IMPIEGATO");

	/**
	 * Impiegato associato all'Evento
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore
	 * 
	 * @param eventType
	 * @param impiegato
	 */
	public EventoGestioneImpiegato(EventType<? extends Event> eventType, Impiegato impiegato) {
		super(eventType);
		this.impiegato = impiegato;
	}

	/**
	 * Restituisce l'Impiegato
	 */
	public Impiegato getImpiegato() {
		return this.impiegato;
	}
}
