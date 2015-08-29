package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.controller.PrenotaPacchettoController;
import com.speearth.model.core.PacchettoComposite;
import com.speearth.utility.Costanti;
import com.speearth.view.View;

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

public class RicercaPacchettoView extends View {
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
	 * Controller del Caso d'Uso Prenota Pacchetto
	 */
	private PrenotaPacchettoController controller;

	/**
	 * Pacchetto contenuto nella SubView
	 */
	private PacchettoComposite pacchetto;

	/**
	 * Inizializza la classe
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.controller = AppFacadeController.getInstance().getPrenotaServizioController()
				.getPrenotaPacchettoController();
	}

	// Event Listener on Button[#bottone_scegli_servizio].onAction
	@FXML
	public void vaiAScegliServizio(ActionEvent event) throws IOException {
		if (this.pacchetto != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(Costanti.TITOLO_TORNA_A_SCEGLI_SERVIZIO);
			alert.setContentText(Costanti.MESSAGGIO_TORNA_A_SCELTA_SERVIZIO);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// cancellare la TableView
				this.controller.setPacchetto(null);
				this.cambiaScena(event, Costanti.TITOLO_SCEGLI_SERVIZIO, Costanti.FXML_SCEGLI_SERVIZIO);
			} else {
				alert.close();
			}
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) throws IOException {
		this.cambiaScena(event, Costanti.TITOLO_PRENOTA_PACCHETTO, Costanti.FXML_RICERCA_PACCHETTO);
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARiepilogo(ActionEvent event) throws IOException {
		if (AppFacadeController.getInstance().getPrenotaServizioController().getServizio() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(Costanti.TITOLO_NESSUN_SERVIZIO);
			alert.setHeaderText(Costanti.MESSAGGIO_NESSUN_SERVIZIO);
			alert.showAndWait();
		} else
			this.cambiaScena(event, Costanti.TITOLO_RIEPILOGO, Costanti.FXML_RIEPILOGO);
	}

	// Event Listener on Button[#bottone_svuota].onAction
	@FXML
	public void svuotaPacchetto(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Costanti.TITOLO_SVUOTA_PACCHETTO);
		alert.setHeaderText(Costanti.MESSAGGIO_SVUOTA_PACCHETTO);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// cancellare la TableView
			this.controller.setPacchetto(null);
		} else {
			alert.close();
		}
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaPacchetto(ActionEvent event) {
		AppFacadeController.getInstance().getPrenotaServizioController().setServizio(this.pacchetto);
	}

	// Event Listener on Button[#ricerca_biglietti].onAction
	@FXML
	public void ricercaBiglietti(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#ricerca_alloggi].onAction
	@FXML
	public void ricercaAlloggi(ActionEvent event) {
		// TODO Autogenerated
	}
}
