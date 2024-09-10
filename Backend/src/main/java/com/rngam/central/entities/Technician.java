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

@Entity
@Table(name = "tb_technician")
public class Technician implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String Password;
	private String Cpf;
	
	//TODO IMPLEMENTAR ITERSECÇÃO ENTRE ENTIDADES
	
	 @ManyToMany(mappedBy = "technicians")
	    private Set<Contract> contracts = new HashSet<>();
	
	public Technician() {
		super();
	}
	public Technician(String name, String email, String phoneNumber, String password, String cpf) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Password = password;
		Cpf = cpf;
	}
	public Technician(TechnicianDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.Password = dto.getPassword();
        this.Cpf = dto.getCPF();
        this.contracts = dto.getContracts(); // Supondo que você precise copiar os contratos também
    }
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
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPasswor() {
		return Password;
	}
	public void setPasswor(String passwor) {
		Password = passwor;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public Set<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Cpf, Password, email, id, name, phoneNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technician other = (Technician) obj;
		return Objects.equals(Cpf, other.Cpf) && Objects.equals(Password, other.Password)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}
	
	
}
