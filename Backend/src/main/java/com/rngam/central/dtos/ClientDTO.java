package com.rngam.central.dtos;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.central.entities.Client;
import com.rngam.central.entities.Contract;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String documentNumber;
    private String password;
    @JsonIgnore
    private Contract contract; 

    public ClientDTO() {
        super();
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.documentNumber = entity.getDocumentNumber();
        this.password = entity.getPassword();
        this.contract = entity.getContract() ;
    }

    public ClientDTO(Long id, String name, String documentNumber, String password, Contract contractId) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.password = password;
        this.contract = contractId;
    }

    // Getters e Setters
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
