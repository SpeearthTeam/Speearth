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
public class ServizioComponentCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	
	public ServizioComponentCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		prezzo = new FloatExpression("prezzo", this);
	}
	
	public ServizioComponentCriteria(PersistentSession session) {
		this(session.createCriteria(ServizioComponent.class));
	}
	
	public ServizioComponentCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public ServizioComponent uniqueServizioComponent() {
		return (ServizioComponent) super.uniqueResult();
	}
	
	public ServizioComponent[] listServizioComponent() {
		java.util.List list = super.list();
		return (ServizioComponent[]) list.toArray(new ServizioComponent[list.size()]);
	}
}

