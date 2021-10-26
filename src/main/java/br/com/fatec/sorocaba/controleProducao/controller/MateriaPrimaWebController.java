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

import br.com.fatec.sorocaba.controleProducao.model.MatPrima;
import br.com.fatec.sorocaba.controleProducao.service.MateriaPrimaService;

@Controller
public class MateriaPrimaWebController {
	
	@Autowired
	private MateriaPrimaService materiaPrimaService;

	@GetMapping("/materia-prima")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("materia-prima", new MatPrima());
		modelAndView.setViewName("materia-prima/index");
		return modelAndView;
	}
	
	@PostMapping("/materia-prima")
	public ModelAndView save(@Valid MatPrima materiaPrima, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-materia-prima");
		
		try {
			materiaPrimaService.save(materiaPrima);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-materia-prima")
	public ModelAndView list() {
		List<MatPrima> materiasPrima = materiaPrimaService.list();
		ModelAndView mv = new ModelAndView("materia-prima/list");
		mv.addObject("materias", materiasPrima);
		return mv;
	}	
	
}
