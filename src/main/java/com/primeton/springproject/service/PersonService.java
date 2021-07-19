package com.primeton.springproject.service;

import com.primeton.springproject.entity.Person;
import com.primeton.springproject.repository.PersonRepository;
import com.primeton.springproject.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public Person findById(int id){
        Person person = personRepository.getById(id);
        return person;
    }

    public Person create(Person person){
        personRepository.save(person);
        return person;
    }

    public Person update(Person person){
        if (person!=null && person.getId()!=null){
            Person newPerson = personRepository.getById(person.getId());
            JpaUtil.copyNotNullProperties(person, newPerson);
            return personRepository.save(newPerson);
        }
        return null;
    }

    public String deleteById(int id){
        if (personRepository.findById(id)==null){
            return "查无此人，删除失败";
        }
        personRepository.deleteById(id);
        return "删除成功";
    }
}
