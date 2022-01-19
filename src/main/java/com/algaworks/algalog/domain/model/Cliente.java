package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	private long id;
	private String nome;
	private String email;
	private String telefone;
	
	/* ****Lombok*****
	 * incluir uma dependencia
	 * botão dir no projeto->Spring->Add Starters->lombok
	 * marcar o pom.xml no next.
	 * Obs: O lombok é inclui todas as Get e Set para as
	 * atributos listados na classe, sem incluir no código.
	 * Precisa ser configurado antes de incluir, veja material de apoio.
	*/
	
	
}
