package com.rhb.assessment.repositories;

import com.rhb.assessment.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByFirstName(String firstName);

    void deleteByFirstName(String firstName);
}
