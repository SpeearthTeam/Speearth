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
public class AlloggioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression prezzo;
	public final StringExpression fornitore;
	public final StringExpression localita;
	public final DateExpression dataArrivo;
	public final DateExpression dataPartenza;
	public final CollectionExpression stanze;
	
	public AlloggioDetachedCriteria() {
		super(com.speearth.model.core.Alloggio.class, com.speearth.model.core.AlloggioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		localita = new StringExpression("localita", this.getDetachedCriteria());
		dataArrivo = new DateExpression("dataArrivo", this.getDetachedCriteria());
		dataPartenza = new DateExpression("dataPartenza", this.getDetachedCriteria());
		stanze = new CollectionExpression("stanze", this.getDetachedCriteria());
	}
	
	public AlloggioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.AlloggioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		fornitore = new StringExpression("fornitore", this.getDetachedCriteria());
		localita = new StringExpression("localita", this.getDetachedCriteria());
		dataArrivo = new DateExpression("dataArrivo", this.getDetachedCriteria());
		dataPartenza = new DateExpression("dataPartenza", this.getDetachedCriteria());
		stanze = new CollectionExpression("stanze", this.getDetachedCriteria());
	}
	
	public StanzaDetachedCriteria createStanzeCriteria() {
		return new StanzaDetachedCriteria(createCriteria("stanze"));
	}
	
	public Alloggio uniqueAlloggio(PersistentSession session) {
		return (Alloggio) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Alloggio[] listAlloggio(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Alloggio[]) list.toArray(new Alloggio[list.size()]);
	}
}

