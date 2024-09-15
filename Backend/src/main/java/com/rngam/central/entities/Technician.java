package com.rngam.central.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.rngam.central.dtos.TechnicianDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


/**
 * Technician class that represents a technician in the system.
 * Implements Serializable to allow objects of this class to be converted into a byte stream if necessary.
 */
@Entity
@Table(name = "tb_technician")
public class Technician implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String cpf;

    // Many-to-Many relationship with the Contract entity
    @ManyToMany(mappedBy = "technicians")
    private Set<Contract> contracts = new HashSet<>();

    public Technician() {
        super();
    }

    /**
     * Constructor with parameters for initializing a technician.
     * 
     * @param name Technician's name.
     * @param email Technician's email.
     * @param phoneNumber Technician's phone number.
     * @param password Technician's password.
     * @param cpf Technician's CPF (Brazilian ID).
     */
    public Technician(String name, String email, String phoneNumber, String password, String cpf) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.cpf = cpf;
    }

    /**
     * Constructor that initializes a Technician from a DTO object.
     * 
     * @param dto DTO object that contains technician data.
     */
    public Technician(TechnicianDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.password = dto.getPassword();
        this.cpf = dto.getCpf();
        this.contracts = dto.getContracts(); // Assuming you need to copy the contracts as well
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

    // hashCode and equals methods using cpf and email as main attributes

    @Override
    public int hashCode() {
        return Objects.hash(cpf, password, email, id, name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Technician other = (Technician) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(password, other.password)
                && Objects.equals(email, other.email) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
    }
}
