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

import br.com.fatec.sorocaba.controleProducao.model.Colaborador;
import br.com.fatec.sorocaba.controleProducao.service.CargoService;
import br.com.fatec.sorocaba.controleProducao.service.ColaboradorService;

@Controller
public class ColaboradorWebController {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private CargoService cargoService;
	

	@GetMapping("/colaborador")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("colaborador", new Colaborador());
		modelAndView.addObject("cargos", cargoService.list());
		modelAndView.setViewName("colaborador/index");
		return modelAndView;
	}
	
	@PostMapping("/colaborador")
	public ModelAndView save(@Valid Colaborador colaborador, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-colaborador");
		
		try {
			colaboradorService.save(colaborador);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-colaborador")
	public ModelAndView list() {
		List<Colaborador> colaboradores = colaboradorService.list();
		ModelAndView mv = new ModelAndView("colaborador/list");
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}	

}
