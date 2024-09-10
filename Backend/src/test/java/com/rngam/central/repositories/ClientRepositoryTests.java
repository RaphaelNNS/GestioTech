package com.rngam.central.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.rngam.central.entities.Client;

@DataJpaTest
public class ClientRepositoryTests {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExistis() {
		long existingId = 1L;
		clientRepository.deleteById(existingId);
		Optional<Client> client = clientRepository.findById(existingId);
		Assertions.assertFalse(client.isPresent());
	}
}
