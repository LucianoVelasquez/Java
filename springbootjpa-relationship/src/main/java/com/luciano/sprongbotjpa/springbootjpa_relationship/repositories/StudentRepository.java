package com.luciano.sprongbotjpa.springbootjpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
