package com.rngam.central.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rngam.central.dtos.TechnicianDTO;
import com.rngam.central.entities.Technician;
import com.rngam.central.repositories.TechnicianRepository;
import com.rngam.central.service.exceptions.DatabaseException;
import com.rngam.central.service.exceptions.ResourceNotFoundException;

@Service
public class TechnicianService {
	
	@Autowired
	private TechnicianRepository TechnicianRepository;
	
	@Transactional(readOnly = true)
	public Page<TechnicianDTO> findAllPaged(Pageable pageable){
		Page<Technician> list = TechnicianRepository.findAll(pageable);
		
		return list.map(x -> new TechnicianDTO(x));
				
	}
	
	@Transactional(readOnly = true)
	public TechnicianDTO findById(Long id) {
		Optional<Technician> TechnicianOptional = TechnicianRepository.findById(id);
		Technician Technician = TechnicianOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new TechnicianDTO(Technician);
	}
	
	@Transactional
	public TechnicianDTO insert(TechnicianDTO dto) {
		Technician entity = new Technician(dto);
		entity = TechnicianRepository.save(entity);
		return new TechnicianDTO(entity);
	}
	
	@Transactional
	public TechnicianDTO update(Long id, TechnicianDTO dto) {
		try {
			Technician entity = TechnicianRepository.getOne(id);
			entity.setName(dto.getName());
			entity = TechnicianRepository.save(entity);
			return new TechnicianDTO(entity);
		} catch (ResourceNotFoundException e) {	
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!TechnicianRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		try {
			TechnicianRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
