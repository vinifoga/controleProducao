package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.MaoObraReq;
import br.com.fatec.sorocaba.controleProducao.model.ReqMaoObra;
import br.com.fatec.sorocaba.controleProducao.repository.MaoObraReqRepository;

@Service
public class MaoObraReqService {

	@Autowired
	private MaoObraReqRepository maoObraReqRepository;
	
	@Autowired
	private ReqMOService reqMOService;
	
	@Transactional
	public MaoObraReq save (MaoObraReq maoObraReq, ReqMaoObra requisicaoMO) {
		reqMOService.save(requisicaoMO);
		return maoObraReqRepository.saveAndFlush(maoObraReq);
	}
	
	public List<MaoObraReq> list(){
		return maoObraReqRepository.findAll();
	}
	
	
}
