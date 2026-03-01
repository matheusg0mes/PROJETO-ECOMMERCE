package br.com.projeto.ecommerce.service.produto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.projeto.ecommerce.model.Produtos;

public interface IProdutosService {
	
	public Produtos criarProduto(Produtos novo);
	public Produtos alterarProduto(Produtos alterar);
	public Page<Produtos> recuperarTodosOsProdutos(Integer numero);
	public List<Produtos> recuperarPalavraSecreta(String palavra);
	

}
