package br.com.projeto.ecommerce.service.pedido;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.dao.PedidoDAO;
import br.com.projeto.ecommerce.model.ItemPedido;
import br.com.projeto.ecommerce.model.Pedidos;

@Service
public class PedidosServiceImpl implements IPedidoService{
	
	private final PedidoDAO dao;
	
	public PedidosServiceImpl(PedidoDAO dao) {
		this.dao = dao;
	}

	@Override
	public Pedidos cadastrarPedido(Pedidos novo) {
		for(ItemPedido item : novo.getItemPedido()) {
			item.setPedido(novo);
		}
		return dao.save(novo);
	}

	@Override
	public Pedidos alterarPedido(Pedidos alterar) {
		// TODO Auto-generated method stub
		return dao.save(alterar);
	}

	@Override
	public List<Pedidos> retornarTodos() {
		return (List<Pedidos>) dao.findAll();
	}

	@Override
	public List<Pedidos> retornarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
