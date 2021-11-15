package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoOrdem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdOrdem;
	private Integer qtdProd;
	@ManyToOne
	private Ordem ordem;
	@ManyToOne
	private Produto produto;
	@OneToOne(cascade = CascadeType.ALL)
	private ReqMaoObra reqMaoObra;
	@OneToOne(cascade = CascadeType.ALL)
	private ReqMatPrima reqMatPrima;
	@OneToOne(cascade = CascadeType.ALL)
	private ReqEquipamento reqEquipamento;
	
	public Long getCodProdOrdem() {
		return codProdOrdem;
	}
	public void setCodProdOrdem(Long codProdOrdem) {
		this.codProdOrdem = codProdOrdem;
	}
	
	public Integer getQtdProd() {
		return qtdProd;
	}
	public void setQtdProd(Integer qtdProd) {
		this.qtdProd = qtdProd;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Ordem getOrdem() {
		return ordem;
	}
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
}
