package com.rngam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rngam.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
