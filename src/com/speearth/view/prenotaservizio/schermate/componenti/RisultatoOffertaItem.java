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
	private BorderPane risultato_servizio;
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
		aggiornaUI();
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
	 * Aggiorna il Servizio
	 * 
	 * @param offerta
	 */
	public void updateOfferta(Offerta offerta) {
		this.setOfferta(offerta);
		aggiornaUI();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		this.risultato_servizio.getParent().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				EventoSelezionaOfferta evento = new EventoSelezionaOfferta(EventoSelezionaOfferta.OFFERTA_SELEZIONATA,
//						RisultatoOffertaItem.this.offerta);
//				getRoot().fireEvent(evento);
//			}
//		});
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
	 * 
	 */
	@Override
	public void aggiornaUI() {
		this.output_nome.setText(this.offerta.getNome());
		this.output_data_inizio.setText(Costanti.FORMATO_DATA.format(this.offerta.getDataInizio()));
		this.output_data_scadenza.setText(Costanti.FORMATO_DATA.format(this.offerta.getDataFine()));
	}
}
