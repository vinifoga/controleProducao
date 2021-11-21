package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoFaseMaoObra {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseMaoObra;
	private Integer qtdeMO;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToOne
	private MaoObra maoObra;
	@OneToOne(mappedBy="produtoFaseMaoObra", cascade=CascadeType.ALL)
	private MaoObraReq maoObraReq;
	
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
	
	public MaoObra getMaoObra() {
		return maoObra;
	}
	public void setMaoObra(MaoObra maoObra) {
		this.maoObra = maoObra;
	}
	
	public MaoObraReq getMaoObraReq() {
		return maoObraReq;
	}
	
	public void setMaoObraReq(MaoObraReq maoObraReq) {
		this.maoObraReq = maoObraReq;
	}
	
	
}
