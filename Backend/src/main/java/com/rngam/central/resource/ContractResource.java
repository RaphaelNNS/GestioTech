package com.rngam.central.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rngam.central.dtos.ContractDTO;
import com.rngam.central.service.ContractService;

@RestController
@RequestMapping(value = "/contracts")
public class ContractResource {
	
	@Autowired
	private ContractService contractService;
	
	@GetMapping
	private ResponseEntity<Page<ContractDTO>> findAllPaged(Pageable pageable){
		Page<ContractDTO> Contracts = contractService.findAllPaged(pageable);
		ResponseEntity<Page<ContractDTO>> response = ResponseEntity.ok(Contracts);
		return response;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContractDTO> findById(@PathVariable Long id){
		ContractDTO dto = contractService.findById(id);
		
		
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ContractDTO> insert(@RequestBody ContractDTO dto){
		dto = contractService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContractDTO> update(@PathVariable Long id, @RequestBody ContractDTO dto){
		dto = contractService.update(id,dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ContractDTO> delete(@PathVariable Long id){
		contractService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
