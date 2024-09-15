package com.rngam.central.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.central.entities.Contract;
import com.rngam.central.entities.Technician;

/**
 * Data Transfer Object (DTO) for the Technician entity.
 * Implements Serializable to allow the object to be serialized if necessary.
 */
public class TechnicianDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    
    private String cpf;
    
    // Contracts field will be ignored during JSON serialization
    @JsonIgnore
    private Set<Contract> contracts = new HashSet<>();

    /**
     * Constructor with all parameters.
     * 
     * @param id Technician's ID.
     * @param name Technician's name.
     * @param email Technician's email.
     * @param phoneNumber Technician's phone number.
     * @param password Technician's password.
     * @param cpf Technician's CPF.
     * @param contracts Set of contracts associated with the technician.
     */
    public TechnicianDTO(Long id, String name, String email, String phoneNumber, String password, String cpf,
            Set<Contract> contracts) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.cpf = cpf;
        this.contracts = contracts;
    }

    /**
     * Constructor to initialize a TechnicianDTO from a Technician entity.
     * 
     * @param tec Technician entity from which data will be copied.
     */
    public TechnicianDTO(Technician tec) {
        super();
        this.id = tec.getId();
        this.name = tec.getName();
        this.email = tec.getEmail();
        this.phoneNumber = tec.getPhoneNumber();
        this.password = tec.getPassword();
        this.cpf = tec.getCpf();
        this.contracts = tec.getContracts();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}