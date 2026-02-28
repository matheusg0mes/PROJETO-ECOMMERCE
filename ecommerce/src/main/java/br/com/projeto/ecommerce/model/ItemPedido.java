package br.com.projeto.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="tbl_itempedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_seq")
	private Integer id;
	
	@Column(name = "valor_unitario")
	private Double valorUnitario;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name ="valor_total")
	private Double valorTotal;
	
	@ManyToOne
	@JsonIgnoreProperties("itemPedido")
	@JoinColumn(name = "tbl_pedido_id_pedido")
	private Pedidos pedido;
	
	@ManyToOne
	@JoinColumn(name ="tbl_variante_produto_id_variante_produto")
	private Variantes variante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Variantes getVariante() {
		return variante;
	}

	public void setVariante(Variantes variante) {
		this.variante = variante;
	}
	
	

}
