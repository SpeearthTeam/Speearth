package com.speearth.view.gestisciimpiegati.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoGestioneImpiegato;
import com.speearth.view.gestisciimpiegati.schermate.componenti.ImpiegatoListItem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Schermata di Gestione degli Impiegati
 */
public class GesticiImpiegatiView extends View {
	@FXML
	private TextField input_ricerca_impiegato;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_aggiungi;
	@FXML
	private ListView<Impiegato> output_lista_risultati;

	/**
	 * Lista degli Impiegati
	 */
	private ObservableList<Impiegato> impiegati;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public GesticiImpiegatiView(Stage stage) throws IOException {
		super(stage);
		this.getStage().setTitle(Costanti.TITOLO_GESTISCI_IMPIEGATI);
		this.getRoot().addEventHandler(EventoGestioneImpiegato.ELIMINA_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						Impiegato impiegato = event.getImpiegato();
						if (GesticiImpiegatiView.this.impiegati.remove(impiegato)) {
							AppFacadeController.getInstance().getGestisciImpiegatiController()
									.eliminaImpiegato(impiegato);
						}
					}
				});
		this.getRoot().addEventHandler(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						try {
							Stage stage = new Stage();
							stage.setScene(
									new Scene(FXMLLoader.load(getClass().getResource(Costanti.FXML_IMPIEGATO_POPUP))));
							stage.initModality(Modality.APPLICATION_MODAL);
							ImpiegatoPopupView view = new ImpiegatoPopupView(stage, event.getImpiegato());
							view.mostraEAspetta();
							GesticiImpiegatiView.this.aggiornaUI();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
	}

	/**
	 * Inizializza la View
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.impiegati = FXCollections.observableArrayList();
		this.output_lista_risultati.setCellFactory(param -> new ImpiegatoListItem(getStage()));
		this.output_lista_risultati.setItems(this.impiegati);
		this.impiegati.setAll(AppFacadeController.getInstance().getGestisciImpiegatiController().cercaImpiegato(null));
		this.input_ricerca_impiegato.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				GesticiImpiegatiView.this.impiegati.setAll(
						AppFacadeController.getInstance().getGestisciImpiegatiController().cercaImpiegato(newValue));
			}
		});
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		HomeView view = new HomeView(this.getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_aggiungi].onAction
	@FXML
	public void aggiungiImpiegato(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(Costanti.FXML_IMPIEGATO_POPUP))));
		stage.initModality(Modality.APPLICATION_MODAL);
		ImpiegatoPopupView view = new ImpiegatoPopupView(stage, null);
		view.mostraEAspetta();
		this.aggiornaUI();
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		String valore = this.input_ricerca_impiegato.getText();
		this.impiegati
				.setAll(AppFacadeController.getInstance().getGestisciImpiegatiController().cercaImpiegato(valore));
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_GESTISCI_IMPIEGATI;
	}
}
