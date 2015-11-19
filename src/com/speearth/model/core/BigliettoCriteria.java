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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.DateExpression;
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class BigliettoCriteria extends AbstractORMCriteria {
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
	
	public BigliettoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		prezzo = new FloatExpression("prezzo", this);
		fornitore = new StringExpression("fornitore", this);
		partenza = new StringExpression("partenza", this);
		destinazione = new StringExpression("destinazione", this);
		dataPartenzaAndata = new DateExpression("dataPartenzaAndata", this);
		dataPartenzaRitorno = new DateExpression("dataPartenzaRitorno", this);
		dataArrivoAndata = new DateExpression("dataArrivoAndata", this);
		dataArrivoRitorno = new DateExpression("dataArrivoRitorno", this);
		numeroAdulti = new IntegerExpression("numeroAdulti", this);
		numeroBambini = new IntegerExpression("numeroBambini", this);
		mezzo = new StringExpression("mezzo", this);
	}
	
	public BigliettoCriteria(PersistentSession session) {
		this(session.createCriteria(Biglietto.class));
	}
	
	public BigliettoCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public Biglietto uniqueBiglietto() {
		return (Biglietto) super.uniqueResult();
	}
	
	public Biglietto[] listBiglietto() {
		java.util.List list = super.list();
		return (Biglietto[]) list.toArray(new Biglietto[list.size()]);
	}
}

