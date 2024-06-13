package com.luciano.sprongbotjpa.springbootjpa_relationship;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Address;
import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Client;
import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.ClientDetails;
import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Course;
import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Student;
import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.invoice;
import com.luciano.sprongbotjpa.springbootjpa_relationship.repositories.ClientDetailRepository;
import com.luciano.sprongbotjpa.springbootjpa_relationship.repositories.ClientRepository;
import com.luciano.sprongbotjpa.springbootjpa_relationship.repositories.InvoiceRepository;
import com.luciano.sprongbotjpa.springbootjpa_relationship.repositories.StudentRepository;

@SpringBootApplication
public class SpringbootjpaRelationshipApplication implements CommandLineRunner {

	private ClientRepository clientRepository;
	private InvoiceRepository invoiceRepository;
	private ClientDetailRepository clientDetailRepository;
	private StudentRepository studentRepository;

	public SpringbootjpaRelationshipApplication(ClientRepository clientRepository,InvoiceRepository invoiceRepository,ClientDetailRepository clientDetailRepository,
	StudentRepository studentRepository) {
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
		this.clientDetailRepository = clientDetailRepository;
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		manyToManyBidireccional();

	}

	@Transactional
	public void manyToManyBidireccional(){

		Student student1 = new Student("Jano","Pura");
		Student student2 = new Student("Marcos","Yael");

		Course course1 = new Course("Java master", "Andres");
		Course course2 = new Course("Typescript", "Heran Herrera");

		student1.setCourses(Set.of(course1,course2));
		student2.setCourses(Set.of(course1));

		studentRepository.saveAll(Set.of(student1,student2));
		
		System.out.println("\n Creamos un estudiante con diferentes cursos: "+student1+"\n");
		System.out.println("\n Creamos un estudiante con diferentes cursos: "+student2+"\n");
	}

	@Transactional
	public void manyToMany(){

		Student student1 = new Student("Jano","Pura");
		Student student2 = new Student("Marcos","Yael");

		Course course1 = new Course("Java master", "Andres");
		Course course2 = new Course("Typescript", "Heran Herrera");

		student1.setCourses(Set.of(course1,course2));
		student2.setCourses(Set.of(course1));

		studentRepository.saveAll(Set.of(student1,student2));
		
		System.out.println("\n Creamos un estudiante con diferentes cursos: "+student1+"\n");
		System.out.println("\n Creamos un estudiante con diferentes cursos: "+student2+"\n");
	}

	@Transactional
	public void oneToOne(){

		ClientDetails clientDetails = new ClientDetails(true,2000);
		clientDetailRepository.save(clientDetails);

		Client client = new Client("Yerba", "Pura");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);

