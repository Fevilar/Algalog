package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String email;
	
	// Quando a coluna da tabela tem nome diferente do atributo da classe.
	@Column(name = "fone")
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
