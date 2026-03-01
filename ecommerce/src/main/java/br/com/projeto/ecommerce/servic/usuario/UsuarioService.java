package br.com.projeto.ecommerce.servic.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.dao.UsuarioDAO;
import br.com.projeto.ecommerce.model.Usuario;
import br.com.projeto.ecommerce.security.ECToken;

@Component
public class UsuarioService implements IUsuarioService{
	
	private final UsuarioDAO dao;
	private final BCryptPasswordEncoder encoder;
	
	public UsuarioService(UsuarioDAO dao, BCryptPasswordEncoder encoder) {
		this.dao = dao;
		this.encoder = encoder;
	}

	@Override
	public Usuario novo(Usuario novo) {
		String senha = encoder.encode(novo.getSenha());
		novo.setSenha(senha);
		return dao.save(novo);
	}

	@Override
	public Usuario alterar(Usuario alterar) {
		String senha = encoder.encode(alterar.getSenha());
		alterar.setSenha(senha);
		return dao.save(alterar);
	}

	@Override
	public ECToken fazerLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
