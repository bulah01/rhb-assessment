package com.rhb.assessment.services;

import com.rhb.assessment.entities.Person;
import com.rhb.assessment.exception.RecordException;
import com.rhb.assessment.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByFirstName(String firstName) throws RecordException {
        Optional<Person> user = personRepository.findByFirstName(firstName);

        if(user.isPresent())
            return user.get();
        else
            throw new RecordException("No record exist for given id");
    }

    public Object save(Person person) {
        System.out.println(person);
        return personRepository.save(person);
    }

    public Object update(Person person) throws RecordException {
        Optional<Person> personData = personRepository.findByFirstName(person.getFirstName());

        if(personData.isPresent()){
            Person _person = personData.get();
            _person.setFirstName(person.getFirstName());
            _person.setLastName(person.getLastName());
            _person.setEmail(person.getEmail());

            this.save(_person);
            return _person;
        }
        else
            throw new RecordException("No record exist for given id");
    }

    public void deleteByFirstName(String firstName) {
        personRepository.deleteByFirstName(firstName);
    }
}
