package com.speearth.utility;

import java.text.SimpleDateFormat;

import com.speearth.model.sistemi_esterni.AziendaTrasportoAdapter;
import com.speearth.model.sistemi_esterni.BookingAdapter;
import com.speearth.model.sistemi_esterni.ImpresaRicettivaAdapter;
import com.speearth.model.sistemi_esterni.ItaloAdapter;
import com.speearth.model.sistemi_esterni.TrenitaliaAdapter;

public final class Costanti {

	/**
	 * Formato della Data con orario
	 */
	public final static SimpleDateFormat FORMATO_DATA_ORA = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public final static SimpleDateFormat FORMATO_DATA_ORA_STANDARD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Formato della Data
	 */
	public final static SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd-MM-yyyy");
	public final static SimpleDateFormat FORMATO_DATA_STANDARD = new SimpleDateFormat("yyyy-MM-dd");

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
	public final static String TITOLO_ERRORE_HTTP = "Errore Http";
	public final static String TITOLO_ERRORE_DATABASE = "Errore Database";
	public final static String TITOLO_NON_TROVATO = "Non Trovato";
	public final static String TITOLO_SVUOTA_PACCHETTO = "Svuota il Pacchetto";
	public final static String TITOLO_PAGAMENTO_EFFETTUATO = "Pagamento effettuato";
	public final static String TITOLO_TORNA_A_SCEGLI_SERVIZIO = "Torna alla Scelta del Servizio";
	public final static String TITOLO_NESSUN_SERVIZIO = "Nessun Servizio prenotato";
	public final static String TITOLO_NESSUN_CLIENTE = "Nessun Cliente";
	public final static String TITOLO_SERVIZIO_PRESENTE = "Servizio già presente";
	public final static String TITOLO_GESTISCI_CLIENTI = "Gestisci Clienti - Speearth";
	public final static String TITOLO_AGGIUNGI_CLIENTE = "Aggiungi Cliente - Speearth";
	public final static String TITOLO_MODIFICA_CLIENTE = "Modifica Cliente - Speearth";
	public final static String TITOLO_ELIMINA_CLIENTE = "Elimina Cliente";
	public final static String TITOLO_CREA_OFFERTA = "Crea Offerta - Speearth";
	public final static String TITOLO_TORNA_ALLA_HOME = "Torna alla Home - Speearth";
	public final static String TITOLO_SVUOTA_OFFERTA = " Svuota l'offerta - Speearth";
	public final static String TITOLO_CLIENTE_AGGIUNTO = "Cliente aggiunto con successo";
	public final static String TITOLO_RIEPILOGO_OFFERTA = "Riepilogo Offerta - Speearth";
	public final static String TITOLO_CONFERMA_SCONTO = "Conferma Applica Sconto";

	/**
	 * Path degli FXML
	 */
	public final static String FXML_SCEGLI_SERVIZIO = "/ui/fxml/ScegliServizio.fxml";
	public final static String FXML_RICERCA_BIGLIETTO = "/ui/fxml/RicercaBiglietto.fxml";
	public final static String FXML_RICERCA_ALLOGGIO = "/ui/fxml/RicercaAlloggio.fxml";
	public final static String FXML_RICERCA_PACCHETTO = "/ui/fxml/RicercaPacchetto.fxml";
	public final static String FXML_RISULTATO_BIGLIETTO = "/ui/fxml/RisultatoBiglietto.fxml";
	public final static String FXML_RISULTATO_ALLOGGIO = "/ui/fxml/RisultatoAlloggio.fxml";
	public final static String FXML_RISULTATO_CLIENTE = "/ui/fxml/RisultatoCliente.fxml";
	public final static String FXML_RIEPILOGO_BIGLIETTO = "/ui/fxml/RiepilogoBiglietto.fxml";
	public final static String FXML_RIEPILOGO_ALLOGGIO = "/ui/fxml/RiepilogoAlloggio.fxml";
	public final static String FXML_RIEPILOGO_PACCHETTO = "/ui/fxml/RiepilogoPacchetto.fxml";
	public final static String FXML_RICERCA_ALLOGGIO_FORM = "/ui/fxml/RicercaAlloggioForm.fxml";
	public final static String FXML_RICERCA_BIGLIETTO_FORM = "/ui/fxml/RicercaBigliettoForm.fxml";
	public final static String FXML_RIEPILOGO_BIGLIETTO_ITEM = "/ui/fxml/RiepilogoBigliettoItem.fxml";
	public final static String FXML_RIEPILOGO_ALLOGGIO_ITEM = "/ui/fxml/RiepilogoAlloggioItem.fxml";
	public final static String FXML_GESTISCI_CLIENTI = "/ui/fxml/GestisciClienti.fxml";
	public final static String FXML_RIEPILOGO_OFFERTA = "/ui/fxml/RiepilogoOfferta.fxml";
	public final static String FXML_CREA_OFFERTA = "/ui/fxml/CreaOfferta.fxml";
	public final static String FXML_AGGIUNGI_CLIENTE_FORM = "/ui/fxml/AggiungiClienteForm.fxml";
	public final static String FXML_MODIFICA_CLIENTE_FORM = "/ui/fxml/ModificaClienteForm.fxml";
	public final static String FXML_CLIENTE_POPUP = "/ui/fxml/ClientePopup.fxml";
	public static final String FXML_HOME_RESPONSABILE_OFFERTE = "/ui/fxml/HomeResponsabileOfferte.fxml";

