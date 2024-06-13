package com.luciano.sprongbotjpa.springbootjpa_relationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.Client;



public interface ClientRepository extends CrudRepository<Client,Long> {

    public Optional<Client> findByName(String name);

    @Query("select c from Client c left join fetch c.addresses where c.id=?1")
    public Optional<Client> findOneWithAdresses(Long id);

    @Query("select c from Client c left join fetch c.invoices where c.id=?1")
    public Optional<Client> findOneWithInvoices(Long id);

    @Query("select c from Client c left join fetch c.invoices left join fetch c.addresses where c.id=?1")
    public Optional<Client> findOne(Long id);
}
