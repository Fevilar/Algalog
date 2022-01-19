package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		/* Com a nova versão do java, pode ser colocado o "var" para
		 * declarar variáveis no lugar da class "Cliente".
		 * Cliente cliente1 = Cliente();
		 */
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Jorge Fernando");
		cliente1.setTelefone("11 933328788");
		cliente1.setEmail("Jorgef@hotmail.com");

		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Antonio Sérgio");
		cliente2.setTelefone("11 954684598");
		cliente2.setEmail("aser68@msn.com");

		var cliente3 = new Cliente();
		cliente3.setId(3L);
		cliente3.setNome("Maria da Silva");
		cliente3.setTelefone("11 969578884");
		cliente3.setEmail("maria.silva@gmail.com");

		return Arrays.asList(cliente1, cliente2, cliente3);
	}

}
