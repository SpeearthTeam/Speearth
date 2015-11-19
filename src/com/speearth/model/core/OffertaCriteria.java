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

@SuppressWarnings({ "all", "unchecked" })
public class OffertaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final CollectionExpression listaServizi;
	public final DateExpression dataInizio;
	public final DateExpression dataFine;
	
	public OffertaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		prezzo = new FloatExpression("prezzo", this);
		listaServizi = new CollectionExpression("listaServizi", this);
		dataInizio = new DateExpression("dataInizio", this);
		dataFine = new DateExpression("dataFine", this);
	}
	
	public OffertaCriteria(PersistentSession session) {
		this(session.createCriteria(Offerta.class));
	}
	
	public OffertaCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public ServizioComponentCriteria createListaServiziCriteria() {
		return new ServizioComponentCriteria(createCriteria("listaServizi"));
	}
	
	public Offerta uniqueOfferta() {
		return (Offerta) super.uniqueResult();
	}
	
	public Offerta[] listOfferta() {
		java.util.List list = super.list();
		return (Offerta[]) list.toArray(new Offerta[list.size()]);
	}
}

