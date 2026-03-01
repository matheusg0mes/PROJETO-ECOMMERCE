package br.com.projeto.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.ecommerce.model.Produtos;

public interface ProdutosDAO extends JpaRepository<Produtos, Integer>{
	
	public List<Produtos> findByNomeContaining(String nome);
	public Page<Produtos> findByOrderByNomeAsc(Pageable page);
	
}
