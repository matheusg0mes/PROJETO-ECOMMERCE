package br.com.projeto.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.Usuario;
import br.com.projeto.ecommerce.servic.usuario.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final IUsuarioService usuario;
	
	public UsuarioController(IUsuarioService novo) {
		this.usuario = novo;
	}

	@PostMapping("")
	public ResponseEntity<Usuario> criarNovo(@RequestBody Usuario novo){
		Usuario result =usuario.novo(novo);
		return ResponseEntity.ok(result);
	}
}
