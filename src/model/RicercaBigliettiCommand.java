package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe rappresentante un comando di ricerca biglietti verso un'azienda di trasporto
 */
public class RicercaBigliettiCommand implements RicercaCommand {
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
	public RicercaBigliettiCommand(RicercaReceiver receiver, HashMap<String, String> parametri) {
		setReceiver(receiver);
		setParametri(parametri);
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
	public ArrayList<ServizioComponent> esegui() {
		ArrayList<ServizioComponent> servizi = new ArrayList<ServizioComponent>();
		ArrayList<Biglietto> biglietti = this.receiver.ricercaBiglietti(this.parametri);
		
		for (Biglietto biglietto : biglietti)
			servizi.add(biglietto);
		
		return servizi;
	}

}