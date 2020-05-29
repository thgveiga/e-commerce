package br.com.fiap.ecommerce.produto;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Collection<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto deleteById(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(String.format("Produto com id %d não encontrado para ser removido ", id));

		produtoRepository.deleteById(id);
		return optional.get();
	}

	public Produto update(Long id, Produto produto) {

		Optional<Produto> optional = produtoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Produto com id %d não encntrado para efetuar atualizacao ", id));

		Produto temp = optional.get();
		//setar atributos do produto
		return produtoRepository.save(temp);

	}
}
