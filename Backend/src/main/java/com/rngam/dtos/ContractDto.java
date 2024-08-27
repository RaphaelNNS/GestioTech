package com.rngam.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.rngam.entities.Client;
import com.rngam.entities.Contract;
import com.rngam.entities.Technician;
import com.rngam.enums.PrivacyEnum;

public class ContractDto implements Serializable{
	Long id;
	String title;
	String description;
	Long value;
	PrivacyEnum privacy;
	
	Set<Technician> contractEditors;

    private Set<Technician> technicians = new HashSet<>();
    private Set<Client> clients = new HashSet<>();
	
	
    
    
    public ContractDto(Contract entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.description = entity.getDescription();
    	this.value = entity.getValue();
    	this.privacy = entity.getPrivacy();
    	this.contractEditors = entity.getTechnicians();
    	
    }
	
	public ContractDto(Long id, String title, String description, Long value, PrivacyEnum privacy,
			Set<Technician> contractEditors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.value = value;
		this.privacy = privacy;
		this.contractEditors = contractEditors;
	}

	public Set<Technician> addTechnicians(Set<Technician> tecs){
		this.contractEditors.addAll(tecs);
		return this.contractEditors;
	}
	
	public Set<Technician> removeTechnicians(Set<Technician> tecs){
		this.contractEditors.removeAll(tecs);
		return this.contractEditors;
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
}
