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
import org.orm.criteria.*;

@SuppressWarnings({ "all", "unchecked" })
public class StanzaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipologia;
	public final IntegerExpression quantita;
	
	public StanzaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipologia = new StringExpression("tipologia", this);
		quantita = new IntegerExpression("quantita", this);
	}
	
	public StanzaCriteria(PersistentSession session) {
		this(session.createCriteria(Stanza.class));
	}
	
	public StanzaCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public Stanza uniqueStanza() {
		return (Stanza) super.uniqueResult();
	}
	
	public Stanza[] listStanza() {
		java.util.List list = super.list();
		return (Stanza[]) list.toArray(new Stanza[list.size()]);
	}
}

