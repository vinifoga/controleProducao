package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public void save(Usuario usuario) {
		System.out.println(usuario.getSenha().substring(0, 7));
		System.out.println("$2a$10$");
		if(!usuario.getSenha().substring(0, 7).contains("$2a$10$")) {
			String senha = usuario.getSenha();
			String senhaCripto = new BCryptPasswordEncoder().encode(senha);
			usuario.setSenha(senhaCripto);
			usuarioRepository.saveAndFlush(usuario);
		} else {
			System.out.println(usuario.getId());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getNome());
			System.out.println(usuario.isAtivo());
			usuarioRepository.updateUsuario(usuario.getId(), usuario.getEmail());			
		}
		
	}

	public List<Usuario> list() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void delete (Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
}
