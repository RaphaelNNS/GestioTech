package com.rngam.central.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.rngam.central.dtos.ContractDTO;
import com.rngam.central.enums.PrivacyEnum;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Contract class representing a contract entity in the system.
 * Implements Serializable to allow contract instances to be converted into byte streams.
 */
@Entity
@Table(name = "tb_contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "contract_value")
    private Long value;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) check (privacy in ('PRIVATE','PUBLIC'))")
    private PrivacyEnum privacy;

    // List of editors who can modify the contract, stored in a separate table
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "contract_editors", joinColumns = @JoinColumn(name = "contract_id"))
    private Set<String> contractEditors = new HashSet<>();

    // Many-to-Many relationship with the Technician entity
    @ManyToMany
    @JoinTable(name = "contract_technician",
        joinColumns = @JoinColumn(name = "contract_id"),
        inverseJoinColumns = @JoinColumn(name = "technician_id"))
    private Set<Technician> technicians = new HashSet<>();

    // One-to-Many relationship with the Client entity
    @OneToMany(mappedBy = "contract")
    private Set<Client> clients = new HashSet<>();

    /**
     * Constructor that initializes a Contract from a ContractDTO object.
     * 
     * @param dto ContractDTO object from which data will be copied.
     */
    public Contract(ContractDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.value = dto.getValue();
        this.privacy = dto.getPrivacy();
        this.technicians = dto.getTechnicians();
        this.clients = dto.getClients();
        this.contractEditors = dto.getContractEditorsId();
    }

    /**
     * Constructor with all parameters.
     * 
     * @param id Contract ID.
     * @param title Contract title.
     * @param description Contract description.
     * @param value Contract value.
     * @param privacy Contract privacy level (PUBLIC or PRIVATE).
     * @param contractEditors Set of editors allowed to edit the contract.
     * @param technicians Set of technicians associated with the contract.
     * @param clients Set of clients associated with the contract.
     */
    public Contract(Long id, String title, String description, Long value, PrivacyEnum privacy,
                    Set<String> contractEditors, Set<Technician> technicians, Set<Client> clients) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
        this.privacy = privacy;
        this.contractEditors = contractEditors;
        this.technicians = technicians;
        this.clients = clients;
    }

    /**
     * Default constructor.
     */
    public Contract() {
        super();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public PrivacyEnum getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PrivacyEnum privacy) {
        this.privacy = privacy;
    }

    public Set<String> getContractEditors() {
        return contractEditors;
    }

    public void setContractEditors(Set<String> contractEditors) {
        this.contractEditors = contractEditors;
    }

    public Set<Technician> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(Set<Technician> technicians) {
        this.technicians = technicians;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    // Methods to add or remove technician IDs from contractEditors

    public Set<String> addTechniciansId(Set<String> technicianIds) {
        this.contractEditors.addAll(technicianIds);
        return this.contractEditors;
    }

    public Set<String> removeTechniciansId(Set<String> technicianIds) {
        this.contractEditors.removeAll(technicianIds);
        return this.contractEditors;
    }
}