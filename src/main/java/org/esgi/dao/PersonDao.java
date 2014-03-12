package org.esgi.dao;

import java.util.List;

import org.esgi.dao.impl.AbstractDao;
import org.esgi.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao extends AbstractDao<Person> {

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final List<Person> findAll() {
		return getCurrentSession().createQuery("FROM Person ORDER BY name")
				.list();
	}

	/**
	 * 
	 * @return
	 */
	public final int countAll() {
		return findAll().size();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final Person findByName(String name) {
		List<Person> person = getCurrentSession().createQuery(
				"FROM Person WHERE username = '" + name + "'").list();
		return person.get(0);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final Person findById(int id) {
		List<Person> person = getCurrentSession().createQuery(
				"FROM Person WHERE id = " + id).list();
		return person.get(0);
	}
}