		System.out.println("\nCreamos un cliente con un detalle: "+client+"\n");
	}
	@Transactional
	public void oneToOneFindById(){

		ClientDetails clientDetails = new ClientDetails(true,2000);
		clientDetailRepository.save(clientDetails);

		Optional<Client> clientOptional = clientRepository.findOne(2l);

		clientOptional.ifPresent(client ->{

			client.setClientDetails(clientDetails);
			clientRepository.save(client);

			System.out.println("\nCreamos un cliente con un detalle: "+client+"\n");
		});
		

	}
	@Transactional
	public void oneToOneBidireccional(){

		Client client = new Client("Yerba", "Pura");
		ClientDetails clientDetails = new ClientDetails(true,2000);
		
		client.setClientDetails(clientDetails);
		clientDetails.setClient(client);

		clientRepository.save(client);
		

		System.out.println("\nCreamos un cliente con un detalle: "+client+"\n");
	}

	@Transactional
	public void oneToManyInvoiceBidireccionalByFindRemove(){

		Optional<Client> optionalclient = clientRepository.findOne(1l);

		optionalclient.ifPresent(client ->{
			invoice invoice1 = new invoice("Compras pc", 5000l);
			invoice invoice2 = new invoice("Compras Netbook", 3500l);

			Set<invoice> newSet = new HashSet<>();
			newSet.add(invoice1);
			newSet.add(invoice2);
			client.setInvoices(newSet);

			invoice1.setClient(client);
			invoice2.setClient(client);

			clientRepository.save(client);

			System.out.println("\n# Nuevo cliente creado con dos facturas: "+client+"\n");

		});

		Optional<Client> optionalclienBd = clientRepository.findOne(1l);
		
		optionalclienBd.ifPresent(client ->{

			Optional<invoice> iOptional = invoiceRepository.findById(2l);

			iOptional.ifPresent(inv ->{

				client.getInvoices().remove(inv);
				inv.setClient(null);

				clientRepository.save(client);

				System.out.println("\nEliminando una relacion completa de cliente: "+client+"\n");
			});

		});
	}
	@Transactional
	public void oneToManyInvoiceBidireccionalByFind(){
		Optional<Client> optionalclient = clientRepository.findOne(1l);

		optionalclient.ifPresent(client ->{
			invoice invoice1 = new invoice("Compras pc", 5000l);
			invoice invoice2 = new invoice("Compras Netbook", 3500l);

			Set<invoice> newSet = new HashSet<>();
			newSet.add(invoice1);
			newSet.add(invoice2);
			client.setInvoices(newSet);

			invoice1.setClient(client);
			invoice2.setClient(client);

			clientRepository.save(client);

			System.out.println("\n# Nuevo cliente creado con dos facturas: "+client+"\n");

		});
		
	}
	@Transactional
	public void oneToManyInvoiceBidireccional(){

		Client client = new Client("Fran","Moraz");


		invoice invoice1 = new invoice("Compras pc", 5000l);
		invoice invoice2 = new invoice("Compras Netbook", 3500l);

		Set<invoice> newSet = new HashSet<>();
		newSet.add(invoice1);
		newSet.add(invoice2);
		client.setInvoices(newSet);

		invoice1.setClient(client);
		invoice2.setClient(client);

		clientRepository.save(client);

		System.out.println("\n# Nuevo cliente creado con dos facturas: "+client+"\n");
	}

	@Transactional
	public void oneToManyRemoveAddressFindById(){

		Optional<Client> optionalClient = clientRepository.findById(3l);

		Address address1 = new Address("Sour",56);
		Address address2 = new Address("Cervantes",150);

		optionalClient.ifPresent(client ->{
			Set<Address> newSet = new HashSet<>();
			newSet.add(address2);
			newSet.add(address1);
			client.setAddresses(newSet);

			Client clientdb = clientRepository.save(client);

			System.out.println("\nSe le agrego a cliente 2 direcciones: "+clientdb+"\n");

		});

		Optional<Client> optionalClient2 = clientRepository.findOneWithAdresses(3l);

		optionalClient2.ifPresent(c -> {
			c.getAddresses().remove(address1);
			Client client2 = clientRepository.save(c);

			System.out.println("\nEliminamos una direccion del ultimo cliente creado: "+client2+"\n");
		});

	}
	@Transactional
	public void oneToManyRemoveAddress(){

		Client client = new Client("Fran","Moraz");

		Address address1 = new Address("Sauces", 35);
		Address address2 = new Address("Villa", 90);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println("\nNuevo cliente creado: "+client);

		Optional<Client> optionalClient = clientRepository.findByName("Fran");

		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(address1);
			clientRepository.save(c);
		});

	}
	@Transactional
	public void oneToMany(){

		Client client = new Client("Fran","Moraz");

		Address address1 = new Address("Sauces", 35);
		Address address2 = new Address("Villa", 90);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		/* El cliente se encarga de cargar las direcciones asosiadas, gracias a la propiedad cascade*/
		clientRepository.save(client);

		System.out.println("\nNuevo cliente creado: "+client);
	}
	@Transactional
	public void oneToManyFindById(){

		Optional<Client> optionalClient = clientRepository.findById(3l);

		optionalClient.ifPresent(client ->{

			Address address1 = new Address("Sour",56);
			Address address2 = new Address("Cervantes",150);

			Set<Address> newSet = new HashSet<>();
			newSet.add(address2);
			newSet.add(address1);
			client.setAddresses(newSet);

			Client clientdb = clientRepository.save(client);

			System.out.println(clientdb);
		});

	}

	@Transactional
	public void manyToOne(){
		/* Para crear una Factura */

		/* Primero se crea el cliente */
		Client client = new Client("Carlin", "Menez");
		clientRepository.save(client);

		/* Creamos la factura */
		invoice invoice = new invoice("Compras de oficina", 350l);
		//Asignamos el cliente a la factura.
		invoice.setClient(client);
		//Guardamos factura
		invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);

		/*  */

	}
	@Transactional
	public void manyToOneFindByIdClient(){
		/* Buscar cliente a agregarle una nueva factura */
		
		Optional<Client> optionalClient = clientRepository.findById(1l);
		
		if(optionalClient.isPresent()){
			Client client = optionalClient.get();

			invoice invoice = new invoice("compras de oficina", 3000L);
			invoice.setClient(client);
			invoice invoiceDb = invoiceRepository.save(invoice);
			System.out.println("\n=======> Factura creada para el cliente: "+invoiceDb);
		}

	}

}
