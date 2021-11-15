package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numFase;
	private String descricao;
	@OneToMany(mappedBy = "fase", cascade = CascadeType.ALL)
	private List<ProdutoFase> produtosFase;

	public Long getNumFase() {
		return numFase;
	}

	public void setNumFase(Long numFase) {
		this.numFase = numFase;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoFase> getProdutosFase() {
		return produtosFase;
	}

	public void setProdutosFase(List<ProdutoFase> produtosFase) {
		this.produtosFase = produtosFase;
	}

}
