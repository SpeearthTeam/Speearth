package com.speearth.view.prenotaservizio.eventi;

import com.speearth.model.core.IServizioComponent;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoSelezionaServizio extends Event {
	
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 4809030381877023863L;
	
	public static EventType<EventoSelezionaServizio> SERVIZIO_SELEZIONATO = new EventType<EventoSelezionaServizio>("SERVIZIO_SELEZIONATO");
	
	private IServizioComponent servizio;

	/**
	 * Costruttore di default
	 * 
	 * @param eventType
	 * @param servizio
	 */
	public EventoSelezionaServizio(EventType<? extends Event> eventType, IServizioComponent servizio) {
		super(eventType);
		this.servizio = servizio;
	}
	
	/**
	 * Restituisce il servizio
	 */
	public IServizioComponent getServizio() {
		return this.servizio;
	}

}