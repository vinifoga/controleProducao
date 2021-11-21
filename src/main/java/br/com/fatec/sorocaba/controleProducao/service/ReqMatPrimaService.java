package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.ReqMatPrima;
import br.com.fatec.sorocaba.controleProducao.repository.ReqMatPrimaRepository;

@Service
public class ReqMatPrimaService {

	@Autowired
	private ReqMatPrimaRepository reqMatPrimaRepository;
	
	@Transactional
	public ReqMatPrima save(ReqMatPrima reqMatPrima) {
		return reqMatPrimaRepository.saveAndFlush(reqMatPrima);
	}
	
	public List<ReqMatPrima> list(){
		return reqMatPrimaRepository.findAll();
	}
}
