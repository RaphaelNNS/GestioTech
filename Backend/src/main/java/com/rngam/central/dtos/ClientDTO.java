package com.rngam.central.dtos;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.central.entities.Client;
import com.rngam.central.entities.Contract;

/**
 * Data Transfer Object (DTO) for Client entity.
 * This class is used to transfer data between different layers of the application.
 */
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String documentNumber;
    private String password;

    // Contract is marked with @JsonIgnore to avoid serialization, since it's not needed in every context
    @JsonIgnore
    private Contract contract;

    /**
     * Default constructor.
     */
    public ClientDTO() {
        super();
    }

    /**
     * Constructs a ClientDTO from a Client entity.
     * 
     * @param entity The Client entity.
     */
    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.documentNumber = entity.getDocumentNumber();
        this.password = entity.getPassword();
        this.contract = entity.getContract();
    }

    /**
     * Parameterized constructor for ClientDTO.
     * 
     * @param id The ID of the client.
     * @param name The name of the client.
     * @param documentNumber The document number (e.g., CPF) of the client.
     * @param password The password of the client.
     * @param contract The contract associated with the client.
     */
    public ClientDTO(Long id, String name, String documentNumber, String password, Contract contract) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.password = password;
        this.contract = contract;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}