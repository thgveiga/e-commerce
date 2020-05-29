package br.com.fiap.ecommerce.cliente;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.cliente.Cliente;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cliente")
@Slf4j
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Collection<Cliente>> findAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.save(cliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(clienteService.update(id, cliente));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel atualizar o produto %d com valores: %s", id, cliente));
	        return ResponseEntity.badRequest().build();
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		
		try {
			return ResponseEntity.ok(clienteService.deleteById(id));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel deletar o produto %d ", id));
	        return ResponseEntity.badRequest().build();
		}
	}
}
