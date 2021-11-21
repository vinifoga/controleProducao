package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReqMaoObra {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqMO;
	@OneToOne
	private ProdutoOrdem produtoOrdem;	
	
	public Long getCodReqMO() {
		return codReqMO;
	}
	public void setCodReqMO(Long codReqMO) {
		this.codReqMO = codReqMO;
	}
	public ProdutoOrdem getProdutoOrdem() {
		return produtoOrdem;
	}
	public void setProdutoOrdem(ProdutoOrdem produtoOrdem) {
		this.produtoOrdem = produtoOrdem;
	}
	
}
