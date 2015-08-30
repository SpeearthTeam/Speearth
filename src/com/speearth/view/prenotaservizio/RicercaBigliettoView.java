package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.controller.PrenotaBigliettoController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RicercaBigliettoView extends View {
	@FXML
	private TextField input_partenza;
	@FXML
	private TextField input_destinazione;
	@FXML
	private DatePicker input_data_andata;
	@FXML
	private DatePicker input_data_ritorno;
	@FXML
	private Button ricerca_biglietti;
	@FXML
	private MenuButton input_mezzo;
	@FXML
	private MenuButton input_bambini;
	@FXML
	private MenuButton input_adulti;
	@FXML
	private MenuButton input_ora_ritorno;
	@FXML
	private MenuButton input_ora_andata;
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private ListView<Biglietto> lista_risultati;

	private ObservableList<Biglietto> lista_biglietti = FXCollections.observableArrayList();

	private PrenotaBigliettoController controller;
	
	public RicercaBigliettoView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_PRENOTA_BIGLIETTO);
	}

	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDati() {
		HashMap<String, String> parametri = new HashMap<String, String>();
		parametri.put("numero_adulti", this.input_adulti.getText());
		parametri.put("numero_bambini", this.input_bambini.getText());
		parametri.put("partenza", this.input_partenza.getText());
		parametri.put("destinazione", this.input_destinazione.getText());
		parametri.put("data_andata", this.input_data_andata.toString());
		parametri.put("data_ritorno", this.input_data_ritorno.toString());
		parametri.put("ora_andata", this.input_ora_andata.getText());
		parametri.put("ora_ritorno", this.input_ora_ritorno.getText());
		parametri.put("mezzo", this.input_mezzo.getText());
		return parametri;
	}

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController();
		this.lista_risultati.setItems(this.lista_biglietti);
		this.lista_risultati.setCellFactory(param -> new RicercaBigliettoListView(getStage()));
	}

	// Event Listener on Button[#ricerca_biglietti].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		try {
			HashMap<String, String> dati = this.recuperaDati();
			ArrayList<IServizioComponent> risultati = this.controller.ricerca(dati);

			this.lista_biglietti.clear();

			for (int i = 0; i < risultati.size(); i++)
				this.lista_biglietti.add((Biglietto) risultati.get(i));

			this.lista_risultati.setItems(this.lista_biglietti);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, Costanti.MESSAGGIO_PARAMETRI_MANCANTI);
		}
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO, 
				Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);
		
		if (result.get() == ButtonType.OK)
			mostraPrecedente();
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_riepilogo].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null)
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_NESSUN_SERVIZIO, Costanti.MESSAGGIO_NESSUN_SERVIZIO);
		else {
			RiepilogoView view = new RiepilogoView(getStage());
			view.setPreaviousView(this);
			view.mostra();
		}
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_BIGLIETTO;
	}
}
