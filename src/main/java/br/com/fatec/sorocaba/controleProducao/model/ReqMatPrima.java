package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReqMatPrima {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqMatPrima;
	@OneToOne
	private ProdutoOrdem produtoOrdem;
	
	public Long getCodReqMatPrima() {
		return codReqMatPrima;
	}
	public void setCodReqMatPrima(Long codReqMatPrima) {
		this.codReqMatPrima = codReqMatPrima;
	}
	public ProdutoOrdem getProdutoOrdem() {
		return produtoOrdem;
	}
	public void setProdutoOrdem(ProdutoOrdem produtoOrdem) {
		this.produtoOrdem = produtoOrdem;
	}
}
