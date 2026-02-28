package br.com.projeto.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.Pedidos;
import br.com.projeto.ecommerce.service.pedido.IPedidoService;

@RestController
public class PedidosController {
	
	private final IPedidoService inter;

	public PedidosController(IPedidoService pedido){
		this.inter = pedido;
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedidos> criarPedido(@RequestBody Pedidos novo) {
		Pedidos result = inter.cadastrarPedido(novo);
		return ResponseEntity.ok(result);
	}
}
