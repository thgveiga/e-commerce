package br.com.fiap.ecommerce.cliente;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Cacheable(cacheNames = "Cliente", key = "#cliente.findall")
	public Collection<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Cacheable(cacheNames = "Cliente", key = "#cliente.find")
	public Cliente find(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(String.format("Cliente com id %d não encontrado ", id));

		return optional.get();
	}

	@CacheEvict(cacheNames = "Cliente", allEntries = true)
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@CacheEvict(cacheNames = "Cliente", key = "#id")
	public Cliente deleteById(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Cliente com id %d não encontrado para ser removido ", id));

		clienteRepository.deleteById(id);
		return optional.get();
	}

	@CachePut(cacheNames = "Cliente", key = "#cliente.getId()")
	public Cliente update(Long id, Cliente cliente) {

		Optional<Cliente> optional = clienteRepository.findById(id);

		if (!optional.isPresent())
			throw new IllegalArgumentException(
					String.format("Cliente com id %d não encntrado para efetuar atualizacao ", id));

		Cliente temp = optional.get();

		temp.setNome(cliente.getNome());
		temp.setIdade(cliente.getIdade());
		temp.setTelefone(cliente.getTelefone());
		temp.setEnderecoEntrega(cliente.getEnderecoEntrega());
		
		return clienteRepository.save(temp);

	}

}
