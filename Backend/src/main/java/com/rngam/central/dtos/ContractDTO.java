package com.rngam.central.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rngam.central.entities.Client;
import com.rngam.central.entities.Contract;
import com.rngam.central.entities.Technician;
import com.rngam.central.enums.PrivacyEnum;

public class ContractDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String description;
	private Long value;
	private PrivacyEnum privacy;
	
	
	private Set<String> contractEditorsId;
	@JsonIgnore 
    private Set<Technician> technicians = new HashSet<>();
	@JsonIgnore
    private Set<Client> clients = new HashSet<>();
	
	
    
    
    public ContractDTO(Contract entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.description = entity.getDescription();
    	this.value = entity.getValue();
    	this.privacy = entity.getPrivacy();
    	this.contractEditorsId = entity.getContractEditors();
    	this.clients = entity.getClients();
    }
	
	public ContractDTO(Long id, String title, String description, Long value, PrivacyEnum privacy,
			Set<String> contractEditorsId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.value = value;
		this.privacy = privacy;
		this.contractEditorsId = contractEditorsId;
		this.technicians = getTechnicians();
	}

	public Set<Technician> addTechnicians(Set<Technician> tecs){
		this.technicians.addAll(tecs);
		return this.technicians;
	}
	
	public Set<Technician> removeTechnicians(Set<Technician> tecs){
		this.technicians.removeAll(tecs);
		return this.technicians;
	}
	
	
	
	public Set<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getContractEditorsId() {
		return contractEditorsId;
	}

	public void setContractEditorsId(Set<String> contractEditors) {
		this.contractEditorsId = contractEditors;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	
}
