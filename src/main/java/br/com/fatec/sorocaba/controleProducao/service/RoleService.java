package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Role;
import br.com.fatec.sorocaba.controleProducao.repository.RoleRepository;


@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> list(){
		return roleRepository.findAll();
	}
	
	public Role findByNomeRole(String nomeRole) {
		return roleRepository.findById(nomeRole).get();
	}
	
	
	
	
}
