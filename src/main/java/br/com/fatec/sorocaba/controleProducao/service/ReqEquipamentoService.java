package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.ReqEquipamento;
import br.com.fatec.sorocaba.controleProducao.repository.ReqEquipamentoRepository;

@Service
public class ReqEquipamentoService {

	@Autowired
	private ReqEquipamentoRepository reqEquipamentoRepository;
	
	@Transactional
	public ReqEquipamento save(ReqEquipamento reqEquipamento) {
		return reqEquipamentoRepository.saveAndFlush(reqEquipamento);
	}
	
	public List<ReqEquipamento> list(){
		return reqEquipamentoRepository.findAll();
	}
}
