package com.xlx.rest.controller;

import com.xlx.rest.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id")int id){
        Person person = new Person();
        person.setId(1);
        person.setName("xlx");
        return person;
    }
}
