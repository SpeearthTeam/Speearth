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
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class StanzaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipologia;
	public final IntegerExpression quantita;
	
	public StanzaDetachedCriteria() {
		super(com.speearth.model.core.Stanza.class, com.speearth.model.core.StanzaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipologia = new StringExpression("tipologia", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
	}
	
	public StanzaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.StanzaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipologia = new StringExpression("tipologia", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
	}
	
	public Stanza uniqueStanza(PersistentSession session) {
		return (Stanza) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Stanza[] listStanza(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Stanza[]) list.toArray(new Stanza[list.size()]);
	}
}

