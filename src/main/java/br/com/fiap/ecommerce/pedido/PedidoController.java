package br.com.fiap.ecommerce.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
}
