package com.primeton.springproject.service;

import com.primeton.springproject.entity.Person;
import com.primeton.springproject.repository.PersonRepository;
import com.primeton.springproject.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Object findById(int id){
        if (personRepository.existsById(id)){
            return personRepository.getById(id);
        }
        return "id does not exist";
    }

    public Object create(Person person){
        if (personRepository.existsById(person.getId())){
            return "id already exists";
        }
        personRepository.save(person);
        return person;
    }

    public Object update(Person person){
        if (personRepository.existsById(person.getId())){
            Person newPerson = personRepository.getById(person.getId());
            JpaUtil.copyNotNullProperties(person, newPerson);
            return personRepository.save(newPerson);
        }
        return "id does not exist";
    }

    public String deleteById(int id){
        if (personRepository.existsById(id)){
            personRepository.deleteById(id);
            return "success";
        }
        return "id does not exist";
    }
}
