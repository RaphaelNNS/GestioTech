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

@Entity
@Table(name = "tb_client")
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String documentNumber;
	private String password;
	
	
	@ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
	
	//TODO IMPLEMENTAR ITERSECÇÃO ENTRE ENTIDADES
	
	public Client() {
		super();
	}
	
	public Client(Long id, String name, String documentNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.documentNumber = documentNumber;
		this.password = password;
	}
	
	public Client(ClientDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.documentNumber = dto.getDocumentNumber();
        this.password = dto.getPassword();
        this.contract = dto.getContract();  // Supondo que você já buscou o objeto Contract antes de chamar este construtor
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
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

	
}
