package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoFaseEquipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseEquip;
	private Integer qtdeEq;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToOne
	private Equipamento equipamento;
	@OneToOne(mappedBy="produtoFaseEquipamento", cascade=CascadeType.ALL)
	private EquipamentoReq equipamentoReq;
	
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
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public EquipamentoReq getEquipamentoReq() {
		return equipamentoReq;
	}
	public void setEquipamentoReq(EquipamentoReq equipamentoReq) {
		this.equipamentoReq = equipamentoReq;
	}	
}
