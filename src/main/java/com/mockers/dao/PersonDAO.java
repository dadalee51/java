package com.mockers.dao;

import java.util.Collection;

import com.mockers.model.Person;


public interface PersonDAO {

	public void save(Person p);
	
	public Collection<Person> list();
	
}