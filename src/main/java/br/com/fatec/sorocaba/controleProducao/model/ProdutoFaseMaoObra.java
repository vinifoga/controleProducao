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
public class ProdutoFaseMaoObra {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseMaoObra;
	private Integer qtdeMO;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToMany(mappedBy="produtoFaseMaoObra", cascade=CascadeType.ALL)
	private List<MaoObra> maoObra;
	@OneToMany(mappedBy="produtoFaseMaoObra", cascade=CascadeType.ALL)
	private List<MaoObraReq> maoObraReq;
	
	public Long getCodProdFaseMaoObra() {
		return codProdFaseMaoObra;
	}
	public void setCodProdFaseMaoObra(Long codProdFaseMaoObra) {
		this.codProdFaseMaoObra = codProdFaseMaoObra;
	}
	public Integer getQtdeMO() {
		return qtdeMO;
	}
	public void setQtdeMO(Integer qtdeMO) {
		this.qtdeMO = qtdeMO;
	}
	public ProdutoFase getProdutoFase() {
		return produtoFase;
	}
	public void setProdutoFase(ProdutoFase produtoFase) {
		this.produtoFase = produtoFase;
	}
	
	public List<MaoObra> getMaoObra() {
		return maoObra;
	}
	public void setMaoObra(List<MaoObra> maoObra) {
		this.maoObra = maoObra;
	}
	
	public List<MaoObraReq> getMaoObraReq() {
		return maoObraReq;
	}
	public void setMaoObraReq(List<MaoObraReq> maoObraReq) {
		this.maoObraReq = maoObraReq;
	}
	
	
}
