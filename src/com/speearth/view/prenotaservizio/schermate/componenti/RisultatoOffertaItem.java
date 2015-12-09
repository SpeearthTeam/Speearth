package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Offerta;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Componente che rappresenta un'Offerta nella Lista delle Offerte trovate
 */
public class RisultatoOffertaItem extends SubView {
	@FXML
	private BorderPane risultato_servizio;
	@FXML
	private Label output_nome;
	@FXML
	private Label output_data_inizio;
	@FXML
	private Label output_data_scadenza;

	/**
	 * Offerta contenuta nella SubView
	 */
	private Offerta offerta;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @param offerta
	 * @throws IOException
	 */
	public RisultatoOffertaItem(Stage stage, Offerta offerta) throws IOException {
		super(stage);
		this.offerta = offerta;
		this.aggiornaUI();
	}

	/**
	 * Restituisce l'Offerta
	 */
	public Offerta getOfferta() {
		return this.offerta;
	}

	/**
	 * Imposta l'Offerta
	 * 
	 * @param offerta
	 */
	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

	/**
	 * Aggiorna l'Offerta
	 * 
	 * @param offerta
	 */
	public void updateOfferta(Offerta offerta) {
		this.setOfferta(offerta);
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
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_RISULTATO_OFFERTA_ITEM;
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		this.output_nome.setText(this.offerta.getNome());
		this.output_data_inizio.setText(Costanti.FORMATO_DATA.format(this.offerta.getDataInizio()));
		this.output_data_scadenza.setText(Costanti.FORMATO_DATA.format(this.offerta.getDataFine()));
	}
}
