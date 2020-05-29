package br.com.fiap.ecommerce.produto;

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


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/produto")
@Slf4j
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<Collection<Produto>> findAll() {
		return ResponseEntity.ok(produtoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.save(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(produtoService.update(id, produto));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel atualizar o produto %d com valores: %s", id, produto));
	        return ResponseEntity.badRequest().build();
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		
		try {
			return ResponseEntity.ok(produtoService.deleteById(id));	
		} catch (Exception e) {
			log.error(String.format("nao foi possivel deletar o produto %d ", id));
	        return ResponseEntity.badRequest().build();
		}
	}
}
