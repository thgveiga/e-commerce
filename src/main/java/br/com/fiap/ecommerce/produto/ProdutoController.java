package br.com.fiap.ecommerce.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
}
