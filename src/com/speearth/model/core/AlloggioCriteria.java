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
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.DateExpression;
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class AlloggioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final StringExpression fornitore;
	public final StringExpression localita;
	public final DateExpression dataArrivo;
	public final DateExpression dataPartenza;
	public final CollectionExpression stanze;
	
	public AlloggioCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		prezzo = new FloatExpression("prezzo", this);
		fornitore = new StringExpression("fornitore", this);
		localita = new StringExpression("localita", this);
		dataArrivo = new DateExpression("dataArrivo", this);
		dataPartenza = new DateExpression("dataPartenza", this);
		stanze = new CollectionExpression("stanze", this);
	}
	
	public AlloggioCriteria(PersistentSession session) {
		this(session.createCriteria(Alloggio.class));
	}
	
	public AlloggioCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public StanzaCriteria createStanzeCriteria() {
		return new StanzaCriteria(createCriteria("stanze"));
	}
	
	public Alloggio uniqueAlloggio() {
		return (Alloggio) super.uniqueResult();
	}
	
	public Alloggio[] listAlloggio() {
		java.util.List list = super.list();
		return (Alloggio[]) list.toArray(new Alloggio[list.size()]);
	}
}

