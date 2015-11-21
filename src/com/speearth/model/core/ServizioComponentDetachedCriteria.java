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
import org.orm.criteria.*;

@SuppressWarnings({ "all", "unchecked" })
public class ServizioComponentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	
	public ServizioComponentDetachedCriteria() {
		super(com.speearth.model.core.ServizioComponent.class, com.speearth.model.core.ServizioComponentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
	}
	
	public ServizioComponentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.ServizioComponentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
	}
	
	public ServizioComponent uniqueServizioComponent(PersistentSession session) {
		return (ServizioComponent) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ServizioComponent[] listServizioComponent(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ServizioComponent[]) list.toArray(new ServizioComponent[list.size()]);
	}
}

