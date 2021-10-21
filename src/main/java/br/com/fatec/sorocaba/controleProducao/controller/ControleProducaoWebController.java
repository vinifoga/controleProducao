package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.service.UsuarioService;

@Controller
public class ControleProducaoWebController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuario")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", new Usuario());
		modelAndView.setViewName("usuario/index");
		return modelAndView;
	}
	
	@PostMapping("/usuario")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/usuario/list");
		
		try {
			usuarioService.save(usuario);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse usuário!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Usuário criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("usuario/list")
	public ModelAndView list() {
		List<Usuario> usuarios = usuarioService.list();
		ModelAndView mv = new ModelAndView("usuario/list");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	
}
