package com.rngam.central.service;

import java.util.Locale.Category;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rngam.central.dtos.ClientDTO;
import com.rngam.central.dtos.ContractDTO;
import com.rngam.central.entities.Client;
import com.rngam.central.entities.Contract;
import com.rngam.central.repositories.ClientRepository;
import com.rngam.central.repositories.ContractRepository;
import com.rngam.central.service.exceptions.DatabaseException;
import com.rngam.central.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ContractRepository contractRepository;
	
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable){
		Page<Client> list = clientRepository.findAll(pageable);
		
		return list.map(x -> new ClientDTO(x));
				
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> clientOptional = clientRepository.findById(id);
		Client client = clientOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client(dto);
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insertContract(Long clientId, Long contractId) {
		Client client = clientRepository.getById(contractId);
		Contract contract = contractRepository.getById(contractId);
		client.setContract(contract);
		
		return new ClientDTO(clientRepository.save(client));
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(dto.getName());
			entity.setPassword(dto.getPassword());
			entity.setDocumentNumber(dto.getDocumentNumber());
			entity.setContract(dto.getContract());
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		} catch (ResourceNotFoundException e) {	
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		try {
			clientRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
