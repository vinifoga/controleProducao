package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ReqEquipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqEq;
	@OneToOne(mappedBy = "reqEquipamento")
	private ProdutoOrdem produtoOrdem;
	@OneToMany(mappedBy = "reqEquipamento", cascade = CascadeType.ALL)
	private List<EquipamentoReq> equipamentoReq; 
	
	public Long getCodReqEq() {
		return codReqEq;
	}
	public void setCodReqEq(Long codReqEq) {
		this.codReqEq = codReqEq;
	}
	public ProdutoOrdem getProdutoOrdem() {
		return produtoOrdem;
	}
	public void setProdutoOrdem(ProdutoOrdem produtoOrdem) {
		this.produtoOrdem = produtoOrdem;
	}
	
	public List<EquipamentoReq> getEquipamentoReq() {
		return equipamentoReq;
	}
	public void setEquipamentoReq(List<EquipamentoReq> equipamentoReq) {
		this.equipamentoReq = equipamentoReq;
	}
	
	
}
