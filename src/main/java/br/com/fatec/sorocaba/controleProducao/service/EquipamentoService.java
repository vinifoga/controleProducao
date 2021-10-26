package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Equipamento;
import br.com.fatec.sorocaba.controleProducao.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Transactional
	public Equipamento save(Equipamento equipamento) {
		return equipamentoRepository.saveAndFlush(equipamento);
	}

	public List<Equipamento> list() {
		return equipamentoRepository.findAll();
	}
	
}
