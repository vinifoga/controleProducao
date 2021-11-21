package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReqEquipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqEq;
	@OneToOne
	private ProdutoOrdem produtoOrdem;
	
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
	
}
