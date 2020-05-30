package br.com.fiap.ecommerce.domain.produto;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

    @Cacheable(cacheNames = "Produto", key="#produto.findall")
	public Collection<Produto> findAll() {
		return produtoRepository.findAll();
	}

    @Cacheable(cacheNames = "Produto", key = "#produto.find")
    public Produto find(Long id) {
    	Optional<Produto> optional = produtoRepository.findById(id);
    	
    	if (!optional.isPresent())
			throw new IllegalArgumentException(String.format("Produto com id %d não encontrado ", id));

    	return optional.get();
	}
    
    @CacheEvict(cacheNames = "Produto", allEntries = true)
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

    @CacheEvict(cacheNames = "Produto", key="#id")
	public Produto deleteById(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(String.format("Produto com id %d não encontrado para ser removido ", id));

		produtoRepository.deleteById(id);
		return optional.get();
	}

    @CachePut(cacheNames = "Produto", key="#produto.getId()")
	public Produto update(Long id, Produto produto) {

		Optional<Produto> optional = produtoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Produto com id %d não encntrado para efetuar atualizacao ", id));

		Produto temp = optional.get();
		
		temp.setCodigo(produto.getCodigo());
		temp.setNome(produto.getNome());
		temp.setQuantidade(produto.getQuantidade());
		temp.setValor(produto.getValor());
		
		return produtoRepository.save(temp);

	}

}
