package com.speearth;

import com.speearth.view.prenotaservizio.schermate.ScegliServizioView;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Avvia l'Applicazione
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

//		SessionFactory factory = Costanti.createSessionFactory();
//		Session s = factory.openSession();
//		Transaction tx = s.beginTransaction();
//
//		Date d = Costanti.FORMATO_DATA.parse("19-11-2015");
//		Cliente c = new Cliente("lol", "lol", d, "lol123", 987654321);
//
//		s.save(c);
//
//		tx.commit();
//		s.close();

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScegliServizioView view = new ScegliServizioView(primaryStage);
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/ui/img/icona_app.png")));
		view.mostra();
	}

}
