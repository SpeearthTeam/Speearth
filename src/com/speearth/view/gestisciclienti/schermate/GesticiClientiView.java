package com.speearth.view.gestisciclienti.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
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

/**
 * Schermata di Gestione dei Clienti
 */
public class GesticiClientiView extends View {
	@FXML
	private TextField input_ricerca_cliente;
	@FXML
	private Button bottone_torna_alla_home;
	@FXML
	private Button bottone_aggiungi;
	@FXML
	private ListView<Cliente> lista_risultati;

	/**
	 * Lista dei Clienti
	 */
	private ObservableList<Cliente> clienti;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public GesticiClientiView(Stage stage) throws IOException {
		super(stage);
		this.getStage().setTitle(Costanti.TITOLO_AGGIUNGI_CLIENTE);
		this.getRoot().addEventHandler(EventoGestioneCliente.ELIMINA_CLIENTE,
				new EventHandler<EventoGestioneCliente>() {
					@Override
					public void handle(EventoGestioneCliente event) {
						Cliente cliente = event.getCliente();
						if (GesticiClientiView.this.clienti.remove(cliente)) {
							AppFacadeController.getInstance().getGestisciClientiController().eliminaCliente(cliente);
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
					GesticiClientiView.this.aggiornaUI();
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
		this.clienti = FXCollections.observableArrayList();
		this.lista_risultati.setCellFactory(param -> new ClienteListItem(getStage()));
		this.lista_risultati.setItems(this.clienti);
		this.clienti.setAll(AppFacadeController.getInstance().getGestisciClientiController().cercaCliente(null));
		this.input_ricerca_cliente.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				GesticiClientiView.this.clienti.setAll(
						AppFacadeController.getInstance().getGestisciClientiController().cercaCliente(newValue));
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
	public void aggiungiCliente(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(Costanti.FXML_CLIENTE_POPUP))));
		stage.initModality(Modality.APPLICATION_MODAL);
		ClientePopupView view = new ClientePopupView(stage, null);
		view.mostraEAspetta();
		this.aggiornaUI();
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	@Override
	public void aggiornaUI() {
		String valore = input_ricerca_cliente.getText();
		this.clienti.setAll(AppFacadeController.getInstance().getGestisciClientiController().cercaCliente(valore));
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_GESTISCI_CLIENTI;
	}
}
