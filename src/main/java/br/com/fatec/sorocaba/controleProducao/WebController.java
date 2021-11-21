package br.com.fatec.sorocaba.controleProducao;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Fase;
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;
import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.model.UsuarioRecuperaSenha;
import br.com.fatec.sorocaba.controleProducao.service.UsuarioService;

@Controller
public class WebController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/homeLogado")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails usuario;
		usuario = ((UserDetails)principal);		
		modelAndView.addObject("usuario", usuario.getUsername());
		modelAndView.setViewName("/homeLogado");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("/login");
		return modelAndView;
	}
	
	@GetMapping("/403")
	public ModelAndView forbidden() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("/403");
		return modelAndView;
	}
	
	@GetMapping("/emailEnviado")
	public ModelAndView emailEnviado() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("/emailEnviado");
		return modelAndView;
	}
	
	@GetMapping("/reset-senha")
	public ModelAndView resetSenha() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", new UsuarioRecuperaSenha());
		modelAndView.setViewName("/resetSenha");
		return modelAndView;
	}
	
	@PostMapping("/reset-senha")
	public ModelAndView save(@Valid UsuarioRecuperaSenha usuario, BindingResult result, RedirectAttributes attributes) {		
		Usuario usuarioBanco = usuarioService.findByEmail(usuario.getEmail());
		ModelAndView mv = new ModelAndView("redirect:/emailEnviado");	
		System.out.println("localhost:8081/nova-senha/"+usuarioBanco.getId());
		return mv;
	}
	
	@GetMapping("**/nova-senha/{id}")
	public ModelAndView recuperarSenha(@PathVariable("id") Long idUsuario, HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = usuarioService.list().stream().filter(u -> u.getId().equals(idUsuario)).findAny().get();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("/novaSenha");
		return modelAndView;		
	}
	
	@PostMapping("/nova-senha")
	public ModelAndView novaSenha(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		Usuario usuarioBanco = usuarioService.list().stream().filter(u -> u.getId().equals(usuario.getId())).findAny().get();
		usuarioBanco.setSenha(usuario.getSenha());
		usuarioService.save(usuarioBanco);
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
	}
	
	
	
	
}
