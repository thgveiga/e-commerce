package br.com.fiap.ecommerce.domain.pedido;

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

import br.com.fiap.ecommerce.domain.pedido.Pedido;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/pedido")
@Slf4j
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<Collection<Pedido>> findAll() {
		return ResponseEntity.ok(pedidoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
		return ResponseEntity.ok(pedidoService.save(pedido));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
		try {
			return ResponseEntity.ok(pedidoService.update(id, pedido));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel atualizar o pedido %d com valores: %s", id, pedido));
	        return ResponseEntity.badRequest().build();
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> delete(@PathVariable Long id) {
		
		try {
			return ResponseEntity.ok(pedidoService.deleteById(id));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel deletar o pedido %d ", id));
	        return ResponseEntity.badRequest().build();
		}
	}
}
