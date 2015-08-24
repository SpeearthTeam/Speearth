package com.speearth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
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
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ui/fxml/Root.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Speearth");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
