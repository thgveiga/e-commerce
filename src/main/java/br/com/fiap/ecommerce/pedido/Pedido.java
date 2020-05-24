package br.com.fiap.ecommerce.pedido;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

import br.com.fiap.ecommerce.cliente.Cliente;
import br.com.fiap.ecommerce.produto.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Collection<Produto> produtos;
}
