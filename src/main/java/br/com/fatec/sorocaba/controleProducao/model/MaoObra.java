package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MaoObra {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String descricao;	
	@ManyToOne
	private ProdutoFaseMaoObra produtoFaseMaoObra;

	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ProdutoFaseMaoObra getProdutoFaseMaoObra() {
		return produtoFaseMaoObra;
	}
	public void setProdutoFaseMaoObra(ProdutoFaseMaoObra produtoFaseMaoObra) {
		this.produtoFaseMaoObra = produtoFaseMaoObra;
	}
	
}
