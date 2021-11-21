package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MatPrimaReq {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMatPrimaReq;
	private String unidMedida;
	@ManyToOne
	private ReqMatPrima reqMatPrima;
	@ManyToOne
	private ProdutoFaseMat produtoFaseMatPrima;
	
	
	public Long getCodMatPrimaReq() {
		return codMatPrimaReq;
	}
	public void setCodMatPrimaReq(Long codMatPrimaReq) {
		this.codMatPrimaReq = codMatPrimaReq;
	}

	public String getUnidMedida() {
		return unidMedida;
	}
	public void setUnidMedida(String unidMedida) {
		this.unidMedida = unidMedida;
	}
	public ReqMatPrima getReqMatPrima() {
		return reqMatPrima;
	}
	public void setReqMatPrima(ReqMatPrima reqMatPrima) {
		this.reqMatPrima = reqMatPrima;
	}
	
	public ProdutoFaseMat getProdutoFaseMatPrima() {
		return produtoFaseMatPrima;
	}
	public void setProdutoFaseMatPrima(ProdutoFaseMat produtoFaseMatPrima) {
		this.produtoFaseMatPrima = produtoFaseMatPrima;
	}
	
	
	
}
