package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.speearth.model.core.Alloggio;
import com.speearth.model.core.Stanza;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Componente che rappresenta un Alloggio nell'elenco dei Servizi che compongono
 * un'Offerta
 */
public class AlloggioOffertaItem extends SubView {
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
	 * Costruttore
	 * 
	 * @param stage
	 * @param alloggio
	 * @throws IOException
	 */
	public AlloggioOffertaItem(Stage stage, Alloggio alloggio) throws IOException {
		super(stage);
		this.alloggio = alloggio;
		this.aggiornaUI();
	}

	/**
	 * Inizializza la SubView
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Restituisce l'Alloggio
	 * 
	 * @return Alloggio
	 */
	public Alloggio getAlloggio() {
		return this.alloggio;
	}

	/**
	 * Imposta l'Alloggio
	 * 
	 * @param alloggio
	 */
	public void setAlloggio(Alloggio alloggio) {
		this.alloggio = alloggio;
	}

	/**
	 * Aggiorna l'Alloggio
	 * 
	 * @param alloggio
	 */
	public void updateAlloggio(Alloggio alloggio) {
		this.setAlloggio(alloggio);
		this.aggiornaUI();
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		this.output_data_arrivo.setText(Costanti.FORMATO_DATA_ORA.format(this.alloggio.getDataArrivo()));
		this.output_ora_arrivo.setText(Costanti.FORMATO_DATA_ORA.format(this.alloggio.getDataArrivo()));
		this.output_data_partenza.setText(Costanti.FORMATO_DATA_ORA.format(this.alloggio.getDataPartenza()));
		this.output_ora_partenza.setText(Costanti.FORMATO_DATA_ORA.format(this.alloggio.getDataPartenza()));
		this.output_localita.setText(this.alloggio.getLocalita().toString());
		this.output_nome_fornitore.setText(this.alloggio.getFornitore().toString());
		this.output_prezzo.setText(Float.toString(this.alloggio.getPrezzo()));
		this.output_prezzo.setText(Float.toString(this.alloggio.getPrezzo()) + " €");
		ArrayList<Stanza> stanze = new ArrayList<Stanza>(this.alloggio.getStanze());
		ArrayList<String> tipi_stanze = new ArrayList<String>();
		for (Stanza stanza : stanze)
			tipi_stanze.add(stanza.getTipologia());
		ObservableList<String> observableRooms = FXCollections.observableArrayList();
		observableRooms.setAll(tipi_stanze);
		this.output_stanze.setItems(observableRooms);
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_ALLOGGIO_OFFERTA_ITEM;
	}
}
