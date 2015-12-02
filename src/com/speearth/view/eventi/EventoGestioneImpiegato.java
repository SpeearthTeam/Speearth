package com.speearth.view.eventi;

import com.speearth.model.core.Impiegato;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoGestioneImpiegato extends Event {

	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 7669073866088315641L;

	public static EventType<EventoGestioneImpiegato> ELIMINA_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"ELIMINA_IMPIEGATO");
	public static EventType<EventoGestioneImpiegato> MODIFICA_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"MODIFICA_IMPIEGATO");
	public static EventType<EventoGestioneImpiegato> AGGIUNGI_IMPIEGATO = new EventType<EventoGestioneImpiegato>(
			"SALVA_IMPIEGATO");

	/**
	 * Impiegato associato all'evento
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore di default
	 * 
	 * @param eventType
	 * @param impiegato
	 */
	public EventoGestioneImpiegato(EventType<? extends Event> eventType, Impiegato impiegato) {
		super(eventType);
		this.impiegato = impiegato;
	}

	/**
	 * Restituisce il impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}
}
