package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}

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
