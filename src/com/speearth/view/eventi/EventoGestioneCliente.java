package com.speearth.view.eventi;

import com.speearth.model.core.Cliente;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Classe per gestire l'Evento di selezione di un Cliente da una Lista
 */
public class EventoGestioneCliente extends Event {
	/**
	 * Long serial version UID
	 */
	private static final long serialVersionUID = 7669073866088315641L;

	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneCliente> ELIMINA_CLIENTE = new EventType<EventoGestioneCliente>(
			"ELIMINA_CLIENTE");
	
	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneCliente> MODIFICA_CLIENTE = new EventType<EventoGestioneCliente>(
			"MODIFICA_CLIENTE");
	
	/**
	 * Tipo di Evento
	 */
	public static EventType<EventoGestioneCliente> AGGIUNGI_CLIENTE = new EventType<EventoGestioneCliente>(
			"SALVA_CLIENTE");

	/**
	 * Cliente associato all'Evento
	 */
	private Cliente cliente;

	/**
	 * Costruttore
	 * 
	 * @param eventType
	 * @param cliente
	 */
	public EventoGestioneCliente(EventType<? extends Event> eventType, Cliente cliente) {
		super(eventType);
		this.cliente = cliente;
	}

	/**
	 * Restituisce il Cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}
}
