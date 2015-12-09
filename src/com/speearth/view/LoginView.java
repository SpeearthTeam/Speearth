package com.speearth.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.utility.Costanti;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Schermata iniziale dell'Applicazione
 */
public class LoginView extends View {
	@FXML
	private BorderPane login_pane;
	@FXML
	private TextField input_username;
	@FXML
	private PasswordField input_password;
	@FXML
	private Button bottone_entra;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public LoginView(Stage stage) throws IOException {
		super(stage);
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				stage.close();
			}
		});
		stage.setTitle(Costanti.TITOLO_LOGIN);
	}

	// Event Listener on Button[#bottone_entra].onAction
	@FXML
	public void autentica(ActionEvent event) throws IOException {
		if (!this.input_username.getText().isEmpty() && !this.input_password.getText().isEmpty()) {
			if (AppFacadeController.getInstance().getLoginController().login(this.input_username.getText(),
					this.input_password.getText()) != null) {
				HomeView view = new HomeView(this.getStage());
				view.mostra();
			} else
				this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
		} else
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_CREDENZIALI_MANCANTI);
	}

	/**
	 * Inizializza la View
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.login_pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					try {
						LoginView.this.autentica(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_LOGIN;
	}
}
