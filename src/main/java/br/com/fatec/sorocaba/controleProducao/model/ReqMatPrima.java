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
public class ReqMatPrima {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqMatPrima;
	@OneToOne(mappedBy = "reqMatPrima")
	private ProdutoOrdem produtoOrdem;
	@OneToMany(mappedBy = "reqMatPrima", cascade=CascadeType.ALL)
	private List<MatPrimaReq> matPrimaReq;
	
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
	
	public List<MatPrimaReq> getMatPrimaReq() {
		return matPrimaReq;
	}
	public void setMatPrimaReq(List<MatPrimaReq> matPrimaReq) {
		this.matPrimaReq = matPrimaReq;
	}
	
	
}
