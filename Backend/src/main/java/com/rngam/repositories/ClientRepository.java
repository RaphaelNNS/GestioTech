package com.rngam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
