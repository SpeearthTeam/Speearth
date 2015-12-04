package com.speearth.view.eventi;

import com.speearth.model.core.Offerta;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoSelezionaOfferta extends Event {

	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 4809030381877023863L;

	public static EventType<EventoSelezionaOfferta> OFFERTA_SELEZIONATA = new EventType<EventoSelezionaOfferta>(
			"OFFERTA_SELEZIONATA");

	private Offerta offerta;

	/**
	 * Costruttore di default
	 * 
	 * @param eventType
	 * @param offerta
	 */
	public EventoSelezionaOfferta(EventType<? extends Event> eventType, Offerta offerta) {
		super(eventType);
		this.offerta = offerta;
	}

	/**
	 * Restituisce il servizio
	 */
	public Offerta getOfferta() {
		return this.offerta;
	}

}
