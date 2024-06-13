package com.luciano.sprongbotjpa.springbootjpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luciano.sprongbotjpa.springbootjpa_relationship.entities.ClientDetails;

public interface ClientDetailRepository extends CrudRepository<ClientDetails,Long> {

    

}
