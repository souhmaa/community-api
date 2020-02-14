package com.helloword.communityapi.service;

import com.helloword.communityapi.repository.Person;
import com.helloword.communityapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.initDB();
    }

    private void initDB() {
        Person person1 = new Person();
        person1.setAge(20);
        person1.setCin("CIN1");
        person1.setFirstName("Boubou");
        person1.setLastName("Balde");
        this.addPerson(person1);
    }

    public void addPerson(Person person) {
        this.personRepository.save(person);
    }

    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return this.personRepository.findById(id).orElseThrow();

    }
}
