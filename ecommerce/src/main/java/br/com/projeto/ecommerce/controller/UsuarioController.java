package br.com.projeto.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.Usuario;
import br.com.projeto.ecommerce.security.ECToken;
import br.com.projeto.ecommerce.servic.usuario.IUsuarioService;

@RestController
public class UsuarioController {
	
	private final IUsuarioService usuario;
	
	public UsuarioController(IUsuarioService novo) {
		this.usuario = novo;
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> criarNovo(@RequestBody Usuario novo){
		Usuario result = usuario.novo(novo);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("usuario/login")
	public ResponseEntity<ECToken> loginUsuario(@RequestBody Usuario usuario){
		ECToken token = this.usuario.fazerLogin(usuario.getLogin(), usuario.getSenha());
		if(token != null) {
			return ResponseEntity.ok(token);
			
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
