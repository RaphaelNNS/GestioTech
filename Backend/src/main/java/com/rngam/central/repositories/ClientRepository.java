package com.rngam.central.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.central.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
