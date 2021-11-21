package br.com.fatec.sorocaba.controleProducao;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
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
}
