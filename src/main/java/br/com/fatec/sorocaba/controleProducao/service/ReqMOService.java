package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.ReqMaoObra;
import br.com.fatec.sorocaba.controleProducao.repository.ReqMORepository;

@Service
public class ReqMOService {

	@Autowired
	private ReqMORepository reqMORepository;
	
	@Transactional
	public ReqMaoObra save (ReqMaoObra reqMO) {
		return reqMORepository.saveAndFlush(reqMO);
	}
	
	public List<ReqMaoObra> list(){
		return reqMORepository.findAll();
	}
}
