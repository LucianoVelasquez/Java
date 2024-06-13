package com.luciano.sprongbotjpa.springbootjpa_relationship.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastanme;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //Un cliente puede tener muchas direcciones, *cascade sirve para asignar o elimar las direcciones asociadas al cliente. *orphanRemoval, sirve para eliminar aquellas direcciones que no tengas relacion con ningun cliente. *Cuando tenemos una lista hay que inicializarla en el constructor vacio.
    private Set<Address> addresses;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "client")
    //con mappedBy indicamos la relacion bidireccional(inversa) client es el nombre de la clase dentro de invoice.
    private Set<invoice> invoices;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "client")
    private ClientDetails clientDetails;


    public Client(){
        this.addresses = new HashSet<>();
        this.invoices = new HashSet<>();
    }

    public Client(String name, String lastanme) {
        this();
        this.name = name;
        this.lastanme = lastanme;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<invoice> invoices) {
        this.invoices = invoices;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    
    
    //En esta clase imprimimos la relacion entre invoice y client que es bidireccional.
    @Override
    public String toString() {
        return "{id=" + id+ 
        ", name=" + name+ 
        ", lastanme=" + lastanme + 
        ", addresses=" + addresses+ 
        ", invoices=" + invoices+ 
        ", clientDetails=" + clientDetails + 
        "}";
    }
    
}
