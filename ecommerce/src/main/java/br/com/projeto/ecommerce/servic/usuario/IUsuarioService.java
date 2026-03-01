package br.com.projeto.ecommerce.servic.usuario;

import br.com.projeto.ecommerce.model.Usuario;
import br.com.projeto.ecommerce.security.ECToken;

public interface IUsuarioService {

	public Usuario novo(Usuario novo);
	public Usuario alterar(Usuario alterar);
	public ECToken fazerLogin(String login, String senha);
	
	
}
