package com.oceanier.action.test;

import com.oceanier.entity.test.Person;
import com.oceanier.service.test.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class PersonAction {

    @Autowired
    PersonService personService;

    @Test
    public void testPerson(){
        //获取上下文对象
        ApplicationContext context =new ClassPathXmlApplicationContext("application-context-service.xml");
        PersonAction personAction =(PersonAction)context.getBean("personAction");
        Person person = personAction.personService.querypersonbyid(3);
        System.out.println(person);
    }
}
