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

import br.com.fatec.sorocaba.controleProducao.model.Equipamento;
import br.com.fatec.sorocaba.controleProducao.service.EquipamentoService;

@Controller
public class EquipamentoWebController {
	
	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamento")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("equipamento", new Equipamento());
		modelAndView.setViewName("equipamento/index");
		return modelAndView;
	}
	
	@PostMapping("/equipamento")
	public ModelAndView save(@Valid Equipamento equipamento, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-equipamento");
		
		try {
			equipamentoService.save(equipamento);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-equipamento")
	public ModelAndView list() {
		List<Equipamento> equipamentos = equipamentoService.list();
		ModelAndView mv = new ModelAndView("equipamento/list");
		mv.addObject("equipamentos", equipamentos);
		return mv;
	}	
	
}
