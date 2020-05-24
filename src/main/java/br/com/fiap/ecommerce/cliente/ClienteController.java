package br.com.fiap.ecommerce.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
}
