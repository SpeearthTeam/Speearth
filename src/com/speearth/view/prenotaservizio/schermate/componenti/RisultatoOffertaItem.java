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

public class RisultatoOffertaItem extends SubView {
	@FXML
	private BorderPane risultato_alloggio;
	@FXML
	private Label output_nome;
	@FXML
	private Label output_data_inizio;
	@FXML
	private Label output_data_scadenza;

	/**
	 * Offerta contenuto nella SubView
	 */
	private Offerta offerta;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RisultatoOffertaItem(Stage stage, Offerta offerta) throws IOException {
		super(stage);
		this.offerta = offerta;
		updateUI();
	}

	/**
	 * Restituisce il offerta
	 */
	public Offerta getOfferta() {
		return offerta;
	}

	/**
	 * Imposta il offerta
	 * 
	 * @param offerta
	 */
	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

	/**
	 * Aggiorna il offerta
	 * 
	 * @param offerta
	 */
	public void updateOfferta(Offerta offerta) {
		setOfferta(offerta);
		updateUI();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RISULTATO_OFFERTA_ITEM;
	}

	@Override
	public void updateUI() {
		// TODO
	}
}
