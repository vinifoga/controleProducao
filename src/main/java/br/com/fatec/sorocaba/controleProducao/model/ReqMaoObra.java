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
public class ReqMaoObra {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReqMO;
	@OneToOne(mappedBy = "reqMaoObra")
	private ProdutoOrdem produtoOrdem;
	@OneToMany(mappedBy = "reqMaoObra", cascade=CascadeType.ALL)
	private List<MaoObraReq> maoObraReq;
	
	
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
	
	public List<MaoObraReq> getMaoObraReq() {
		return maoObraReq;
	}
	public void setMaoObraReq(List<MaoObraReq> maoObraReq) {
		this.maoObraReq = maoObraReq;
	}
	
	

}
