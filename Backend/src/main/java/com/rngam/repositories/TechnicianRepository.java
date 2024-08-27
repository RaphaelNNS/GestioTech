package com.rngam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.entities.Client;
import com.rngam.entities.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
