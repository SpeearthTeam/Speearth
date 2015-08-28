package com.speearth.view;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Classe che rappresenta una schermata dell'Applicazione
 */
public abstract class View implements Initializable {
	/**
	 * Crea un Alert Dialog e rimane in attesa di essere consumato
	 * 
	 * @param type
	 * @param title
	 * @param text
	 * @return Optional<ButtonType>
	 */
	public Optional<ButtonType> mostraAlert(AlertType type, String title, String text) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		return alert.showAndWait();
	}

	/**
	 * Cambia la schermata da visualizzare nella finestra
	 * 
	 * @param event
	 * @param titolo
	 * @param src
	 * @throws IOException
	 */
	public void cambiaScena(ActionEvent event, String titolo, String src) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(titolo);
		Pane pane = FXMLLoader.load(getClass().getResource(src));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
}
