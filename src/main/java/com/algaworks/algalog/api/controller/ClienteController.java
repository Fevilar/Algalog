package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;
	
	
//	@GetMapping("/clientes")  // com a inclusão do @RequestMapping, não precisa mais especificar
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
//		return clienteRepository.findByNomeContaining("u");
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(ResponseEntity::ok) 					// Se existir, mostre. (Método reference))
//				.map(cliente -> ResponseEntity.ok(cliente)) // Se existir, mostre.	(Lambda)
				.orElse(ResponseEntity.notFound().build()); // Se não, 404 not found.
		
		
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get()); // Se existir, mostre.
//		}
//		return ResponseEntity.notFound().build(); // Se não, 404 not found.
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adcionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, 
			@RequestBody Cliente cliente){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cliente = catalogoClienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		catalogoClienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
//	@GetMapping("/clientes")
//	public List<Cliente> listar() {
//		return manager.createQuery("from Cliente", Cliente.class).getResultList();
//	}
	
	/*
	 * Com a nova versão do java, pode ser colocado o "var" para declarar variáveis
	 * no lugar da class "Cliente". Cliente cliente1 = Cliente();
	 */
//		Cliente cliente1 = new Cliente();
//		cliente1.setId(1L);
//		cliente1.setNome("Jorge Fernando");
//		cliente1.setTelefone("11 93332-8788");
//		cliente1.setEmail("Jorgef@hotmail.com");
//
//		Cliente cliente2 = new Cliente();
//		cliente2.setId(2L);
//		cliente2.setNome("Antonio Sérgio");
//		cliente2.setTelefone("11 95468-4598");
//		cliente2.setEmail("aser68@msn.com");
//
//		Cliente cliente3 = new Cliente();
//		cliente3.setId(3L);
//		cliente3.setNome("Maria da Silva");
//		cliente3.setTelefone("11 96957-8884");
//		cliente3.setEmail("maria.silva@gmail.com");
//
//		List<Cliente> lista = new ArrayList<Cliente>();
//		lista.add(cliente1);
//		lista.add(cliente2);
//		lista.add(cliente3);
//		
//		return Arrays.asList(cliente1, cliente2, cliente3);

}
