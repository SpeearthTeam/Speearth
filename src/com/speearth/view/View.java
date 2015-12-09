package com.speearth.view;

import java.io.IOException;
import java.util.Optional;

import com.speearth.utility.Costanti;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Classe che rappresenta una Schermata dell'Applicazione
 */
public abstract class View implements Initializable {
	/**
	 * Gestore del caricamento delle risorse di JavaFX
	 */
	private FXMLLoader loader;

	/**
	 * Stage (contenuto globale della Finestra)
	 */
	protected Stage stage;

	/**
	 * Radice dell'albero degli elementi grafici
	 */
	protected Parent root;

	/**
	 * Scena (Schermata)
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
		String path = getNomeRisorsa();
		this.loader = new FXMLLoader(getClass().getResource(path));
		this.loader.setController(this);
		this.stage = stage;
		if (this.stage.isMaximized())
			this.massimizzaFinestra();
		this.root = (Parent) this.loader.load();
		this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				Optional<ButtonType> result = View.this.mostraAlert(AlertType.CONFIRMATION, Costanti.TITOLO_CHIUDI,
						Costanti.MESSAGGIO_CHIUDI, Costanti.MESSAGGIO_CHIUSURA_SESSIONE);
				if (result.get() == ButtonType.OK)
					stage.close();
				else
					we.consume();
			}
		});
	}

	/**
	 * Restituisce lo Stage
	 * 
	 * @return Stage
	 */
	public Stage getStage() {
		return this.stage;
	}

	/**
	 * Imposta la Scena nello Stage. Nel caso in cui sia già presente (Subview)
	 * non ne crea una nuova
	 */
	protected void setScene() {
		if (this.scene == null)
			this.scene = new Scene(this.root, Costanti.DIMENSIONE_LARGHEZZA_FINESTRA,
					Costanti.DIMENSIONE_ALTEZZA_FINESTRA);
		this.stage.setScene(this.scene);
		this.scene.getStylesheets().add(Costanti.URL_STILE);
	}

	/**
	 * Mostra la View
	 */
	public void mostra() {
		this.setScene();
		this.stage.show();
	}

	/**
	 * Alternativa apposita per i Popup
	 */
	public void mostraEAspetta() {
		this.setScene();
		this.stage.showAndWait();
	}

	/**
	 * Restituisce la Root
	 * 
	 * @return Parent
	 */
	public Parent getRoot() {
		return this.loader.getRoot();
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	public abstract String getNomeRisorsa();

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
	 * Massimizza la Finestra della View
	 */
	private void massimizzaFinestra() {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		this.stage.setX(bounds.getMinX());
		this.stage.setY(bounds.getMinY());
		this.stage.setWidth(bounds.getWidth());
		this.stage.setHeight(bounds.getHeight());
	}

	/**
	 * Aggiorna le informazioni mostrate dall'Interfaccia
	 */
	public void aggiornaUI() {
	}
}
