package com.speearth.utility;

public class Costanti {
	/**
	 * Istanza della classe
	 */
	private static Costanti instance;
	
	/**
	 * Costruttore di default
	 */
	private Costanti() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return Costanti
	 */
	public static Costanti getInstance() {
		if (instance == null)
			instance = new Costanti();
		return instance;
	}

	/**
	 * Titoli delle Schermate
	 */
	public final String TITOLO_HOME = "Speearth";
	public final String TITOLO_SCEGLI_SERVIZIO = "Scegli Servizio - Speearth";
	public final String TITOLO_PRENOTA_BIGLIETTO = "Prenota Biglietto - Speearth";
	public final String TITOLO_PRENOTA_ALLOGGIO = "Prenota Alloggio - Speearth";
	public final String TITOLO_PRENOTA_PACCHETTO = "Prenota Pacchetto - Speearth";
	public final String TITOLO_RIEPILOGO = "Riepilogo Prenotazione - Speearth";

	/**
	 * Path degli FXML
	 */
	public final String FXML_SCEGLI_SERVIZIO = "/ui/fxml/ScegliServizio.fxml";
	public final String FXML_RICERCA_BIGLIETTO = "/ui/fxml/RicercaBiglietto.fxml";
	public final String FXML_RICERCA_ALLOGGIO = "/ui/fxml/RicercaAlloggio.fxml";
	public final String FXML_RICERCA_PACCHETTO = "/ui/fxml/RicercaPacchetto.fxml";
	public final String FXML_RISULTATO_BIGLIETTO = "/ui/fxml/RisultatoBiglietto.fxml";
	public final String FXML_RISULTATO_ALLOGGIO = "/ui/fxml/RisultatoBiglietto.fxml";
	public final String FXML_RIEPILOGO = "/ui/fxml/Riepilogo.fxml";

	/**
	 * URL dei Sistemi Esterni
	 */
	public final String URL_TRENITALIA = "";
	public final String URL_ITALO = "";
	public final String URL_BOOKING = "";
}
