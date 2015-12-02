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
public class VenditaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression impiegatoId;
	public final AssociationExpression impiegato;
	public final IntegerExpression servizioId;
	public final AssociationExpression servizio;
	public final IntegerExpression pagamentoId;
	public final AssociationExpression pagamento;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final DateExpression data;
	
	public VenditaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		impiegatoId = new IntegerExpression("impiegato.id", this);
		impiegato = new AssociationExpression("impiegato", this);
		servizioId = new IntegerExpression("servizio.id", this);
		servizio = new AssociationExpression("servizio", this);
		pagamentoId = new IntegerExpression("pagamento.id", this);
		pagamento = new AssociationExpression("pagamento", this);
		clienteId = new IntegerExpression("cliente.id", this);
		cliente = new AssociationExpression("cliente", this);
		data = new DateExpression("data", this);
	}
	
	public VenditaCriteria(PersistentSession session) {
		this(session.createCriteria(Vendita.class));
	}
	
	public VenditaCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public ImpiegatoCriteria createImpiegatoCriteria() {
		return new ImpiegatoCriteria(createCriteria("impiegato"));
	}
	
	public ServizioComponentCriteria createServizioCriteria() {
		return new ServizioComponentCriteria(createCriteria("servizio"));
	}
	
	public PagamentoCriteria createPagamentoCriteria() {
		return new PagamentoCriteria(createCriteria("pagamento"));
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("cliente"));
	}
	
	public Vendita uniqueVendita() {
		return (Vendita) super.uniqueResult();
	}
	
	public Vendita[] listVendita() {
		java.util.List list = super.list();
		return (Vendita[]) list.toArray(new Vendita[list.size()]);
	}
}

