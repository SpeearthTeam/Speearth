package com.speearth;

import com.speearth.controller.AppFacadeController;
import com.speearth.utility.Costanti;
import com.speearth.view.LoginView;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe di lancio dell'Applicazione
 */
public class Main extends Application {
	/**
	 * Avvia l'Applicazione
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AppFacadeController.getInstance().getStartupController().generaPreCondizioni();
		launch(args);
	}

	/**
	 * Lancia l'Interfaccia grafica
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream(Costanti.ICONA_SPEEARTH)));
		LoginView view = new LoginView(primaryStage);
		view.mostra();
	}
}
