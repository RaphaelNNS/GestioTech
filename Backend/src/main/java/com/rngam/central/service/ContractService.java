package com.rngam.central.service;

import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rngam.central.dtos.ContractDTO;
import com.rngam.central.entities.Contract;
import com.rngam.central.repositories.ContractRepository;
import com.rngam.central.service.exceptions.DatabaseException;
import com.rngam.central.service.exceptions.ResourceNotFoundException;

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Transactional(readOnly = true)
	public Page<ContractDTO> findAllPaged(Pageable pageable){
		Page<Contract> list = contractRepository.findAll(pageable);
		
		return list.map(x -> new ContractDTO(x));
				
	}
	
	@Transactional(readOnly = true)
	public ContractDTO findById(Long id) {
		Optional<Contract> ContractOptional = contractRepository.findById(id);
		Contract Contract = ContractOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ContractDTO(Contract);
	}
	
	@Transactional
	public ContractDTO insert(ContractDTO dto) {
		Contract entity = new Contract(dto);
		entity = contractRepository.save(entity);
		return new ContractDTO(entity);
	}
	

	
	@Transactional
	public ContractDTO update(Long id, ContractDTO dto) {
		try {
			Contract entity = contractRepository.getOne(id);
			entity.setTitle(dto.getTitle());
			entity.setDescription(dto.getDescription());
			entity.setValue(dto.getValue());
			entity.setPrivacy(dto.getPrivacy());
			entity.setContractEditors(dto.getContractEditorsId());
			entity.setTechnicians(dto.getTechnicians());
			entity.setClients(dto.getClients());
			entity = contractRepository.save(entity);
			return new ContractDTO(entity);
		} catch (ResourceNotFoundException e) {	
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!contractRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		try {
			contractRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
