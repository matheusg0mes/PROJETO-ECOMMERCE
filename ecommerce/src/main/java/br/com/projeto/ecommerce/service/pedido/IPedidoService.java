package br.com.projeto.ecommerce.service.pedido;

import java.util.List;

import br.com.projeto.ecommerce.model.Pedidos;

public interface IPedidoService {
	
	public Pedidos cadastrarPedido(Pedidos novo);
	public Pedidos alterarPedido(Pedidos alterar);
	public List<Pedidos> retornarTodos();
	public List<Pedidos> retornarPorId(Integer id);

}
