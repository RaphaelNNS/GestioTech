package com.rngam.central.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rngam.central.dtos.TechnicianDTO;
import com.rngam.central.service.TechnicianService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {
	
	@Autowired
	private TechnicianService technicianService;
	
	@GetMapping
	private ResponseEntity<Page<TechnicianDTO>> findAllPaged(Pageable pageable){
		Page<TechnicianDTO> Technicians = technicianService.findAllPaged(pageable);
		ResponseEntity<Page<TechnicianDTO>> response = ResponseEntity.ok(Technicians);
		return response;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id){
		TechnicianDTO dto = technicianService.findById(id);
		
		
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<TechnicianDTO> insert(@RequestBody TechnicianDTO dto){
		dto = technicianService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> update(@PathVariable Long id, @RequestBody TechnicianDTO dto){
		dto = technicianService.update(id,dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> delete(@PathVariable Long id){
		technicianService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
