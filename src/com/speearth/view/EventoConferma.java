package com.speearth.view;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoConferma extends Event {
	
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 5246703093989920009L;
	
	public static EventType<EventoConferma> PRENOTAZIONE_CONFERMATA = new EventType<EventoConferma>(ANY, "PRENOTAZIONE_CONFERMATA");

	public EventoConferma(EventType<? extends Event> eventType) {
		super(eventType);
	}

}
