package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.EquipamentoReq;
import br.com.fatec.sorocaba.controleProducao.model.ReqEquipamento;
import br.com.fatec.sorocaba.controleProducao.repository.EquipamentoReqRepository;
import br.com.fatec.sorocaba.controleProducao.repository.ReqEquipamentoRepository;

@Service
public class EquipamentoReqService {

	@Autowired
	private EquipamentoReqRepository equipamentoReqRepository;
	
	@Autowired
	private ReqEquipamentoService reqEquipamentoService;
	
	@Transactional
	public EquipamentoReq save(EquipamentoReq equipamentoReq, ReqEquipamento reqEquipamento) {
		reqEquipamentoService.save(reqEquipamento);
		return equipamentoReqRepository.saveAndFlush(equipamentoReq);
	}
	
	public List<EquipamentoReq> list(){
		return equipamentoReqRepository.findAll();
	}
	
	
}
