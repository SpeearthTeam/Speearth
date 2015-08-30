package com.speearth.view.prenotaservizio;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;
import com.speearth.view.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RisultatoAlloggioView extends View {
	@FXML
	private BorderPane risultato_alloggio;
	@FXML
	private Label output_data_arrivo;
	@FXML
	private Label output_ora_arrivo;
	@FXML
	private Label output_data_partenza;
	@FXML
	private Label output_ora_partenza;
	@FXML
	private ListView<String> output_stanze;
	@FXML
	private Label output_localita;
	@FXML
	private Label output_nome_fornitore;
	@FXML
	private Button bottone_annulla;
	@FXML
	private Button bottone_conferma;
	@FXML
	private Label output_prezzo;
	
	/**
	 * Alloggio contenuto nella SubView
	 */
	private Alloggio alloggio;

	/**
	 * Costruttore con parametro
	 * 
	 * @param alloggio
	 */
	public RisultatoAlloggioView(Stage stage) throws IOException {
		super(stage);
	}

	/**
	 * Imposta nelle Label i dati dell'alloggio
	 * 
	 * @param alloggio
	 */
	public void impostaInfo(Alloggio alloggio) {
		this.output_data_arrivo.setText(alloggio.getDataArrivo().format(DateTimeFormatter.ISO_DATE));
		this.output_ora_arrivo.setText(alloggio.getDataArrivo().format(DateTimeFormatter.ISO_TIME));
		this.output_data_partenza.setText(alloggio.getDataPartenza().format(DateTimeFormatter.ISO_DATE));
		this.output_ora_partenza.setText(alloggio.getDataPartenza().format(DateTimeFormatter.ISO_TIME));
		this.output_localita.setText(alloggio.getLocalita().toString());
		this.output_nome_fornitore.setText(alloggio.getFornitore().toString());
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()));
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()) + " �");

		HashMap<String, Integer> stanze = alloggio.getStanze();
		Set<String> tipi_stanze = stanze.keySet();
		ArrayList<String> rooms = new ArrayList<String>();

		for (String tipo : tipi_stanze)
			rooms.add(tipo + ": " + stanze.get(tipo));

		ObservableList<String> observableRooms = FXCollections.observableArrayList();
		observableRooms.setAll(rooms);
		this.output_stanze.setItems(observableRooms);
	}

	// Event Listener on BorderPane.onMouseClicked
	@FXML
	public void selezionaAlloggio(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_annulla].onAction
	@FXML
	public void deselezionaAlloggio(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaAlloggio(ActionEvent event) {
		AppFacadeController.getInstance().getPrenotaServizioController().setServizio(this.alloggio);
	}

	/**
	 * Restituisce la BorderPane
	 * 
	 * @return BorderPane
	 */
	public BorderPane getBorderPane() {
		return this.risultato_alloggio;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RISULTATO_ALLOGGIO;
	}
}
