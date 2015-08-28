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
	public final String TITOLO_ERRORE = "Errore";
	public final String TITOLO_SVUOTA_PACCHETTO = "Svuota il Pacchetto";
	public final String TITOLO_PAGAMENTO_EFFETTUATO = "Pagamento effettuato";

	/**
	 * Path degli FXML
	 */
	public final String FXML_SCEGLI_SERVIZIO = "/ui/fxml/ScegliServizio.fxml";
	public final String FXML_RICERCA_BIGLIETTO = "/ui/fxml/RicercaBiglietto.fxml";
	public final String FXML_RICERCA_ALLOGGIO = "/ui/fxml/RicercaAlloggio.fxml";
	public final String FXML_RICERCA_PACCHETTO = "/ui/fxml/RicercaPacchetto.fxml";
	public final String FXML_RISULTATO_BIGLIETTO = "/ui/fxml/RisultatoBiglietto.fxml";
	public final String FXML_RISULTATO_ALLOGGIO = "/ui/fxml/RisultatoAlloggio.fxml";
	public final String FXML_RIEPILOGO = "/ui/fxml/Riepilogo.fxml";

	/**
	 * Messaggi popup
	 */
	public final String MESSAGGIO_PARAMETRI_MANCANTI = "Mancano alcuni parametri di ricerca.";
	public final String MESSAGGIO_SVUOTA_PACCHETTO = "Vuoi davvero rimuovere tutti i Servizi scelti dal Pacchetto?";
	public final String MESSAGGIO_CLIENTE_NON_TROVATO = "Non � stato trovato alcun Cliente con questo codice Tessera.";
	public final String MESSAGGIO_PAGAMENTO_EFFETTUATO = "Il Pagamento � andato a buon fine!";

	/**
	 * URL dei Sistemi Esterni
	 */
	public final String URL_TRENITALIA = "";
	public final String URL_ITALO = "";
	public final String URL_BOOKING = "";
}
