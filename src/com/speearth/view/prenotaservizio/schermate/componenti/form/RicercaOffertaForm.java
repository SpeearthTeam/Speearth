package com.speearth.view.prenotaservizio.schermate.componenti.form;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.speearth.controller.AppFacadeController;
import com.speearth.model.core.Offerta;
import com.speearth.model.core.ServizioComponent;
import com.speearth.utility.Costanti;
import com.speearth.view.FormView;
import com.speearth.view.prenotaservizio.schermate.componenti.OffertaListItem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RicercaOffertaForm extends FormView {
	@FXML
	private TextField input_ricerca_offerta;
	@FXML
	private ListView<Offerta> output_lista_offerte;

	private ObservableList<Offerta> offerte = FXCollections.observableArrayList();

	private ListView<ServizioComponent> output_lista_servizi;

	public RicercaOffertaForm(Stage stage) throws IOException {
		super(stage);
	}

	/**
	 * Inizializza la View
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.offerte = FXCollections.observableArrayList();
		this.output_lista_offerte.setCellFactory(param -> new OffertaListItem(getStage()));
		this.output_lista_offerte.setItems(this.offerte);
		this.offerte.setAll(AppFacadeController.getInstance().getPrenotaServizioController()
				.getAcquistaOffertaController().cercaOfferta(null));
		this.input_ricerca_offerta.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				RicercaOffertaForm.this.offerte.setAll(AppFacadeController.getInstance().getPrenotaServizioController()
						.getAcquistaOffertaController().cercaOfferta(newValue));
			}
		});
	}

	@Override
	public void updateUI() {

	}

	public void bind(ListView<ServizioComponent> view, Offerta offerta) {
		this.output_lista_servizi = view;
		this.output_lista_servizi.setItems((ObservableList<ServizioComponent>) offerta.getListaServizi());
	}

	@Override
	public String getResourceName() {
		return Costanti.FXML_RICERCA_OFFERTA_FORM;
	}

	/**
	 * Non necessario
	 */
	@Override
	public void validate() {
	}

	/**
	 * Non necessario
	 */
	@Override
	public HashMap<String, String> getParameters() {
		return null;
	}

	/**
	 * Non necessario
	 */
	@Override
	public void send(HashMap<String, String> parameters) throws IOException {
	}

}
