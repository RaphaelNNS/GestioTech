package com.rngam.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.rngam.enums.PrivacyEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title;
	String description;
	Long value;
	
    @Enumerated(EnumType.STRING)
	PrivacyEnum privacy;
    
    
	Set<Technician> contractEditors;
	
	//TODO IMPLEMENTAR ITERSECÇÃO ENTRE ENTIDADES
	
	 @ManyToMany
	 @JoinTable(name = "contract_technician",
     joinColumns = @JoinColumn(name = "contract_id"),
     inverseJoinColumns = @JoinColumn(name = "technician_id"))
    private Set<Technician> technicians = new HashSet<>();

	
	@OneToMany(mappedBy = "contract")
    private Set<Client> clients = new HashSet<>();
	
	public Set<Technician> addTechnicians(Set<Technician> tecs){
		this.contractEditors.addAll(tecs);
		return this.contractEditors;
	}
	
	public Set<Technician> removeTechnicians(Set<Technician> tecs){
		this.contractEditors.removeAll(tecs);
		return this.contractEditors;
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
	
	public Set<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
	}

	
	
}
