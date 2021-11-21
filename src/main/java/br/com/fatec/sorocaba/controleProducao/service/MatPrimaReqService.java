package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.MatPrimaReq;
import br.com.fatec.sorocaba.controleProducao.model.ReqMatPrima;
import br.com.fatec.sorocaba.controleProducao.repository.MatPrimaReqRepository;

@Service
public class MatPrimaReqService {

	@Autowired
	private MatPrimaReqRepository matPrimaReqRepository;
	
	@Autowired
	private ReqMatPrimaService reqMPService;
	
	@Transactional
	public MatPrimaReq save(MatPrimaReq matPrimaReq, ReqMatPrima requisicaoMP) {
		reqMPService.save(requisicaoMP);
		return matPrimaReqRepository.saveAndFlush(matPrimaReq);
	}
	
	public List<MatPrimaReq> list(){
		return matPrimaReqRepository.findAll();
	}
}
