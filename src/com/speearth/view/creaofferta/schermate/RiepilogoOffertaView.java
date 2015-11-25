package com.speearth.view.creaofferta.schermate;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.creaofferta.schermate.componenti.OffertaListItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RiepilogoOffertaView extends View {
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_ricerca;
	@FXML
	private Button bottone_riepilogo;
	@FXML
	private Label output_totale_offerta;
	@FXML
	private Button bottone_salva_offerta;
	@FXML
	private ListView<ServizioComponent> riepilogo_servizi;
	@FXML
	private TextField input_sconto_offerta;
	@FXML
	private DatePicker input_data_inizio_offerta;
	@FXML
	private DatePicker input_data_fine_offerta;

	private ObservableList<ServizioComponent> lista_servizi = FXCollections.observableArrayList();

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public RiepilogoOffertaView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_RIEPILOGO_OFFERTA );
		this.impostaInfoOfferta(AppFacadeController.getInstance().getCreaOffertaController().getOfferta());
	}

	/**
	 * Imposta le informazioni dell'offerta nella View
	 * 
	 * @param pacchetto
	 */
	private void impostaInfoOfferta(Offerta offerta) {
		this.lista_servizi.setAll(offerta.getListaServizi());
		this.riepilogo_servizi.setItems(this.lista_servizi);
		this.output_totale_offerta.setText(Float.toString(offerta.getPrezzo()));
	}

	/**
	 * Inizializza la View
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.riepilogo_servizi.setCellFactory(param -> new OffertaListItem(getStage()));
		this.riepilogo_servizi.setItems(this.lista_servizi);
		this.input_data_inizio_offerta.setValue(LocalDate.now());
		this.input_sconto_offerta.setText("0");;
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_TORNA_ALLA_HOME,
				Costanti.MESSAGGIO_TORNA_ALLA_HOME, null);
		if (result.get() == ButtonType.OK) {
			AppFacadeController.getInstance().getCreaOffertaController().reset();
			AppFacadeController.getInstance().getCreaOffertaController().getPrenotaBigliettoController()
					.clearBiglietti();
			AppFacadeController.getInstance().getCreaOffertaController().getPrenotaAlloggioController().clearAlloggi();
			HomeView view = new HomeView(getStage());
			view.mostra();
		}
	}

	// Event Listener on Button[#bottone_ricerca].onAction
	@FXML
	public void vaiARicerca(ActionEvent event) throws IOException {
		CreaOffertaView view = new CreaOffertaView(getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_salva_offerta].onAction
	@FXML
	public void salvaOfferta(ActionEvent event) throws IOException {
		if (this.input_data_fine_offerta.getValue() != null && this.input_data_inizio_offerta != null
				&& this.input_sconto_offerta.getText() != null) {
			AppFacadeController.getInstance().getCreaOffertaController().getOfferta()
					.setDataInizio(Date.from(this.input_data_inizio_offerta.getValue().atStartOfDay()
							.atZone(ZoneId.systemDefault()).toInstant()));
			AppFacadeController.getInstance().getCreaOffertaController().getOfferta().setDataFine(Date.from(
					this.input_data_fine_offerta.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			AppFacadeController.getInstance().getCreaOffertaController()
					.applicaSconto(Float.parseFloat(this.input_sconto_offerta.getText()));
			if (AppFacadeController.getInstance().getCreaOffertaController().confermaOfferta()) {
				mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_TORNA_ALLA_HOME, Costanti.MESSAGGIO_OFFERTA_SALVATA,
						null);
				AppFacadeController.getInstance().getCreaOffertaController().reset();
				AppFacadeController.getInstance().getCreaOffertaController().getPrenotaBigliettoController()
						.clearBiglietti();
				AppFacadeController.getInstance().getCreaOffertaController().getPrenotaAlloggioController()
						.clearAlloggi();
				HomeView view = new HomeView(getStage());
				view.mostra();
			} else
				mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, Costanti.MESSAGGIO_PROBLEMA_DATABASE, null);
		} else
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, Costanti.MESSAGGIO_DETTAGLI_MANCANTI, null);
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_RIEPILOGO_OFFERTA;
	}

}
