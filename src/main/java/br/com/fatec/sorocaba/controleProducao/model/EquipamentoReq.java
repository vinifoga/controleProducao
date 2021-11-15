package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipamentoReq {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codEquipReq;
	private Long tempoUso;
	private String unidadeMedida;
	@ManyToOne
	private ProdutoFaseEquipamento produtoFaseEquipamento;
	@ManyToOne
	private ReqEquipamento reqEquipamento;

	
	public Long getCodEquipReq() {
		return codEquipReq;
	}
	public void setCodEquipReq(Long codEquipReq) {
		this.codEquipReq = codEquipReq;
	}
	public Long getTempoUso() {
		return tempoUso;
	}
	public void setTempoUso(Long tempoUso) {
		this.tempoUso = tempoUso;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public ReqEquipamento getReqEquipamento() {
		return reqEquipamento;
	}
	public void setReqEquipamento(ReqEquipamento reqEquipamento) {
		this.reqEquipamento = reqEquipamento;
	}
	
	public ProdutoFaseEquipamento getProdutoFaseEquipamento() {
		return produtoFaseEquipamento;
	}
	public void setProdutoFaseEquipamento(ProdutoFaseEquipamento produtoFaseEquipamento) {
		this.produtoFaseEquipamento = produtoFaseEquipamento;
	}
	
	
}
