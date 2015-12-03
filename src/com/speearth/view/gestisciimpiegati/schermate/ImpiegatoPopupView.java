package com.speearth.view.gestisciimpiegati.schermate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.speearth.model.core.Impiegato;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.View;
import com.speearth.view.eventi.EventoGestioneImpiegato;
import com.speearth.view.gestisciimpiegati.schermate.componenti.form.AggiungiImpiegatoForm;
import com.speearth.view.gestisciimpiegati.schermate.componenti.form.ModificaImpiegatoForm;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ImpiegatoPopupView extends View {
	@FXML
	private AnchorPane form_container;

	/**
	 * Form di salvataggio dell'Impiegato
	 */
	private FormView form;

	/**
	 * Impiegato
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore di default
	 * 
	 * @param stage
	 * @param previousView
	 * @param impiegato
	 * @throws IOException
	 */
	public ImpiegatoPopupView(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		setImpiegato(impiegato);
		getRoot().addEventHandler(EventoGestioneImpiegato.AGGIUNGI_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						setImpiegato(event.getImpiegato());
						mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_IMPIEGATO_AGGIUNTO, null,
								Costanti.MESSAGGIO_IMPIEGATO_AGGIUNTO);
					}
				});

		getRoot().addEventHandler(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						setImpiegato(event.getImpiegato());
					}
				});

		try {
			if (impiegato == null) {
				form = new AggiungiImpiegatoForm(getStage(), impiegato);
				form_container.getChildren().add(form.getRoot());
				getStage().setTitle(Costanti.TITOLO_AGGIUNGI_IMPIEGATO);
			} else {
				form = new ModificaImpiegatoForm(getStage(), impiegato);
				form_container.getChildren().add(form.getRoot());
				getStage().setTitle(Costanti.TITOLO_MODIFICA_IMPIEGATO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inizializza la view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getStage().setHeight(Costanti.DIMENSIONE_ALTEZZA_POPUP_IMPIEGATO);
		getStage().setWidth(Costanti.DIMENSIONE_LARGHEZZA_POPUP_IMPIEGATO);
		getStage().setResizable(false);
	}

	/**
	 * Imposta il Impiegato
	 * 
	 * @param impiegato
	 */
	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	/**
	 * Restituisce il Impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}

	/**
	 * Restituisce la risorsa associata alla view
	 */
	@Override
	public String getResourceName() {
		return Costanti.FXML_IMPIEGATO_POPUP;
	}
}
