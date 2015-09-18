package com.speearth.view;

import java.io.IOException;
import java.util.Optional;

import com.speearth.utility.Costanti;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Classe che rappresenta una schermata dell'Applicazione
 */
public abstract class View implements Initializable {

	/**
	 * Stage della View
	 */
	protected Stage stage;

	/**
	 * View precedente
	 */
	protected View previous_view;

	/**
	 * Nodo genitore della View
	 */
	protected Parent parent_node;

	/**
	 * Scena corrente
	 */
	protected Scene scene;

	/**
	 * Costruttore della View
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public View(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(getResourceName()));
		loader.setController(this);
		this.parent_node = loader.load();
		this.stage = stage;
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	public abstract String getResourceName();

	/**
	 * Mostra la view
	 */
	public void mostra() {
		// se la scena non esiste la creo
		if (this.scene == null)
			this.scene = new Scene(this.parent_node);
		
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	/**
	 * Mostra la View precedente
	 */
	public void mostraPrecedente() {
		// a livello di interazione questo alert non ha senso...
		if (this.previous_view == null)
			this.mostraAlert(AlertType.ERROR, Costanti.TITOLO_ERRORE, "Non esiste una view precedente", null);
		else
			this.previous_view.mostra();
	}

	/**
	 * Restituisce lo Stage principale
	 * 
	 * @return Stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Imposta lo Stage principale
	 * 
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Restituisce la View precedente
	 */
	public View getPreviousView() {
		return previous_view;
	}

	/**
	 * Imposta la View precedente
	 * 
	 * @param previous_view
	 */
	public void setPreviousView(View previous_view) {
		this.previous_view = previous_view;
	}

	/**
	 * Restitusce il Nodo genitore
	 */
	public Parent getParentNode() {
		return this.parent_node;
	}

	/**
	 * Restituisce la Scena della View
	 */
	public Scene getScene() {
		return this.scene;
	}

	/**
	 * Imposta la Scena della View
	 * 
	 * @param scene
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	/**
	 * Crea un Alert Dialog e rimane in attesa di essere consumato
	 * 
	 * @param type
	 * @param title
	 * @param header_text
	 * @return Optional<ButtonType>
	 */
	public Optional<ButtonType> mostraAlert(AlertType type, String title, String header_text, String content_text) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header_text);
		alert.setContentText(content_text);
		return alert.showAndWait();
	}

}
