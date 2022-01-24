package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service // Onde colocamos as régras de negócios
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	@Transactional //faz parte de uma transação, ou seja, se algo der errado tudo será cancelado.
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
			
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este email.");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional //faz parte de uma transação, ou seja, se algo der errado tudo será cancelado.
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	
}
