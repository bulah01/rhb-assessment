package com.rhb.assessment.controllers;

import com.rhb.assessment.entities.Person;
import com.rhb.assessment.exception.RecordException;
import com.rhb.assessment.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("getPersonByFirstName/{firstName}")
    public ResponseEntity<Person> getPersonByFirstName(@PathVariable String firstName) throws RecordException {
        Person person = personService.findByFirstName(firstName);

        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity insertPerson(@RequestBody Person person){

        return ResponseEntity.ok(personService.save(person));
    }

    @PutMapping("/{firstName}")
    public ResponseEntity<Object> updatePerson(@PathVariable String firstName, @Valid @RequestBody Person person) throws RecordException {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/{firstName}")
    public ResponseEntity deletePerson(@PathVariable String firstName) throws RecordException {
        Person person = personService.findByFirstName(firstName);

        personService.deleteByFirstName(firstName);

        return ResponseEntity.ok().build();
    }
}
