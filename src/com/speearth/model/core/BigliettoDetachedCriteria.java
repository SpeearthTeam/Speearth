/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.speearth.model.core;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.DateExpression;
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class BigliettoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final StringExpression fornitore;
	public final StringExpression partenza;
	public final StringExpression destinazione;
	public final DateExpression dataPartenzaAndata;
	public final DateExpression dataPartenzaRitorno;
	public final DateExpression dataArrivoAndata;
	public final DateExpression dataArrivoRitorno;
	public final IntegerExpression numeroAdulti;
	public final IntegerExpression numeroBambini;
	public final StringExpression mezzo;
	
	public BigliettoDetachedCriteria() {
		super(com.speearth.model.core.Biglietto.class, com.speearth.model.core.BigliettoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		partenza = new StringExpression("partenza", this.getDetachedCriteria());
		destinazione = new StringExpression("destinazione", this.getDetachedCriteria());
		dataPartenzaAndata = new DateExpression("dataPartenzaAndata", this.getDetachedCriteria());
		dataPartenzaRitorno = new DateExpression("dataPartenzaRitorno", this.getDetachedCriteria());
		dataArrivoAndata = new DateExpression("dataArrivoAndata", this.getDetachedCriteria());
		dataArrivoRitorno = new DateExpression("dataArrivoRitorno", this.getDetachedCriteria());
		numeroAdulti = new IntegerExpression("numeroAdulti", this.getDetachedCriteria());
		numeroBambini = new IntegerExpression("numeroBambini", this.getDetachedCriteria());
		mezzo = new StringExpression("mezzo", this.getDetachedCriteria());
	}
	
	public BigliettoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.BigliettoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		partenza = new StringExpression("partenza", this.getDetachedCriteria());
		destinazione = new StringExpression("destinazione", this.getDetachedCriteria());
		dataPartenzaAndata = new DateExpression("dataPartenzaAndata", this.getDetachedCriteria());
		dataPartenzaRitorno = new DateExpression("dataPartenzaRitorno", this.getDetachedCriteria());
		dataArrivoAndata = new DateExpression("dataArrivoAndata", this.getDetachedCriteria());
		dataArrivoRitorno = new DateExpression("dataArrivoRitorno", this.getDetachedCriteria());
		numeroAdulti = new IntegerExpression("numeroAdulti", this.getDetachedCriteria());
		numeroBambini = new IntegerExpression("numeroBambini", this.getDetachedCriteria());
		mezzo = new StringExpression("mezzo", this.getDetachedCriteria());
	}
	
	public Biglietto uniqueBiglietto(PersistentSession session) {
		return (Biglietto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Biglietto[] listBiglietto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Biglietto[]) list.toArray(new Biglietto[list.size()]);
	}
}

