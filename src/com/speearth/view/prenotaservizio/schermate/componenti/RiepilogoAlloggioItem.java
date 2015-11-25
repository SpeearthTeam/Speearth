package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Stanza;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;
import com.speearth.view.eventi.EventoSelezionaServizio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RiepilogoAlloggioItem extends SubView {
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
	public RiepilogoAlloggioItem(Stage stage, Alloggio alloggio) throws IOException {
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
		this.output_data_arrivo.setText(Costanti.FORMATO_DATA_ORA.format(alloggio.getDataArrivo()));
		this.output_ora_arrivo.setText(Costanti.FORMATO_DATA_ORA.format(alloggio.getDataArrivo()));
		this.output_data_partenza.setText(Costanti.FORMATO_DATA_ORA.format(alloggio.getDataPartenza()));
		this.output_ora_partenza.setText(Costanti.FORMATO_DATA_ORA.format(alloggio.getDataPartenza()));
		this.output_localita.setText(alloggio.getLocalita().toString());
		this.output_nome_fornitore.setText(alloggio.getFornitore().toString());
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()));
		this.output_prezzo.setText(Float.toString(alloggio.getPrezzo()) + " €");

		ArrayList<Stanza> stanze = (ArrayList<Stanza>) alloggio.getStanze();
		ArrayList<String> tipi_stanze = new ArrayList<String>();

		for (Stanza stanza : stanze) {
			tipi_stanze.add(stanza.getTipologia());
		}

		ObservableList<String> observableRooms = FXCollections.observableArrayList();
		observableRooms.setAll(tipi_stanze);
		this.output_stanze.setItems(observableRooms);
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaAlloggio(ActionEvent event) throws IOException {
		EventoSelezionaServizio evento_seleziona_servizio = new EventoSelezionaServizio(
				EventoSelezionaServizio.SERVIZIO_SELEZIONATO, alloggio);
		getRoot().fireEvent(evento_seleziona_servizio);
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RIEPILOGO_ALLOGGIO_ITEM;
	}

}
