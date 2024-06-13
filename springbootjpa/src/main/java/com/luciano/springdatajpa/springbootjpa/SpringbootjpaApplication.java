package com.luciano.springdatajpa.springbootjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luciano.springdatajpa.springbootjpa.entities.Person;
import com.luciano.springdatajpa.springbootjpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootjpaApplication implements CommandLineRunner {

	private PersonRepository personRepository;
	public SpringbootjpaApplication(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		
		createPerson();
		/* removePerson();
		updatePerson(); */
		listPersons();
		

	}

	public void updatePerson(){
		
		Optional<Person> optionalPerson = personRepository.findById(2l);

		optionalPerson.ifPresent(person -> {
			
			System.out.println("Datos actuales: "+person.toString());
			
			person.setName("Velasquez");
			
			Person newPerson = personRepository.save(person);

			System.out.println("\nActualizacion lista:"+newPerson);
		});

	}

	public void createPerson(){
		Person newPerson = new Person(null, "Name5", "Apellido5","Java");

		Person person = personRepository.save(newPerson);

		System.out.println(person);
	}

	public void onePerson(){

		System.out.println("\n----------------------------------------");
		System.out.println("Busca una persona por Id");
		Person person = personRepository.findById(1L).orElseThrow();
		System.out.println(person);

		System.out.println("\n----------------------------------------");
		System.out.println("Busca una persona por");
		Person person2 = personRepository.findByNameContaining("f").orElseThrow();
		System.out.println(person2);

	}

	public void listPersons(){
		System.out.println("\n----------------------------------------");
		System.out.println("Lista todos los nombres");
		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(p -> System.out.println(p) );

		System.out.println("\n----------------------------------------");
		System.out.println("Lista por lenguaje de programacion");
		List<Person> persons2 = (List<Person>) personRepository.findByProgrammingLanguage("Python");
		persons2.stream().forEach(p -> System.out.println(p));

		System.out.println("\n----------------------------------------");
		System.out.println("Lista por lenguaje de programacion y name");
		List<Person> persons3 = (List<Person>) personRepository.findByProgrammingLanguageAndName("Python","fer");
		persons3.stream().forEach(p -> System.out.println(p));
	}

	public void removePerson(){
		Optional<Person> person = personRepository.findById(2l);
		System.out.println("\nPersona a eliminar:"+person.get().toString());
		personRepository.deleteById(2l);

		List<Person> listPerson = (List<Person>) personRepository.findAll();
		System.out.println("\n------------------------");
		System.out.println("Nueva lista:");
		listPerson.stream().forEach(System.out::print);
	}
}
