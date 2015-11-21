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
public class VenditaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression impiegatoId;
	public final AssociationExpression impiegato;
	public final IntegerExpression servizioComponentId;
	public final AssociationExpression servizioComponent;
	public final IntegerExpression pagamentoId;
	public final AssociationExpression pagamento;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final DateExpression data;
	
	public VenditaDetachedCriteria() {
		super(com.speearth.model.core.Vendita.class, com.speearth.model.core.VenditaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		impiegatoId = new IntegerExpression("impiegato.id", this.getDetachedCriteria());
		impiegato = new AssociationExpression("impiegato", this.getDetachedCriteria());
		servizioComponentId = new IntegerExpression("servizioComponent.id", this.getDetachedCriteria());
		servizioComponent = new AssociationExpression("servizioComponent", this.getDetachedCriteria());
		pagamentoId = new IntegerExpression("pagamento.id", this.getDetachedCriteria());
		pagamento = new AssociationExpression("pagamento", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.id", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public VenditaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.VenditaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		impiegatoId = new IntegerExpression("impiegato.id", this.getDetachedCriteria());
		impiegato = new AssociationExpression("impiegato", this.getDetachedCriteria());
		servizioComponentId = new IntegerExpression("servizioComponent.id", this.getDetachedCriteria());
		servizioComponent = new AssociationExpression("servizioComponent", this.getDetachedCriteria());
		pagamentoId = new IntegerExpression("pagamento.id", this.getDetachedCriteria());
		pagamento = new AssociationExpression("pagamento", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.id", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public ImpiegatoDetachedCriteria createImpiegatoCriteria() {
		return new ImpiegatoDetachedCriteria(createCriteria("impiegato"));
	}
	
	public ServizioComponentDetachedCriteria createServizioComponentCriteria() {
		return new ServizioComponentDetachedCriteria(createCriteria("servizioComponent"));
	}
	
	public PagamentoDetachedCriteria createPagamentoCriteria() {
		return new PagamentoDetachedCriteria(createCriteria("pagamento"));
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public Vendita uniqueVendita(PersistentSession session) {
		return (Vendita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Vendita[] listVendita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Vendita[]) list.toArray(new Vendita[list.size()]);
	}
}

