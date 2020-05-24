package br.com.fiap.ecommerce.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String     codigo;
	private String     nome;
	private BigInteger quantidade;
	private BigDecimal valor;
	
	
}
