package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MaoObraReq {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMaoObraReq;
	private Long tempoTrabalhado;
	private String unidadeMedida;
	@ManyToOne
	private ReqMaoObra reqMaoObra;
	@ManyToOne
	private ProdutoFaseMaoObra produtoFaseMaoObra;
	
	
	public Long getCodMaoObraReq() {
		return codMaoObraReq;
	}
	public void setCodMaoObraReq(Long codMaoObraReq) {
		this.codMaoObraReq = codMaoObraReq;
	}
	public Long getTempoTrabalhado() {
		return tempoTrabalhado;
	}
	public void setTempoTrabalhado(Long tempoTrabalhado) {
		this.tempoTrabalhado = tempoTrabalhado;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public ReqMaoObra getReqMaoObra() {
		return reqMaoObra;
	}
	public void setReqMaoObra(ReqMaoObra reqMaoObra) {
		this.reqMaoObra = reqMaoObra;
	}
	
	public ProdutoFaseMaoObra getProdutoFaseMaoObra() {
		return produtoFaseMaoObra;
	}
	public void setProdutoFaseMaoObra(ProdutoFaseMaoObra produtoFaseMaoObra) {
		this.produtoFaseMaoObra = produtoFaseMaoObra;
	}
	
	
	
	
}
