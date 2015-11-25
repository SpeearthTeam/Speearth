package com.speearth.view.gestisciclienti.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.GestisciClientiController;
import com.speearth.model.core.Cliente;
import com.speearth.utility.Costanti;
import com.speearth.view.HomeView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoGestioneCliente;
import com.speearth.view.gestisciclienti.schermate.componenti.ClienteListItem;

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

public class GesticiClientiView extends View {
	@FXML
	private TextField ricerca_cliente_input;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_aggiungi;
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
		getStage().setTitle(Costanti.TITOLO_AGGIUNGI_CLIENTE);
		getRoot().addEventHandler(EventoGestioneCliente.ELIMINA_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				Cliente cliente = event.getCliente();
				if (clienti.remove(cliente)) {
					controller.eliminaCliente(cliente);
				}
			}
		});
		getRoot().addEventHandler(EventoGestioneCliente.MODIFICA_CLIENTE, new EventHandler<EventoGestioneCliente>() {
			@Override
			public void handle(EventoGestioneCliente event) {
				try {
					Stage stage = new Stage();
					stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(Costanti.FXML_CLIENTE_POPUP))));
					stage.initModality(Modality.APPLICATION_MODAL);
					ClientePopupView view = new ClientePopupView(stage, event.getCliente());
					view.mostraEAspetta();
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
		HomeView view = new HomeView(getStage());
		view.mostra();
	}

	// Event Listener on Button[#bottone_aggiungi].onAction
	@FXML
	public void aggiungiCliente(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(Costanti.FXML_CLIENTE_POPUP))));
		stage.initModality(Modality.APPLICATION_MODAL);
		ClientePopupView view = new ClientePopupView(stage, null);
		view.mostraEAspetta();
		this.updateUI();
	}

	/**
	 * Aggiorna la view
	 */
	@Override
	public void updateUI() {
		String valore = ricerca_cliente_input.getText();
		clienti.setAll(controller.cercaCliente(valore));
	}

	/**
	 * Restituisce il nome della risorsa corrispondente alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_GESTISCI_CLIENTI;
	}
}
