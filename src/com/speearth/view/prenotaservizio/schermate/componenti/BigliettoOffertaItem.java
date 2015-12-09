package com.speearth.view.prenotaservizio.schermate.componenti;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Biglietto;
import com.speearth.utility.Costanti;
import com.speearth.view.SubView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Componente che rappresenta un Biglietto nell'elenco dei Servizi che
 * compongono un'Offerta
 */
public class BigliettoOffertaItem extends SubView {
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
	public BigliettoOffertaItem(Stage stage, Biglietto biglietto) throws IOException {
		super(stage);
		this.biglietto = biglietto;
		this.aggiornaUI();
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
		this.setBiglietto(biglietto);
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
		return Costanti.FXML_BIGLIETTO_OFFERTA_ITEM;
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		this.output_data_destinazione_andata
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataArrivoAndata()));
		this.output_data_partenza_andata
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataPartenzaAndata()));
		if (this.biglietto.getDataArrivoRitorno() != null)
			this.output_data_destinazione_ritorno
					.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataArrivoRitorno()));
		if (this.biglietto.getDataPartenzaRitorno() != null)
			this.output_data_partenza_ritorno
					.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataPartenzaRitorno()));
		this.output_ora_partenza_ritorno
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataPartenzaRitorno()));
		this.output_ora_destinazione_ritorno
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataArrivoRitorno()));
		this.output_ora_destinazione_andata
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataArrivoAndata()));
		this.output_ora_partenza_andata
				.setText(Costanti.FORMATO_DATA_ORA.format(this.biglietto.getDataPartenzaAndata()));
		this.output_partenza_andata.setText(this.biglietto.getPartenza());
		this.output_partenza_ritorno.setText(this.biglietto.getDestinazione());
		this.output_destinazione_andata.setText(this.biglietto.getDestinazione());
		this.output_destinazione_ritorno.setText(this.biglietto.getPartenza());
		this.output_n_adulti_andata.setText(Integer.toString(this.biglietto.getNumeroAdulti()));
		this.output_n_adulti_ritorno.setText(Integer.toString(this.biglietto.getNumeroAdulti()));
		this.output_n_bambini_andata.setText(Integer.toString(this.biglietto.getNumeroBambini()));
		this.output_n_bambini_ritorno.setText(Integer.toString(this.biglietto.getNumeroBambini()));
		this.output_nome_fornitore.setText(this.biglietto.getFornitore());
		this.output_prezzo.setText(this.biglietto.getPrezzo() + " €");
	}
}
