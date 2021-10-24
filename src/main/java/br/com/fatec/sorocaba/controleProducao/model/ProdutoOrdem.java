package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProdutoOrdem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdOrdem;
	private Integer qtdProd;
	@OneToMany(mappedBy = "produtoOrdem", cascade=CascadeType.ALL)
	private List<Ordem> ordens;
	
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

	public List<Ordem> getOrdens() {
		return ordens;
	}
	
	public void setOrdens(List<Ordem> ordens) {
		this.ordens = ordens;
	}
}
