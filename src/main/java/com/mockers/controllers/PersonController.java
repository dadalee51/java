package com.mockers.controllers;



import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mockers.dao.PersonDAO;
import com.mockers.model.Person;

@RestController
@RequestMapping("/hello")
public class PersonController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	@Qualifier("mysql")
	public PersonDAO p;
	
	
	@RequestMapping(value = "/")
	public String getString(){
		return "some data";
	}
	
	@RequestMapping(value = "/1")
	public Collection<Person> allPerson(){
		return p.list();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertPerson(@RequestBody Person pr){
		p.save(pr);
	}

	
	
}
