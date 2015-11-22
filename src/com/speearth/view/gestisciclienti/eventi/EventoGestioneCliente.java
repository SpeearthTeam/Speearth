package com.speearth.view.gestisciclienti.eventi;

import com.speearth.model.core.Cliente;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoGestioneCliente extends Event {

	/**
	 * Long serial version UID 
	 */
	private static final long serialVersionUID = 7669073866088315641L;
	
	public static EventType<EventoGestioneCliente> ELIMINA_CLIENTE = new EventType<EventoGestioneCliente>("ELIMINA_CLIENTE");
	public static EventType<EventoGestioneCliente> MODIFICA_CLIENTE = new EventType<EventoGestioneCliente>("MODIFICA_CLIENTE");
	
	/**
	 * Cliente associato all'evento
	 */
	private Cliente cliente;

	/**
	 * Costruttore di default
	 * 
	 * @param eventType
	 * @param cliente
	 */
	public EventoGestioneCliente(EventType<? extends Event> eventType, Cliente cliente) {
		super(eventType);
		this.cliente = cliente;
	}
	
	/**
	 * Restituisce il cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
}
