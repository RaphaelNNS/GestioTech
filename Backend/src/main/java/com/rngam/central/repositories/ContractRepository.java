package com.rngam.central.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.central.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
