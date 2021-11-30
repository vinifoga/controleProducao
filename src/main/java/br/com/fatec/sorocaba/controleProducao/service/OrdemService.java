package br.com.fatec.sorocaba.controleProducao.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.EquipamentoReq;
import br.com.fatec.sorocaba.controleProducao.model.MaoObra;
import br.com.fatec.sorocaba.controleProducao.model.MaoObraReq;
import br.com.fatec.sorocaba.controleProducao.model.MatPrimaReq;
import br.com.fatec.sorocaba.controleProducao.model.Ordem;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFaseEquipamento;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFaseMaoObra;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFaseMat;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.model.ReqEquipamento;
import br.com.fatec.sorocaba.controleProducao.model.ReqMaoObra;
import br.com.fatec.sorocaba.controleProducao.model.ReqMatPrima;
import br.com.fatec.sorocaba.controleProducao.repository.OrdemRepository;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoOrdemRepository;

@Service
public class OrdemService {

	@Autowired
	private OrdemRepository ordemRepository;	
	
	@Autowired
	private EquipamentoReqService equipamentoReqService;
	
	@Autowired
	private ReqEquipamentoService reqEquipamentoService;
	
	@Autowired
	private MaoObraReqService maoObraReqService;
	
	@Autowired
	private ReqMOService reqMoService;
	
	@Autowired
	private MatPrimaReqService matPrimaReqService;
	
	@Autowired
	private ReqMatPrimaService reqMatPrimaService;
	
	@Transactional
	public Ordem save(Ordem ordem) {
		return ordemRepository.saveAndFlush(ordem);
	}

	public List<Ordem> list() {
		return ordemRepository.findAll();
	}
	
	public Ordem findById(Long id) {
		return ordemRepository.findById(id).get();
	}

	public void gerarRequisicoes(ProdutoOrdem produtoOrdem) {
		List<ProdutoFase> produtosFase = produtoOrdem.getProduto().getProdutosFase();
		for (ProdutoFase produtoFase : produtosFase) {
			List<ProdutoFaseEquipamento> produtosFaseEquipamento = produtoFase.getProdutoFaseEquipamento();
			for (ProdutoFaseEquipamento  produtoFaseEquipamento: produtosFaseEquipamento) {
				Integer qtdeEq = produtoFaseEquipamento.getQtdeEq();
				for(int i=0; i<=qtdeEq; i++) {
					ReqEquipamento requisicaoEquipamento = new ReqEquipamento();
					requisicaoEquipamento.setProdutoOrdem(produtoOrdem);
					EquipamentoReq equipamentoReq = new EquipamentoReq();
					equipamentoReq.setProdutoFaseEquipamento(produtoFaseEquipamento);
					equipamentoReq.setTempoUso(produtoFaseEquipamento.getEquipamento().getTempoUso());
					equipamentoReq.setUnidadeMedida(produtoFaseEquipamento.getEquipamento().getUnidadeMedida());
					equipamentoReq.setReqEquipamento(requisicaoEquipamento);
//					reqEquipamentoService.save(requisicaoEquipamento);
					equipamentoReqService.save(equipamentoReq, requisicaoEquipamento);	
					
				}
				
			}
			List<ProdutoFaseMaoObra> produtosFaseMaoObra = produtoFase.getProdutoFaseMaoObra();
			for (ProdutoFaseMaoObra produtoFaseMaoObra : produtosFaseMaoObra) {
				Integer qtdeMO = produtoFaseMaoObra.getQtdeMO();
				for(int i=0; i<=qtdeMO; i++) {
					ReqMaoObra requisicaoMO = new ReqMaoObra();
					requisicaoMO.setProdutoOrdem(produtoOrdem);
					MaoObraReq maoObraReq = new MaoObraReq();
					maoObraReq.setProdutoFaseMaoObra(produtoFaseMaoObra);
					maoObraReq.setTempoTrabalhado(produtoFaseMaoObra.getMaoObra().getTempoTrabalho());
					maoObraReq.setUnidadeMedida(produtoFaseMaoObra.getMaoObra().getUnidadeMedida());
					maoObraReq.setReqMaoObra(requisicaoMO);
//					reqMoService.save(requisicaoMO);
					maoObraReqService.save(maoObraReq, requisicaoMO);					
				}
				
			}
			List<ProdutoFaseMat> produtosFasemat = produtoFase.getProdutoFasemat();
			for (ProdutoFaseMat produtoFasemat : produtosFasemat) {
				Double qtdeMP = produtoFasemat.getQtdeMP();
				for(int i=0; i<=qtdeMP; i++) {
					ReqMatPrima requisicaoMP = new ReqMatPrima();
					requisicaoMP.setProdutoOrdem(produtoOrdem);
					MatPrimaReq matPrimaReq = new MatPrimaReq();
					matPrimaReq.setProdutoFaseMatPrima(produtoFasemat);
					matPrimaReq.setUnidMedida(produtoFasemat.getMatPrima().getUnidadeMedida());
					matPrimaReq.setReqMatPrima(requisicaoMP);
//					reqMatPrimaService.save(requisicaoMP);
					matPrimaReqService.save(matPrimaReq, requisicaoMP);
				}
				
			}
		}
		
	}
	
}
