package com.rngam.central.entities;

import java.io.Serializable;

import com.rngam.central.dtos.ClientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Client in the system.
 * Implements Serializable to allow instances to be converted to byte streams.
 */
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String documentNumber;
    private String password;

    // Many clients can be associated with one contract
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    /**
     * Default constructor.
     */
    public Client() {
        super();
    }

    /**
     * Parameterized constructor for Client.
     * 
     * @param id Client ID.
     * @param name Client name.
     * @param documentNumber Client document number (e.g., CPF or other identifier).
     * @param password Client password.
     */
    public Client(Long id, String name, String documentNumber, String password) {
        super();
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.password = password;
    }

    /**
     * Constructor that initializes a Client object from a ClientDTO object.
     * 
     * @param dto The ClientDTO object containing the client data.
     */
    public Client(ClientDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.documentNumber = dto.getDocumentNumber();
        this.password = dto.getPassword();
        this.contract = dto.getContract(); // Assuming the Contract object is fetched before using this constructor
    }

    // Getters and setters

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