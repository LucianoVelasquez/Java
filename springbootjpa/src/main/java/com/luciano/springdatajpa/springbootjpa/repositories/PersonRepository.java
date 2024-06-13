package com.luciano.springdatajpa.springbootjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.luciano.springdatajpa.springbootjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{
     
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage,String name);

    Optional<Person> findByNameContaining(String palabras);
}
