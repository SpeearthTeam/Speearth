package model.ricerca;

import java.util.ArrayList;
import java.util.HashMap;

import model.core.IServizioComponent;

/**
 * Classe rappresentante un comando di ricerca alloggi verso un'impresa ricettiva
 */
public class RicercaAlloggiCommand implements IRicercaCommand {
	/**
	 * Oggetto che deve eseguire il comando
	 */
	private RicercaReceiver receiver;

	/**
	 * Parametri di ricerca
	 */
	private HashMap<String, String> parametri;

	/**
	 * Costruttore completo
	 * 
	 * @param receiver
	 * @param parametri
	 */
	public RicercaAlloggiCommand(RicercaReceiver receiver, HashMap<String, String> parametri) {
		this.receiver = receiver;
		this.parametri = parametri;
	}
	
	/**
	 * Restituisce il receiver
	 * 
	 * @return RicercaReceiver
	 */
	public RicercaReceiver getReceiver() {
		return this.receiver;
	}
	
	/**
	 * Imposta il receiver
	 * 
	 * @param receiver
	 */
	public void setReceiver(RicercaReceiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Restituisce i parametri
	 * 
	 * @return HashMap<String, String>
	 */
	public HashMap<String, String> getParametri() {
		return this.parametri;
	}
	
	/**
	 * Imposta i parametri
	 * 
	 * @param parametri
	 */
	public void setParametri(HashMap<String, String> parametri) {
		this.parametri = parametri;
	}

	@Override
	public ArrayList<IServizioComponent> esegui() {
//		ArrayList<ServizioComponent> servizi = new ArrayList<ServizioComponent>();
//		ArrayList<Alloggio> alloggi = this.receiver.ricercaAlloggi(this.parametri);
//		
//		for (Alloggio alloggio : alloggi)
//			servizi.add(alloggio);
//		
//		return servizi;
		return this.receiver.ricercaAlloggi(this.parametri);
	}

}