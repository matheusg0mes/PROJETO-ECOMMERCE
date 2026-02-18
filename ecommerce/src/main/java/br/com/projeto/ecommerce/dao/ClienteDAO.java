package br.com.projeto.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.ecommerce.model.Clientes;

public interface ClienteDAO  extends CrudRepository<Clientes,Integer>{


	public Clientes findByTelefone(String telefone);
}
