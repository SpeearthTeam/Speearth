package com.speearth.view;

import java.io.IOException;
import java.util.Optional;

import com.speearth.utility.Costanti;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe che rappresenta una schermata dell'Applicazione
 */
public abstract class View implements Initializable {

	/**
	 * Attributo che serve alla gestione del caricamento delle risorse di JavaFX
	 */
	private FXMLLoader loader;

	/**
	 * Attributo che contiene lo stage (che viene passato dal Main)
	 */
	protected Stage stage;

	/**
	 * Attributo che sta a capo dell'albero con cui JavaFX gestisce gli elementi
	 * grafici
	 */
	protected Parent root;

	/**
	 * Attributo che associa la schermata di ogni view specifica
	 */
	protected Scene scene;

	/**
	 * Costruttore di default
	 */
	public View() {

	}

	/**
	 * Costruttore della View
	 * 
	 * @param stage
	 * @throws IOException
	 */
	public View(Stage stage) throws IOException {
		loader = new FXMLLoader();
		String path = getResourceName();
		loader = new FXMLLoader(getClass().getResource(path));
		loader.setController(this);
		this.stage = stage;
		root = (Parent) loader.load();
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				Optional<ButtonType> result = mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_CHIUDI, Costanti.MESSAGGIO_CHIUDI,
						Costanti.MESSAGGIO_CHIUSURA_SESSIONE);
				if (result.get() == ButtonType.OK)
					stage.close();
				else we.consume();
			}
		});
	}

	/**
	 * Ritorna lo stage
	 * 
	 * @return Stage stage
	 */
	public Stage getStage() {
		return this.stage;
	}

	/**
	 * Imposta la schermata (scene) contenuta nella finestra (stage)
	 * 
	 * (Se già esiste vuol dire che ci troviamo in una SubView e non la crea;
	 * non la deve creare.)
	 */
	protected void setScene() {
		if (scene == null) {
			scene = new Scene(root, 1280, 720);
		}
		stage.setScene(scene);
	}

	/**
	 * Mostra la view
	 */
	public void mostra() {
		setScene();
		stage.show();
	}
	
	/**
	 * Alternativa apposita per i Popup
	 */
	public void mostraEAspetta() {
		setScene();
		stage.showAndWait();
	}

	/**
	 * Ritorna l'oggetto root che sta a capo dell'albero
	 * 
	 * @return Parent root
	 */
	public Parent getRoot() {
		return loader.getRoot();
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	public abstract String getResourceName();

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
	
	/**
	 * Aggiorna l'interfaccia grafica della subview
	 */
	public void updateUI() {
		
	}

}
