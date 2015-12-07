package com.speearth.view.eventi;

import com.speearth.model.core.ServizioComponent;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Classe per gestire l'Evento di selezione di un Servizio da una Lista
 */
public class EventoSelezionaServizio extends Event {
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 4809030381877023863L;

	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoSelezionaServizio> SERVIZIO_SELEZIONATO = new EventType<EventoSelezionaServizio>(
			"SERVIZIO_SELEZIONATO");

	/**
	 * Servizio selezionato
	 */
	private ServizioComponent servizio;

	/**
	 * Costruttore
	 * 
	 * @param eventType
	 * @param servizio
	 */
	public EventoSelezionaServizio(EventType<? extends Event> eventType, ServizioComponent servizio) {
		super(eventType);
		this.servizio = servizio;
	}

	/**
	 * Restituisce il Servizio selezionato
	 */
	public ServizioComponent getServizio() {
		return this.servizio;
	}
}
