package br.com.fiap.ecommerce.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/produto")
@Slf4j
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
}
