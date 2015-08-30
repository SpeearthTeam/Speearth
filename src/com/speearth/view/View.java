package com.speearth.view;

import java.io.IOException;
import java.util.Optional;

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
	 * Stage della view
	 */
	protected Stage stage;
	
	/**
	 * View precedente
	 */
	protected View previous_view;
	
	/**
	 * Nodo genitore della view
	 */
	protected Parent parent_node;
	
	/**
	 * Scena corrente
	 */
	protected Scene scene;
	
	/**
	 * Costruttore della view
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
	 * Restituisce il nome della risorsa associata alla view
	 */
	public abstract String getResourceName();
	
	/**
	 * Mostra la view
	 */
	public void mostra() {
		getStage().setScene(getScene());
		getStage().show();
	}
	
	/**
	 * Mostra la view precedente
	 */
	public void mostraPrecedente() {
		if (getPreaviousView() == null)
			mostraAlert(AlertType.ERROR, "Errore", "Non esiste una view precedente");
		else
			getPreaviousView().mostra();
	}
		
	/**
	 * Restituisce lo stage principale 
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Imposta lo stage principale
	 * 
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Restituisce la view precedente 
	 */
	public View getPreaviousView() {
		return previous_view;
	}
	
	/**
	 * Imposta la view precedente
	 * 
	 * @param preavious_view
	 */
	public void setPreaviousView(View preavious_view) {
		this.previous_view = preavious_view;
	}
	
	/**
	 * Restitusce il nodo genitore
	 */
	public Parent getParentNode() {
		return parent_node;
	}
	
	/**
	 * Restituisce la singola istanza della scena della view
	 */
	public Scene getScene() {
		if (scene == null)
			scene = new Scene(parent_node);
		return scene;
	}
	
	/**
	 * Imposta la singola scena della view
	 * 
	 * @param scene
	 */
	public void setScene(Scene scene) {
		if (scene == null)
			this.scene = scene;
	}
	
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
	
}
