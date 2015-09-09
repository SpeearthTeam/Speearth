package com.speearth;

import com.speearth.view.prenotaservizio.ScegliServizioView;

import javafx.application.Application;
import javafx.scene.image.Image;
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
		ScegliServizioView view = new ScegliServizioView(primaryStage);
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/ui/img/icona_app.png")));
		view.mostra();
	}

}
