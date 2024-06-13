package com.luciano.sprongbotjpa.springbootjpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.invoice;

public interface InvoiceRepository extends CrudRepository<invoice,Long> {

}
