package com.helion.clientapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helion.clientapi.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
