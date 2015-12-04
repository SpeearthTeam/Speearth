package com.speearth.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginView extends View {
	@FXML
	private TextField input_username;
	@FXML
	private PasswordField input_password;
	@FXML
	private Button bottone_entra;

	/**
	 * Costruttore di default
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
			Impiegato utente = AppFacadeController.getInstance().getLoginController()
					.login(this.input_username.getText(), this.input_password.getText());
			if (utente != null) {
				HomeView view = new HomeView(getStage());
				view.mostra();
			} else
				mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
		} else
			mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, null, Costanti.MESSAGGIO_CREDENZIALI_MANCANTI);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_LOGIN;
	}
}