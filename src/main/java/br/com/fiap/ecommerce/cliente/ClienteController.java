package br.com.fiap.ecommerce.cliente;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cliente")
@Slf4j
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<Cliente>> findAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.find(id));
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.save(cliente));
	}
	
	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(clienteService.update(id, cliente));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel atualizar o cliente %d com valores: %s", id, cliente));
	        return ResponseEntity.badRequest().build();
		}
		
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		
		try {
			return ResponseEntity.ok(clienteService.deleteById(id));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel deletar o cliente %d ", id));
	        return ResponseEntity.badRequest().build();
		}
	}
}
