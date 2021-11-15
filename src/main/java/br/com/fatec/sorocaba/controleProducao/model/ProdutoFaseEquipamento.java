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
public class ProdutoFaseEquipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseEquip;
	private Integer qtdeEq;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToMany(mappedBy="produtoFaseEquipamento", cascade=CascadeType.ALL)
	private List<Equipamento> equipamento;
	@OneToMany(mappedBy="produtoFaseEquipamento", cascade=CascadeType.ALL)
	private List<EquipamentoReq> equipamentoReq;
	
	public Long getCodProdFaseEquip() {
		return codProdFaseEquip;
	}
	public void setCodProdFaseEquip(Long codProdFaseEquip) {
		this.codProdFaseEquip = codProdFaseEquip;
	}
	public Integer getQtdeEq() {
		return qtdeEq;
	}
	public void setQtdeEq(Integer qtdeEq) {
		this.qtdeEq = qtdeEq;
	}
	public ProdutoFase getProdutoFase() {
		return produtoFase;
	}
	public void setProdutoFase(ProdutoFase produtoFase) {
		this.produtoFase = produtoFase;
	}
	
	public List<Equipamento> getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(List<Equipamento> equipamento) {
		this.equipamento = equipamento;
	}
	
	public List<EquipamentoReq> getEquipamentoReq() {
		return equipamentoReq;
	}
	public void setEquipamentoReq(List<EquipamentoReq> equipamentoReq) {
		this.equipamentoReq = equipamentoReq;
	}
	
	
}
