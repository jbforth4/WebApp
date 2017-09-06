package hello.service;

import hello.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.PersonRepository;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    List<Person> list = new ArrayList<>();

    public void save(Person person){
        this.personRepository.save(person);
    }

    public Person findPerson(Person person){
        return this.personRepository.findOne(person.getId());
    }

    public List<Person> findAllPersons(){
        this.personRepository.findAll().forEach(Person -> list.add(Person));
        return list;
    }
}
