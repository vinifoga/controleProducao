package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.MaoObra;
import br.com.fatec.sorocaba.controleProducao.repository.MaoDeObraRepository;

@Service
public class MaoDeObraService {

	@Autowired
	private MaoDeObraRepository maoDeObraRepository;
	
	@Transactional
	public MaoObra save(MaoObra maoDeObra) {
		return maoDeObraRepository.saveAndFlush(maoDeObra);
	}

	public List<MaoObra> list() {
		return maoDeObraRepository.findAll();
	}
	
}
