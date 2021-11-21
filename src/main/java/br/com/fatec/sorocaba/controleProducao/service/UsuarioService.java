package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	public List<Usuario> list() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
}
