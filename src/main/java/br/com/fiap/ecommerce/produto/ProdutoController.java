package br.com.fiap.ecommerce.produto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.save(produto));
	}
}
