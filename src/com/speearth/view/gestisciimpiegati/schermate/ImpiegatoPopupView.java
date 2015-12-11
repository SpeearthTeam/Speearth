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

/**
 * Popup per l'aggiunta o modifica dei dati di un Impiegato
 */
public class ImpiegatoPopupView extends View {
	@FXML
	private AnchorPane form_container;

	/**
	 * Form
	 */
	private FormView form;

	/**
	 * Impiegato
	 */
	private Impiegato impiegato;

	/**
	 * Costruttore
	 * 
	 * @param stage
	 * @param impiegato
	 * @throws IOException
	 */
	public ImpiegatoPopupView(Stage stage, Impiegato impiegato) throws IOException {
		super(stage);
		this.setImpiegato(impiegato);
		this.getRoot().addEventHandler(EventoGestioneImpiegato.AGGIUNGI_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						ImpiegatoPopupView.this.setImpiegato(event.getImpiegato());
						ImpiegatoPopupView.this.mostraAlert(AlertType.INFORMATION, Costanti.TITOLO_IMPIEGATO_AGGIUNTO, null,
								Costanti.MESSAGGIO_IMPIEGATO_AGGIUNTO);
					}
				});
		this.getRoot().addEventHandler(EventoGestioneImpiegato.MODIFICA_IMPIEGATO,
				new EventHandler<EventoGestioneImpiegato>() {
					@Override
					public void handle(EventoGestioneImpiegato event) {
						ImpiegatoPopupView.this.setImpiegato(event.getImpiegato());
					}
				});
		try {
			if (impiegato == null) {
				this.form = new AggiungiImpiegatoForm(this.getStage());
				this.form_container.getChildren().add(this.form.getRoot());
				this.getStage().setTitle(Costanti.TITOLO_AGGIUNGI_IMPIEGATO);
			} else {
				this.form = new ModificaImpiegatoForm(this.getStage(), impiegato);
				this.form_container.getChildren().add(this.form.getRoot());
				this.getStage().setTitle(Costanti.TITOLO_MODIFICA_IMPIEGATO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inizializza la View
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.getStage().setHeight(Costanti.DIMENSIONE_ALTEZZA_POPUP_IMPIEGATO);
		this.getStage().setWidth(Costanti.DIMENSIONE_LARGHEZZA_POPUP_IMPIEGATO);
		this.getStage().setResizable(false);
	}

	/**
	 * Imposta l'Impiegato
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
		return this.impiegato;
	}

	/**
	 * Restituisce il nome della Risorsa associata alla View
	 * 
	 * @return String
	 */
	@Override
	public String getNomeRisorsa() {
		return Costanti.FXML_IMPIEGATO_POPUP;
	}
}
