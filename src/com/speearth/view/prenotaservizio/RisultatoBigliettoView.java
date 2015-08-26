package com.speearth.view.prenotaservizio;

import java.io.IOException;

import com.speearth.model.core.Biglietto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class RisultatoBigliettoView extends BorderPane {
	@FXML
	private Label output_partenza_andata;
	@FXML
	private Label output_data_partenza_andata;
	@FXML
	private Label output_ora_partenza_andata;
	@FXML
	private Label output_destinazione_andata;
	@FXML
	private Label output_data_destinazione_andata;
	@FXML
	private Label output_ora_destinazione_andata;
	@FXML
	private Label output_n_adulti_andata;
	@FXML
	private Label output_n_bambini_andata;
	@FXML
	private Label output_partenza_ritorno;
	@FXML
	private Label output_data_partenza_ritorno;
	@FXML
	private Label output_ora_partenza_ritorno;
	@FXML
	private Label output_destinazione_ritorno;
	@FXML
	private Label output_data_destinazione_ritorno;
	@FXML
	private Label output_ora_destinazione_ritorno;
	@FXML
	private Label output_n_adulti_ritorno;
	@FXML
	private Label output_n_bambini_ritorno;
	@FXML
	private Label output_nome_fornitore;
	@FXML
	private Button bottone_annulla;
	@FXML
	private Button bottone_conferma;
	@FXML
	private Label output_prezzo;
	
	/**
	 * Costruttore con parametro
	 * 
	 * @param biglietto
	 */
	public RisultatoBigliettoView(Biglietto biglietto) {
		// TODO Auto-generated constructor stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/ui/fxml/RisultatoBiglietto"));
		loader.setController(this);
		this.impostaInfo(biglietto);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Imposta nelle Label i dati del Biglietto
	 * 
	 * @param biglietto
	 */
	public void impostaInfo(Biglietto biglietto) {
		this.output_data_destinazione_andata.setText(biglietto.getDataArrivoAndata().toString());
		this.output_data_destinazione_ritorno.setText(biglietto.getDataArrivoRitorno().toString());
		this.output_data_partenza_andata.setText(biglietto.getDataPartenzaAndata().toString());
		this.output_data_partenza_ritorno.setText(biglietto.getDataPartenzaRitorno().toString());
		this.output_destinazione_andata.setText(biglietto.getDestinazione());
		this.output_destinazione_ritorno.setText(biglietto.getPartenza());
		this.output_n_adulti_andata.setText(Integer.toString(biglietto.getNumeroAdulti()));
		this.output_n_adulti_ritorno.setText(Integer.toString(biglietto.getNumeroAdulti()));
		this.output_n_bambini_andata.setText(Integer.toString(biglietto.getNumeroBambini()));
		this.output_n_bambini_ritorno.setText(Integer.toString(biglietto.getNumeroBambini()));
		this.output_nome_fornitore.setText(biglietto.getFornitore());
		// e gli orari...
	}

	// Event Listener on BorderPane.onMouseClicked
	@FXML
	public void selezionaBiglietto(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_annulla].onAction
	@FXML
	public void deselezionaBiglietto(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaBiglietto(ActionEvent event) {
		// TODO Autogenerated
	}
}