package br.com.projeto.ecommerce.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.dao.ProdutosDAO;
import br.com.projeto.ecommerce.model.Produtos;

@Component
public class ProdutosServiceImple implements IProdutosService{

	@Autowired
	private ProdutosDAO dao;
	
	@Override
	public Produtos criarProduto(Produtos novo) {
		
		return dao.save(novo);
	}

	@Override
	public Produtos alterarProduto(Produtos alterar) {
		return dao.save(alterar);
	}

	public Page<Produtos> recuperarTodosOsProdutos(Integer numero) {
		Pageable pagina =  PageRequest.of(numero,5);
		return dao.findByOrderByNomeAsc(pagina);
	}

	@Override
	public List<Produtos> recuperarPalavraSecreta(String palavra) {
		return dao.findByNomeContaining(palavra);
	}

}
