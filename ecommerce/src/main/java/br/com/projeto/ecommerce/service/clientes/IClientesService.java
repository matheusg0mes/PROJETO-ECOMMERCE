package br.com.projeto.ecommerce.service.clientes;

import java.util.List;

import br.com.projeto.ecommerce.model.Clientes;

public interface IClientesService {

	public Clientes cadastrarCliente(Clientes novo);
	public Clientes alterarCliente(Clientes altera);
	public Clientes buascarPorTelefone(String telefone);
	public Clientes buscarPorId(Integer id);
	public List<Clientes> listaDeClientes();
}
