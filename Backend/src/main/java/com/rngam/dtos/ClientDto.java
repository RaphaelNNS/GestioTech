package com.rngam.dtos;
import java.io.Serializable;

import com.rngam.entities.Client;

public class ClientDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String documentNumber;
    private String password;
    private Long contractId; // Representação do relacionamento com a entidade Contract

    public ClientDto() {
        super();
    }

    public ClientDto(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.documentNumber = entity.getDocumentNumber();
        this.password = entity.getPassword();
        this.contractId = entity.getContract() != null ? entity.getContract().getId() : null; // Obter o ID do contrato
    }

    public ClientDto(Long id, String name, String documentNumber, String password, Long contractId) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.password = password;
        this.contractId = contractId;
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

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
