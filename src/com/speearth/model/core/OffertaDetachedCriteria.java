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
public class OffertaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final CollectionExpression listaServizi;
	public final DateExpression dataInizio;
	public final DateExpression dataFine;
	
	public OffertaDetachedCriteria() {
		super(com.speearth.model.core.Offerta.class, com.speearth.model.core.OffertaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		listaServizi = new CollectionExpression("listaServizi", this.getDetachedCriteria());
		dataInizio = new DateExpression("dataInizio", this.getDetachedCriteria());
		dataFine = new DateExpression("dataFine", this.getDetachedCriteria());
	}
	
	public OffertaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.OffertaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		listaServizi = new CollectionExpression("listaServizi", this.getDetachedCriteria());
		dataInizio = new DateExpression("dataInizio", this.getDetachedCriteria());
		dataFine = new DateExpression("dataFine", this.getDetachedCriteria());
	}
	
	public ServizioComponentDetachedCriteria createListaServiziCriteria() {
		return new ServizioComponentDetachedCriteria(createCriteria("listaServizi"));
	}
	
	public Offerta uniqueOfferta(PersistentSession session) {
		return (Offerta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Offerta[] listOfferta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Offerta[]) list.toArray(new Offerta[list.size()]);
	}
}

