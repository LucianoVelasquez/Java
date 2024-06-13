package com.luciano.springdatajpa.springbootjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastanme;
   
    @Column(name = "programming_language")
    private String programmingLanguage;

    public Person() {
    }

    public Person(Long id, String name, String lastanme, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastanme = lastanme;
        this.programmingLanguage = programmingLanguage;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastanme() {
        return lastanme;
    }
    public void setLastanme(String lastanme) {
        this.lastanme = lastanme;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastanme=" + lastanme + ", programmingLanguage="
                + programmingLanguage + "]";
    }

    
}
