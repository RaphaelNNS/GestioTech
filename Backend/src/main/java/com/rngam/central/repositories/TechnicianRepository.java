package com.rngam.central.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.central.entities.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
