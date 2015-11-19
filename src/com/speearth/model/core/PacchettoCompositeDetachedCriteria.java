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
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;

@SuppressWarnings({ "all", "unchecked" })
public class PacchettoCompositeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final CollectionExpression listaServizi;
	
	public PacchettoCompositeDetachedCriteria() {
		super(com.speearth.model.core.PacchettoComposite.class, com.speearth.model.core.PacchettoCompositeCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		listaServizi = new CollectionExpression("listaServizi", this.getDetachedCriteria());
	}
	
	public PacchettoCompositeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.PacchettoCompositeCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		listaServizi = new CollectionExpression("listaServizi", this.getDetachedCriteria());
	}
	
	public ServizioComponentDetachedCriteria createListaServiziCriteria() {
		return new ServizioComponentDetachedCriteria(createCriteria("listaServizi"));
	}
	
	public PacchettoComposite uniquePacchettoComposite(PersistentSession session) {
		return (PacchettoComposite) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PacchettoComposite[] listPacchettoComposite(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PacchettoComposite[]) list.toArray(new PacchettoComposite[list.size()]);
	}
}

