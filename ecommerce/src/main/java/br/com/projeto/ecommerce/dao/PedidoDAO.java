package br.com.projeto.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.ecommerce.model.Pedidos;

@Repository
public interface PedidoDAO extends CrudRepository<Pedidos,Integer > {

}