	/**
	 * Messaggi dei Dialog
	 */
	public final static String MESSAGGIO_PARAMETRI_MANCANTI = "Mancano alcuni parametri di ricerca.";
	public final static String MESSAGGIO_SVUOTA_PACCHETTO = "Vuoi davvero rimuovere tutti i Servizi scelti dal Pacchetto?";
	public final static String MESSAGGIO_CLIENTE_NON_TROVATO = "Non è stato trovato alcun Cliente con questo Codice Tessera.";
	public final static String MESSAGGIO_NESSUN_CODICE = "Non è stato inserito nessun Codice Tessera.";
	public final static String MESSAGGIO_PAGAMENTO_EFFETTUATO = "Il Pagamento è andato a buon fine!";
	public final static String MESSAGGIO_TORNA_A_SCELTA_SERVIZIO = "La tua prenotazione verrà cancellata. Vuoi procedere?";
	public final static String MESSAGGIO_NESSUN_SERVIZIO = "Non è stato scelto nessun Servizio.";
	public final static String MESSAGGIO_PACCHETTO_UN_ELEMENTO = "Il Pacchetto deve contenere almeno 2 Servizi.";
	public final static String MESSAGGIO_OFFERTA_UN_ELEMENTO = "L'Offerta deve contenere almeno 2 Servizi.";
	public final static String MESSAGGIO_NESSUN_CLIENTE = "Non è stato identificato nessun Cliente. Procedere?";
	public final static String MESSAGGIO_SERVIZIO_PRESENTE = "Hai già selezionato questo Servizio.";
	public final static String MESSAGGIO_ELIMINA_CLIENTE = "Il Cliente verrà cancellato. Vuoi procedere?";
	public final static String MESSAGGIO_TORNA_ALLA_HOME = "L'Offerta verrà cancellata. Vuoi procedere?";
	public final static String MESSAGGIO_OFFERTA_SALVATA = "L'Offerta è stata salvata correttamente.";
	public final static String MESSAGGIO_SVUOTA_OFFERTA = "Vuoi davvero rimuovere tutti i Servizi scelti per l'Offerta?";
	public final static String MESSAGGIO_CLIENTE_AGGIUNTO = "Cliente aggiunto con successo! Codice Tessera del nuovo Cliente: ";
	public final static String MESSAGGIO_PROBLEMA_DATABASE = "L'operazione su Database non è andata a buon fine.";
	public final static String MESSAGGIO_DETTAGLI_MANCANTI = "Mancano alcuni dettagli.";
	public final static String MESSAGGIO_CONFERMA_SCONTO = "Vuoi applicare lo Sconto inserito?";
	public final static String MESSAGGIO_SCONTO_INSERITO_ERRATO = "Lo Sconto inserito non è valido.";

	/**
	 * Icone
	 */
	public final static String ICONA_SPEEARTH = "/ui/img/icona_app.png";

	/**
	 * Sistemi Esterni: Aziende di Trasporto
	 */
	public final static AziendaTrasportoAdapter[] SISTEMI_ESTERNI_AZIENDE_TRASPORTO = { ItaloAdapter.getInstance(),
			TrenitaliaAdapter.getInstance() };

	/**
	 * Sistemi Esterni: Imprese Ricettive
	 */
	public final static ImpresaRicettivaAdapter[] SISTEMI_ESTERNI_IMPRESE_RICETTIVE = { BookingAdapter.getInstance() };

	/**
	 * URL dei Sistemi Esterni
	 */
	public final static String URL_TRENITALIA = "http://h4ck1n6.altervista.org/";
	public final static String URL_ITALO = "http://h4ck1n6.altervista.org/";
	public final static String URL_BOOKING = "http://h4ck1n6.altervista.org/";

	/**
	 * Espressione regolare input float: (\d*[.,])?\d+
	 */
	public final static String REG_EX_FLOAT = "(\\d*[.,])?\\d+";

}
