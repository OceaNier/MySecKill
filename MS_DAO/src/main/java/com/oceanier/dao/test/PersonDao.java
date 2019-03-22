package com.oceanier.dao.test;

import com.oceanier.entity.test.Person;

public interface PersonDao {
    Person querypersonbyid(int id);

    void insertperson(Person person);
}
