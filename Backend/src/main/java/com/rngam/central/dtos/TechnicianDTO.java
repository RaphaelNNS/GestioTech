package com.rngam.central.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.central.entities.Contract;
import com.rngam.central.entities.Technician;

import jakarta.persistence.ManyToMany;

public class TechnicianDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String CPF;
	@JsonIgnore
	private Set<Contract> contracts = new HashSet<>();

	public TechnicianDTO(Long id, String name, String email, String phoneNumber, String password, String cPF,
			Set<Contract> contracts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		CPF = cPF;
		this.contracts = contracts;
	}
	
	public TechnicianDTO(Technician tec) {
		super();
		this.id = tec.getId() ;
		this.name = tec.getName();
		this.email = tec.getEmail();
		this.phoneNumber = tec.getphoneNumber();
		this.password = tec.getPasswor();
		this.CPF = tec.getCpf();
		this.contracts = tec.getContracts();
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
	
	
}