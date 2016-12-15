package com.mockers.dao;

import java.util.Collection;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mockers.model.Person;

@Repository
@Transactional
@Qualifier("mysql")
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	SessionFactory sessionFactory;

       
	@Override
	public void save(Person p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p);
		
	}


	@Override
	public Collection<Person> list() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from Person");
		query.addEntity(Person.class);
		return query.list();
	}

}
