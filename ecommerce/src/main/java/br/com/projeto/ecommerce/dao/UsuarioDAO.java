package br.com.projeto.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario,Integer> {

	public Usuario findByLogin(String login);
}
