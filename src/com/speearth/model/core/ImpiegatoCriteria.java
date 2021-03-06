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
public class ImpiegatoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression username;
	public final StringExpression password;
	public final DateExpression dataNascita;
	public final StringExpression codiceFiscale;
	public final StringExpression ruolo;
	public final FloatExpression stipendio;
	
	public ImpiegatoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		dataNascita = new DateExpression("dataNascita", this);
		codiceFiscale = new StringExpression("codiceFiscale", this);
		ruolo = new StringExpression("ruolo", this);
		stipendio = new FloatExpression("stipendio", this);
	}
	
	public ImpiegatoCriteria(PersistentSession session) {
		this(session.createCriteria(Impiegato.class));
	}
	
	public ImpiegatoCriteria() throws PersistentException {
		this(com.speearth.model.core.SpeearthPersistentManager.instance().getSession());
	}
	
	public Impiegato uniqueImpiegato() {
		return (Impiegato) super.uniqueResult();
	}
	
	public Impiegato[] listImpiegato() {
		java.util.List list = super.list();
		return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
	}
}

