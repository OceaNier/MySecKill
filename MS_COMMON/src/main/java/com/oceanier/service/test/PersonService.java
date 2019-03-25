package com.oceanier.service.test;

import com.oceanier.entity.test.Person;

public interface PersonService {

    public Person querypersonbyid(int id);
    public void insertperson(Person person);

}
