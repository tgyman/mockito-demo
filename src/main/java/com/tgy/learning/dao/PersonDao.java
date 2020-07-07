package com.tgy.learning.dao;

import com.tgy.learning.entity.Person;

public interface PersonDao {
    Person getPerson(int id);

    boolean update(Person person);
}
