package br.com.fatec.sorocaba.controleProducao.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ordem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codOp;
	@Enumerated(EnumType.STRING)
	private StatusOp status = StatusOp.EM_PREPARACAO;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataFim;
	@OneToMany(mappedBy = "ordem", cascade=CascadeType.ALL)
	private List<ProdutoOrdem> produtoOrdem;
	@ManyToOne
	private Colaborador colaborador;
	
	public Long getCodOp() {
		return codOp;
	}
	
	public void setCodOp(Long codOp) {
		this.codOp = codOp;
	}
	
	public StatusOp getStatus() {
		return status;
	}
	
	public void setStatus(StatusOp status) {
		this.status = status;
	}
	
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDateTime getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}
	
	public List<ProdutoOrdem> getProdutoOrdem() {
		return produtoOrdem;
	}
	public void setProdutoOrdem(List<ProdutoOrdem> produtoOrdem) {
		this.produtoOrdem = produtoOrdem;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
}
