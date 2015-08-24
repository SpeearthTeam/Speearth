package com.speearth.view.prenotaservizio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Biglietto;
import com.speearth.model.core.IServizioComponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RicercaPacchettoView {
	@FXML
	private Button bottone_scegli_servizio;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Button bottone_svuota;
	@FXML
	private Button bottone_conferma;
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
	private ListView<BorderPane> lista_risultati;
	@FXML
	private TableView<String> tabella_pacchetto;
	
	/**
	 * Recupera i dati inseriti dall'Utente nella form di ricerca
	 * 
	 * @return HashMap<String, String>
	 */
	private HashMap<String, String> recuperaDatiBiglietto() {
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

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_svuota].onAction
	@FXML
	public void svuotaPacchetto(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Svuota Pacchetto");
		alert.setHeaderText("Vuoi svuotare il Pacchetto?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			// BO
		} else {
			// chiude
		}
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaPacchetto(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#ricerca_biglietti].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		ArrayList<IServizioComponent> risultati = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaBigliettoController().ricerca(this.recuperaDatiBiglietto());
		
		ObservableList<BorderPane> lista = FXCollections.observableArrayList();
		for (IServizioComponent biglietto : risultati) {
			lista.add(new RisultatoBigliettoView((Biglietto) biglietto));
		}
		this.lista_risultati.setItems(lista);
	}

	// Event Listener on Button[#ricerca_alloggi].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		// TODO Autogenerated
	}
}
