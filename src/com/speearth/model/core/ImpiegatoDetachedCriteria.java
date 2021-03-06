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
public class ImpiegatoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression username;
	public final StringExpression password;
	public final DateExpression dataNascita;
	public final StringExpression codiceFiscale;
	public final StringExpression ruolo;
	public final FloatExpression stipendio;
	
	public ImpiegatoDetachedCriteria() {
		super(com.speearth.model.core.Impiegato.class, com.speearth.model.core.ImpiegatoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		ruolo = new StringExpression("ruolo", this.getDetachedCriteria());
		stipendio = new FloatExpression("stipendio", this.getDetachedCriteria());
	}
	
	public ImpiegatoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.speearth.model.core.ImpiegatoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		ruolo = new StringExpression("ruolo", this.getDetachedCriteria());
		stipendio = new FloatExpression("stipendio", this.getDetachedCriteria());
	}
	
	public Impiegato uniqueImpiegato(PersistentSession session) {
		return (Impiegato) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Impiegato[] listImpiegato(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Impiegato[]) list.toArray(new Impiegato[list.size()]);
	}
}

