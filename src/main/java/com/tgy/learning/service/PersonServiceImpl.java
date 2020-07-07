package com.tgy.learning.service;

import com.tgy.learning.dao.PersonDao;
import com.tgy.learning.entity.Person;

public class PersonServiceImpl implements  PersonService {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao){
        this.personDao=personDao;
    }

    @Override
    public boolean update(int id, String name) {
        Person person=personDao.getPerson(id);
        if(person==null){
            return false;
        }
        Person updatePerson=new Person(person.getId(),name);
        return personDao.update(updatePerson);
    }
}
