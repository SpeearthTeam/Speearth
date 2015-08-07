package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppFacadeView extends Application {
	/**
	 * Stage primario
	 */
	private Stage stage_primario;

	/**
	 * Layout radice
	 */
	private BorderPane root_layout;

	/**
	 * Avvia l'interfaccia dell'Applicazione
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.stage_primario = stage;
		this.stage_primario.setTitle("Speearth");

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("../res/ui/fxml/Root.fxml"));
		this.root_layout = (BorderPane) loader.load();

		Scene scena = new Scene(this.root_layout);
		this.stage_primario.setScene(scena);
		this.stage_primario.show();
	}

	/**
	 * Restituisce lo Stage rimario
	 * 
	 * @return Stage
	 */
	public Stage getStage_primario() {
		return stage_primario;
	}

	/**
	 * Imposta lo Stage primario
	 * 
	 * @param stage_primario
	 */
	public void setStage_primario(Stage stage_primario) {
		this.stage_primario = stage_primario;
	}

	/**
	 * Restituisce il Layout radice
	 * 
	 * @return BorderPane
	 */
	public BorderPane getRootLayout() {
		return root_layout;
	}

	/**
	 * Imposta il Layout radice
	 * 
	 * @param root_layout
	 */
	public void setRootLayout(BorderPane root_layout) {
		this.root_layout = root_layout;
	}

}
