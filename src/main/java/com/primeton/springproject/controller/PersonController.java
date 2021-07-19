package com.primeton.springproject.controller;

import com.primeton.springproject.entity.Person;
import com.primeton.springproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping(value = "/findById")
    public Person findById(@RequestParam int id){
        return personService.findById(id);
    }


    @PostMapping(value = "/create")
    public Person create(Person person){
        return personService.create(person);
    }

    @PutMapping(value = "/update")
    public Person update(Person person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@RequestParam int id){
        return personService.deleteById(id);
    }

}
