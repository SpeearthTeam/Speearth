package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;
import com.speearth.view.prenotaservizio.eventi.EventoSelezionaServizio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RisultatoBigliettoItem extends SubView {
	@FXML
	private BorderPane risultato_biglietto;
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
	 * Biglietto contenuto nella SubView
	 */
	private Biglietto biglietto;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RisultatoBigliettoItem(Stage stage, Biglietto biglietto) throws IOException {
		super(stage);
		this.biglietto = biglietto;
		updateUI();
	}

	/**
	 * Restituisce il biglietto
	 */
	public Biglietto getBiglietto() {
		return biglietto;
	}

	/**
	 * Imposta il biglietto
	 * 
	 * @param biglietto
	 */
	public void setBiglietto(Biglietto biglietto) {
		this.biglietto = biglietto;
	}

	/**
	 * Aggiorna il biglietto
	 * 
	 * @param biglietto
	 */
	public void updateBiglietto(Biglietto biglietto) {
		setBiglietto(biglietto);
		updateUI();
	}

	// Event Listener on Button[#bottone_conferma].onAction
	@FXML
	public void confermaBiglietto(ActionEvent event) throws IOException {
		EventoSelezionaServizio evento_seleziona_servizio = new EventoSelezionaServizio(
				EventoSelezionaServizio.SERVIZIO_SELEZIONATO, biglietto);
		getRoot().fireEvent(evento_seleziona_servizio);
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
		return Costanti.FXML_RISULTATO_BIGLIETTO;
	}

	@Override
	public void updateUI() {
		this.output_data_destinazione_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoAndata()));
		this.output_data_partenza_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaAndata()));

		if (biglietto.getDataArrivoRitorno() != null) {
			this.output_data_destinazione_ritorno
					.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoRitorno()));
		}

		if (biglietto.getDataPartenzaRitorno() != null) {
			this.output_data_partenza_ritorno.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaRitorno()));
		}
		this.output_ora_partenza_ritorno.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaRitorno()));
		this.output_ora_destinazione_ritorno.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoRitorno()));
		this.output_ora_destinazione_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataArrivoAndata()));
		this.output_ora_partenza_andata.setText(Costanti.FORMATO_DATA_ORA.format(biglietto.getDataPartenzaAndata()));
		this.output_partenza_andata.setText(biglietto.getPartenza());
		this.output_partenza_ritorno.setText(biglietto.getDestinazione());
		this.output_destinazione_andata.setText(biglietto.getDestinazione());
		this.output_destinazione_ritorno.setText(biglietto.getPartenza());
		this.output_n_adulti_andata.setText(Integer.toString(biglietto.getNumeroAdulti()));
		this.output_n_adulti_ritorno.setText(Integer.toString(biglietto.getNumeroAdulti()));
		this.output_n_bambini_andata.setText(Integer.toString(biglietto.getNumeroBambini()));
		this.output_n_bambini_ritorno.setText(Integer.toString(biglietto.getNumeroBambini()));
		this.output_nome_fornitore.setText(biglietto.getFornitore());
		this.output_prezzo.setText(biglietto.getPrezzo() + " €");
	}
}
