package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import com.speearth.model.core.Alloggio;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RisultatoAlloggioItem extends SubView {
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
	public RisultatoAlloggioItem(Stage stage, Alloggio alloggio) throws IOException {
		super(stage);
		this.alloggio = alloggio;
		updateUI();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Restituisce l'alloggio
	 */
	public Alloggio getAlloggio() {
		return alloggio;
	}

	/**
	 * Imposta l'alloggio
	 * 
	 * @param alloggio
	 */
	public void setAlloggio(Alloggio alloggio) {
		this.alloggio = alloggio;
	}

	/**
	 * Aggiorna l'alloggio
	 * 
	 * @param alloggio
	 */
	public void updateAlloggio(Alloggio alloggio) {
		setAlloggio(alloggio);
		updateUI();
	}

	/**
	 * Imposta nelle Label i dati dell'alloggio
	 * 
	 * @param alloggio
	 */
	@Override
	public void updateUI() {
		this.output_data_arrivo.setText(alloggio.getDataArrivo().format(DateTimeFormatter.ISO_DATE));
		this.output_ora_arrivo.setText(alloggio.getDataArrivo().format(DateTimeFormatter.ISO_TIME));
		this.output_data_partenza.setText(alloggio.getDataPartenza().format(DateTimeFormatter.ISO_DATE));
		this.output_ora_partenza.setText(alloggio.getDataPartenza().format(DateTimeFormatter.ISO_TIME));
		this.output_localita.setText(alloggio.getLocalita().toString());
		this.output_nome_fornitore.setText(alloggio.getFornitore().toString());
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()));
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()) + " €");

		HashMap<String, Integer> stanze = alloggio.getStanze();
		Set<String> tipi_stanze = stanze.keySet();
		ArrayList<String> rooms = new ArrayList<String>();

		for (String tipo : tipi_stanze)
			rooms.add(tipo + ": " + stanze.get(tipo));

		ObservableList<String> observableRooms = FXCollections.observableArrayList();
		observableRooms.setAll(rooms);
		this.output_stanze.setItems(observableRooms);
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaAlloggio(ActionEvent event) throws IOException {
		EventoSelezionaServizio evento_seleziona_servizio = new EventoSelezionaServizio(
				EventoSelezionaServizio.SERVIZIO_SELEZIONATO, alloggio);
		getParentNode().fireEvent(evento_seleziona_servizio);
		this.bottone_conferma.setDisable(true);
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RISULTATO_ALLOGGIO;
	}
}
