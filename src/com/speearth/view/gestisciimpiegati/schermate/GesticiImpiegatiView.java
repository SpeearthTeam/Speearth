package com.speearth.view.gestisciimpiegati.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.controller.GestisciImpiegatiController;
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

public class GesticiImpiegatiView extends View {
	@FXML
	private TextField ricerca_impiegato_input;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_aggiungi;
	@FXML
	private ListView<Impiegato> lista_risultati;

	/**
	 * Lista dei clienti gestiti
	 */
	private ObservableList<Impiegato> clienti;

	/**
	 * Controller per la gestione dei clienti
	 */
	private GestisciImpiegatiController controller;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public GesticiImpiegatiView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_AGGIUNGI_IMPIEGATO);
		getRoot().addEventHandler(EventoGestioneImpiegato.ELIMINA_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						Impiegato impiegato = event.getImpiegato();
						if (clienti.remove(impiegato)) {
							controller.eliminaImpiegato(impiegato);
						}
					}
				});
		getRoot().addEventHandler(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
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
							GesticiImpiegatiView.this.updateUI();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = AppFacadeController.getInstance().getGestisciImpiegatiController();
		clienti = FXCollections.observableArrayList();
		lista_risultati.setCellFactory(param -> new ImpiegatoListItem(getStage()));
		lista_risultati.setItems(clienti);
		clienti.setAll(controller.cercaImpiegato(null));
		ricerca_impiegato_input.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				clienti.setAll(controller.cercaImpiegato(newValue));
			}
		});
	}

	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		HomeView view = new HomeView(getStage());
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
		this.updateUI();
	}

	/**
	 * Aggiorna la view
	 */
	@Override
	public void updateUI() {
		String valore = ricerca_impiegato_input.getText();
		clienti.setAll(controller.cercaImpiegato(valore));
	}

	/**
	 * Restituisce il nome della risorsa corrispondente alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_GESTISCI_IMPIEGATI;
	}
}
