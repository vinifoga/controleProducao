package br.com.fatec.sorocaba.controleProducao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@Autowired
	private UserDetailsService userDetailsService;
	
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
}
