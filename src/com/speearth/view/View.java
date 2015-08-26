package com.speearth.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class View implements Initializable {
	/**
	 * Inizializza la Classe
	 */
	@Override
	public abstract void initialize(URL arg0, ResourceBundle arg1);

	/**
	 * Cambia la schermata da visualizzare nella finestra
	 * 
	 * @param event
	 * @param titolo
	 * @param src
	 * @throws IOException
	 */
	protected void cambiaScena(ActionEvent event, String titolo, String src) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(titolo);
		Pane pane = FXMLLoader.load(getClass().getResource(src));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
}
