package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MatPrima {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String descricao;
	private String unidadeMedida;
	@ManyToOne
	private ProdutoFaseMat produtoFaseMatPrima;

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

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public ProdutoFaseMat getProdutoFaseMatPrima() {
		return produtoFaseMatPrima;
	}
	public void setProdutoFaseMatPrima(ProdutoFaseMat produtoFaseMatPrima) {
		this.produtoFaseMatPrima = produtoFaseMatPrima;
	}
}
