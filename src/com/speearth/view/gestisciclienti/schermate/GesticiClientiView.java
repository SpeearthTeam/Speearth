package com.speearth.view.gestisciclienti.schermate;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.GestisciClientiController;
import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.View;
import com.speearth.view.gestisciclienti.schermate.componenti.ClienteListItem;
import com.speearth.view.prenotaservizio.schermate.ScegliServizioView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.stage.Stage;

public class GesticiClientiView extends View {
	@FXML
	private TextField ricerca_cliente_input;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private ListView<Cliente> lista_risultati;
	
	/**
	 * Lista dei clienti gestiti
	 */
	private ObservableList<Cliente> clienti;
	
	/**
	 * Controller per la gestione dei clienti
	 */
	private GestisciClientiController controller;
	
	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public GesticiClientiView(Stage stage) throws IOException {
		super(stage);
		getStage().setTitle(Costanti.TITOLO_GESTISCI_CLIENTE);
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = GestisciClientiController.getInstance();
		clienti = FXCollections.observableArrayList();
		lista_risultati.setCellFactory(param -> new ClienteListItem(getStage()));
		lista_risultati.setItems(clienti);
		clienti.setAll(controller.cercaCliente(null));
		ricerca_cliente_input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				clienti.setAll(controller.cercaCliente(newValue));
			}
		});
	}
	
	// Event Listener on Button[#bottone_torna_alla_home].onAction
	@FXML
	public void vaiAllaHome(ActionEvent event) throws IOException {
		ScegliServizioView view = new ScegliServizioView(getStage());
		view.mostra();
	}

	/**
	 * Restituisce il nome della risorsa corrispondente alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_GESTISCI_CLIENTI;
	}
}
