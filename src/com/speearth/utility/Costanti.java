package com.speearth.utility;

import com.speearth.model.sistemi_esterni.AziendaTrasportoAdapter;
import com.speearth.model.sistemi_esterni.BookingAdapter;
import com.speearth.model.sistemi_esterni.ImpresaRicettivaAdapter;
import com.speearth.model.sistemi_esterni.ItaloAdapter;
import com.speearth.model.sistemi_esterni.TrenitaliaAdapter;

public final class Costanti {

	/**
	 * Titoli delle Schermate
	 */
	public final static String TITOLO_HOME = "Speearth";
	public final static String TITOLO_SCEGLI_SERVIZIO = "Scegli Servizio - Speearth";
	public final static String TITOLO_PRENOTA_BIGLIETTO = "Prenota Biglietto - Speearth";
	public final static String TITOLO_PRENOTA_ALLOGGIO = "Prenota Alloggio - Speearth";
	public final static String TITOLO_PRENOTA_PACCHETTO = "Prenota Pacchetto - Speearth";
	public final static String TITOLO_RIEPILOGO = "Riepilogo Prenotazione - Speearth";
	public final static String TITOLO_ERRORE = "Errore";
	public final static String TITOLO_SVUOTA_PACCHETTO = "Svuota il Pacchetto";
	public final static String TITOLO_PAGAMENTO_EFFETTUATO = "Pagamento effettuato";
	public final static String TITOLO_TORNA_A_SCEGLI_SERVIZIO = "Torna alla Scelta del Servizio";
	public final static String TITOLO_NESSUN_SERVIZIO = "Nessun Servizio prenotato.";

	/**
	 * Path degli FXML
	 */
	public final static String FXML_SCEGLI_SERVIZIO = "/ui/fxml/ScegliServizio.fxml";
	public final static String FXML_RICERCA_BIGLIETTO = "/ui/fxml/RicercaBiglietto.fxml";
	public final static String FXML_RICERCA_ALLOGGIO = "/ui/fxml/RicercaAlloggio.fxml";
	public final static String FXML_RICERCA_PACCHETTO = "/ui/fxml/RicercaPacchetto.fxml";
	public final static String FXML_RISULTATO_BIGLIETTO = "/ui/fxml/RisultatoBiglietto.fxml";
	public final static String FXML_RISULTATO_ALLOGGIO = "/ui/fxml/RisultatoAlloggio.fxml";
	public final static String FXML_RIEPILOGO_BIGLIETTO = "/ui/fxml/RiepilogoBiglietto.fxml";
	public final static String FXML_RIEPILOGO_ALLOGGIO = "/ui/fxml/RiepilogoAlloggio.fxml";
	public final static String FXML_RIEPILOGO_PACCHETTO = "/ui/fxml/RiepilogoPacchetto.fxml";

	/**
	 * Messaggi dei Dialog
	 */
	public final static String MESSAGGIO_PARAMETRI_MANCANTI = "Mancano alcuni parametri di ricerca.";
	public final static String MESSAGGIO_SVUOTA_PACCHETTO = "Vuoi davvero rimuovere tutti i Servizi scelti dal Pacchetto?";
	public final static String MESSAGGIO_CLIENTE_NON_TROVATO = "Non è stato trovato alcun Cliente con questo codice Tessera.";
	public final static String MESSAGGIO_PAGAMENTO_EFFETTUATO = "Il Pagamento è andato a buon fine!";
	public final static String MESSAGGIO_TORNA_A_SCELTA_SERVIZIO = "La tua prenotazione verrà cancellata. Vuoi procedere?";
	public final static String MESSAGGIO_NESSUN_SERVIZIO = "Non è stato scelto nessun Servizio.";

	/**
	 * Sistemi Esterni: Aziende di Trasporto
	 */
	public final static AziendaTrasportoAdapter[] SISTEMI_ESTERNI_AZIENDE_TRASPORTO = {
			ItaloAdapter.getInstance(),
			TrenitaliaAdapter.getInstance()
	};
	
	/**
	 * Sistemi Esterni: Imprese Ricettive
	 */
	public final static ImpresaRicettivaAdapter[] SISTEMI_ESTERNI_IMPRESE_RICETTIVE = {
			BookingAdapter.getInstance()
	};
	
	/**
	 * URL dei Sistemi Esterni
	 */
	public final static String URL_TRENITALIA = "http://h4ck1n6.altervista.org/";
	public final static String URL_ITALO = "http://h4ck1n6.altervista.org/";
	public final static String URL_BOOKING = "http://h4ck1n6.altervista.org/";
}
