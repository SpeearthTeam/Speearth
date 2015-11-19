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
public class PagamentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression ammontare;
	public final StringExpression metodo;
	public final DateExpression data;
	
	public PagamentoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		ammontare = new FloatExpression("ammontare", this);
		metodo = new StringExpression("metodo", this);
		data = new DateExpression("data", this);
	}
	
	public PagamentoCriteria(PersistentSession session) {
		this(session.createCriteria(Pagamento.class));
	}
	
	public PagamentoCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public Pagamento uniquePagamento() {
		return (Pagamento) super.uniqueResult();
	}
	
	public Pagamento[] listPagamento() {
		java.util.List list = super.list();
		return (Pagamento[]) list.toArray(new Pagamento[list.size()]);
	}
}

