package br.com.projeto.ecommerce.service.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.dao.ClienteDAO;
import br.com.projeto.ecommerce.model.Clientes;

@Component
public class ClientesServiceImpl implements IClientesService {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	public Clientes cadastrarCliente(Clientes novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public Clientes alterarCliente(Clientes altera) {
		// TODO Auto-generated method stub
		return dao.save(altera);
	}

	@Override
	public Clientes buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Clientes> listaDeClientes() {
		// TODO Auto-generated method stub
		return (List<Clientes>) dao.findAll();
	}

	@Override
	public Clientes buascarPorTelefone(String telefone) {
		
		return dao.findByTelefone(telefone);
	}

}
