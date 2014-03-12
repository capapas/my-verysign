package org.esgi.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

@Transactional
public abstract class AbstractDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected AbstractDao() {
		super();
	}

	public final T persist(T p) {
		getCurrentSession().persist(p);
		return p;
	}

	public final T merge(T detachedInstance) {
		getCurrentSession().merge(detachedInstance);
		return detachedInstance;
	}

	public final T saveOrUpdate(T detachedInstance) {
		getCurrentSession().saveOrUpdate(detachedInstance);
		return detachedInstance;
	}

	public final void save(T p) {
		getCurrentSession().save(p);
	}

	public final void delete(T p) {
		getCurrentSession().delete(p);
	}
	
	@Transactional(readOnly = true)
	protected Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
