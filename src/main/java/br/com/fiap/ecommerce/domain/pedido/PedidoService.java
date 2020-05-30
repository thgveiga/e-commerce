package br.com.fiap.ecommerce.domain.pedido;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Cacheable(cacheNames = "Pedido", key = "#pedido.findall")
	public Collection<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Cacheable(cacheNames = "Pedido", key = "#pedido.find")
	public Pedido find(Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(String.format("Pedido com id %d não encontrado ", id));

		return optional.get();
	}

	@CacheEvict(cacheNames = "Pedido", allEntries = true)
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@CacheEvict(cacheNames = "Pedido", key = "#id")
	public Pedido deleteById(Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Pedido com id %d não encontrado para ser removido ", id));

		pedidoRepository.deleteById(id);
		return optional.get();
	}

	@CachePut(cacheNames = "Pedido", key = "#pedido.getId()")
	public Pedido update(Long id, Pedido pedido) {

		Optional<Pedido> optional = pedidoRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Pedido com id %d não encntrado para efetuar atualizacao ", id));

		Pedido temp = optional.get();
		
		temp.setCliente(pedido.getCliente());
		temp.setProdutos(pedido.getProdutos());

		return pedidoRepository.save(temp);

	}

}
