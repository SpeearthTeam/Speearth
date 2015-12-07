package com.speearth.view.eventi;

import com.speearth.model.core.Offerta;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Classe per gestire l'Evento di selezione di un'Offerta da una Lista
 */
public class EventoSelezionaOfferta extends Event {
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 4809030381877023863L;

	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoSelezionaOfferta> OFFERTA_SELEZIONATA = new EventType<EventoSelezionaOfferta>(
			"OFFERTA_SELEZIONATA");

	/**
	 * Offerta selezionata
	 */
	private Offerta offerta;

	/**
	 * Costruttore
	 * 
	 * @param eventType
	 * @param offerta
	 */
	public EventoSelezionaOfferta(EventType<? extends Event> eventType, Offerta offerta) {
		super(eventType);
		this.offerta = offerta;
	}

	/**
	 * Restituisce l'Offerta selezionata
	 */
	public Offerta getOfferta() {
		return this.offerta;
	}
}
