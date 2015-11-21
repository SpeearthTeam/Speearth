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
public class PagamentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression ammontare;
	public final StringExpression metodo;
	public final DateExpression data;
	
	public PagamentoDetachedCriteria() {
		super(com.speearth.model.core.Pagamento.class, com.speearth.model.core.PagamentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ammontare = new FloatExpression("ammontare", this.getDetachedCriteria());
		metodo = new StringExpression("metodo", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public PagamentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.PagamentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ammontare = new FloatExpression("ammontare", this.getDetachedCriteria());
		metodo = new StringExpression("metodo", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public Pagamento uniquePagamento(PersistentSession session) {
		return (Pagamento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pagamento[] listPagamento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pagamento[]) list.toArray(new Pagamento[list.size()]);
	}
}

