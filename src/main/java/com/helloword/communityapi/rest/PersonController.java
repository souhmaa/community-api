package com.helloword.communityapi.rest;

import com.helloword.communityapi.repository.Person;
import com.helloword.communityapi.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return this.personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return this.personService.getPerson(id);
    }


}
