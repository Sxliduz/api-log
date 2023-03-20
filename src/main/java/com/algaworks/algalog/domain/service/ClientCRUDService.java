package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientCRUDService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		boolean emailInUse = clientRepository.findByEmail(client.getEmail()).stream().anyMatch(clientExist -> !clientExist.equals(client));
		
		if (emailInUse) {
			throw new BusinessException("There is already a customer registered with this email");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
	
}
