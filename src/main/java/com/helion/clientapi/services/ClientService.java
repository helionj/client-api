package com.helion.clientapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helion.clientapi.dtos.ClientDTO;
import com.helion.clientapi.entities.Client;
import com.helion.clientapi.repositories.ClientRepository;
import com.helion.clientapi.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){
		Optional<Client> obj  = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
		return new ClientDTO(entity);
	}

	

}
