package br.com.fiap.ecommerce.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/pedido")
@Slf4j
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
}
