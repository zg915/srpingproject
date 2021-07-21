package com.primeton.springproject.controller;

import com.primeton.springproject.entity.Person;
import com.primeton.springproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping(value = "/findById")
    public Object findById(@RequestParam int id){
        return personService.findById(id);
    }

    @PostMapping(value = "/create")
    public Object create(Person person){
        return personService.create(person);
    }

    @PutMapping(value = "/update")
    public Object update(Person person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Object deleteById(@RequestParam int id){
        return personService.deleteById(id);
    }

}
