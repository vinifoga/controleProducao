package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Fase;
import br.com.fatec.sorocaba.controleProducao.service.FaseService;

@Controller
public class FaseWebController {
	
	@Autowired
	private FaseService faseService;

	@GetMapping("/fases")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("fases/index");
		return modelAndView;
	}
	
	@PostMapping("/fases")
	public ModelAndView save(@Valid Fase fase, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-fase");
		
		try {
			faseService.save(fase);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-fases")
	public ModelAndView list() {
		List<Fase> fases = faseService.list();
		ModelAndView mv = new ModelAndView("fases/list");
		mv.addObject("fases", fases);
		return mv;
	}
	
	@GetMapping("/fases/recurso/{descricao}/{recurso}")
	public ModelAndView novoRecurso(@PathVariable("descricao") String descricao, @PathVariable("recurso") String recurso, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("fase", new Fase());
		modelAndView.setViewName("fasesRecurso/index");
		return modelAndView;
	}
	
}
