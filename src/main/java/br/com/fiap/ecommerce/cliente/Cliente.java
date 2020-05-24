package br.com.fiap.ecommerce.cliente;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String   nome;
	private Integer  idade;
	private String   telefone;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco enderecoEntrega;
	
	
}
