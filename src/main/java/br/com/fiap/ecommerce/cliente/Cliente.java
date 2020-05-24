package br.com.fiap.ecommerce.cliente;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Data
	@NoArgsConstructor
	@ToString
    class Endereco {
		private String rua;
		private Integer numero;
		private String cep;
		private String bairro;
		private String cidade;
	}

	private String   nome;
	private Integer  idade;
	private String   telefone;
	private Endereco enderecoEntrega;
	
	
}
