package br.com.fatec.sorocaba.controleProducao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.sorocaba.controleProducao.model.Usuario;

@Controller
public class ControleProducaoWebController {

	@GetMapping("/usuarios")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", new Usuario());
		modelAndView.setViewName("usuarios/index");
		return modelAndView;
	}
}
