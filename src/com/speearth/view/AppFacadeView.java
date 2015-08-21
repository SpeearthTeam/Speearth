package com.speearth.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppFacadeView extends Application {
	/**
	 * Istanza della classe
	 */
	private static AppFacadeView instance;

	/**
	 * Stage primario
	 */
	private Stage stage_primario;

	/**
	 * Layout radice
	 */
	private BorderPane root_layout;

	/**
	 * Costruttore di default
	 */
	private AppFacadeView() {
	}

	/**
	 * Restituisce la singola istanza della classe
	 * 
	 * @return AppFacadeView
	 */
	public static AppFacadeView getInstance() {
		if (instance == null)
			instance = new AppFacadeView();
		return instance;
	}

	/**
	 * Avvia l'Interfaccia
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
	 * 
	 * 
	 * @return Stage
	 */
	public Stage getStagePrimario() {
		return stage_primario;
	}

	/**
	 * 
	 * 
	 * @param stage_primario
	 */
	public void setStagePrimario(Stage stage_primario) {
		this.stage_primario = stage_primario;
	}

	/**
	 * 
	 * 
	 * @return BorderPane
	 */
	public BorderPane getRootLayout() {
		return root_layout;
	}

	/**
	 * 
	 * 
	 * @param root_layout
	 */
	public void setRootLayout(BorderPane root_layout) {
		this.root_layout = root_layout;
	}

}
