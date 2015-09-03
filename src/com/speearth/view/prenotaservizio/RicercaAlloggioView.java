package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.controller.PrenotaAlloggioController;
import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;
import com.speearth.view.EventoSelezionaServizio;
import com.speearth.view.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class RicercaAlloggioView extends View {
	@FXML
	private TextField input_localita;
	@FXML
	private DatePicker input_data_arrivo;
	@FXML
	private DatePicker input_data_partenza;
	@FXML
	private Button ricerca_alloggi;
	@FXML
	private MenuButton input_numero_singole;
	@FXML
	private MenuButton input_ora_partenza;
	@FXML
	private MenuButton input_ora_arrivo;
	@FXML
	private CheckBox input_singola;
	@FXML
	private CheckBox input_doppia;
	@FXML
	private CheckBox input_tripla;
	@FXML
	private CheckBox input_quadrupla;
	@FXML
	private MenuButton input_numero_doppie;
	@FXML
	private MenuButton input_numero_triple;
	@FXML
	private MenuButton input_numero_quadruple;
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Alloggio> lista_risultati;

	private ObservableList<Alloggio> lista_alloggi = FXCollections.observableArrayList();

	private PrenotaAlloggioController controller;

	public RicercaAlloggioView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_ALLOGGIO);

		this.controller = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaAlloggioController();
		
		getParentNode().addEventHandler(EventoSelezionaServizio.SERVIZIO_SELEZIONATO, new EventHandler<EventoSelezionaServizio>() {

			@Override
			public void handle(EventoSelezionaServizio event) {
				try {
					controller.setAlloggio((Alloggio) event.getServizio());
					vaiARiepilogo();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDati() throws NullPointerException {
		HashMap<String, String> parametri = new HashMap<String, String>();

		parametri.put("data_arrivo", this.input_data_arrivo.toString());
		parametri.put("data_partenza", this.input_data_partenza.toString());
		parametri.put("stanza_doppia", this.input_doppia.getText());
		parametri.put("località", this.input_localita.getText());
		parametri.put("numero_doppie", this.input_numero_doppie.getText());
		parametri.put("numero_quadruple", this.input_numero_quadruple.getText());
		parametri.put("numero_singole", this.input_numero_singole.getText());
		parametri.put("numero_triple", this.input_numero_triple.getText());
		parametri.put("ora_arrivo", this.input_ora_arrivo.getText());
		parametri.put("ora_partenza", this.input_ora_partenza.getText());
		parametri.put("stanza_quadrupla", this.input_quadrupla.getText());
		parametri.put("stanza_singola", this.input_singola.getText());
		parametri.put("stanza_tripla", this.input_tripla.getText());

		return parametri;
	}

	/**
	 * Inizializza la view
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)  {
		this.lista_risultati.setCellFactory(param -> new AlloggioItemList(getStage()));
		this.lista_risultati.setItems(this.lista_alloggi);
		this.bottone_ricerca.setDisable(true);
	}

	// Event Listener on Button[#ricerca_alloggi].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDati();
			ArrayList<Alloggio> risultati = this.controller.ricerca(dati);

			this.lista_alloggi.clear();
			this.lista_alloggi.setAll(risultati);
			this.lista_risultati.setItems(lista_alloggi);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		if (!this.lista_alloggi.isEmpty()) {
			Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO,
					null, Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);

			if (result.get() == ButtonType.OK)
				mostraPrecedente();
		} else
			mostraPrecedente();
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) {
		// TODO Autogenerated
	}
	
	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogoButtonClick(ActionEvent event) throws IOException {
		vaiARiepilogo();
	}

	
	public void vaiARiepilogo() throws IOException {
		if (controller.getAlloggio() == null)
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, null, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoAlloggioView view = new RiepilogoAlloggioView(getStage());
			view.setPreviousView(this);
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_ALLOGGIO;
	}
}
