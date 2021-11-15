package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProdutoFase {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdutoFase;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Fase fase;
	@OneToMany(mappedBy="produtoFase", cascade=CascadeType.ALL)
	private List<ProdutoFaseMaoObra> produtoFaseMaoObra;
	@OneToMany(mappedBy="produtoFase", cascade=CascadeType.ALL)
	private List<ProdutoFaseMat> produtoFasemat;
	@OneToMany(mappedBy="produtoFase", cascade=CascadeType.ALL)
	private List<ProdutoFaseEquipamento> produtoFaseEquipamento;
	
	
	public Long getCodProdutoFase() {
		return codProdutoFase;
	}
	public void setCodProdutoFase(Long codProdutoFase) {
		this.codProdutoFase = codProdutoFase;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Fase getFase() {
		return fase;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	public List<ProdutoFaseMaoObra> getProdutoFaseMaoObra() {
		return produtoFaseMaoObra;
	}
	public void setProdutoFaseMaoObra(List<ProdutoFaseMaoObra> produtoFaseMaoObra) {
		this.produtoFaseMaoObra = produtoFaseMaoObra;
	}
	public List<ProdutoFaseMat> getProdutoFasemat() {
		return produtoFasemat;
	}
	public void setProdutoFasemat(List<ProdutoFaseMat> produtoFasemat) {
		this.produtoFasemat = produtoFasemat;
	}
	public List<ProdutoFaseEquipamento> getProdutoFaseEquipamento() {
		return produtoFaseEquipamento;
	}
	public void setProdutoFaseEquipamento(List<ProdutoFaseEquipamento> produtoFaseEquipamento) {
		this.produtoFaseEquipamento = produtoFaseEquipamento;
	}
	
	
	
}
