package br.com.fiap.ecommerce.produto;

import java.util.Collection;

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
}
