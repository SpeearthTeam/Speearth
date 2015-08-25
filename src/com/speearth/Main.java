package com.speearth;

import com.speearth.view.prenotaservizio.ScegliServizioView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	/**
	 * Stage primario dell'applicazione
	 */
	private Stage primaryStage;
	
	/**
	 * Avvia l'Applicazione
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Speearth");
		
		initRootLayout();
	}
	
	/**
	 * Inizializza il layout di root con il quale
	 * si sceglie l'operazione da compiere
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ui/fxml/ScegliServizio.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Restituisce lo stage primario
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
