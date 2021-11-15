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
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.service.EquipamentoService;
import br.com.fatec.sorocaba.controleProducao.service.FaseService;
import br.com.fatec.sorocaba.controleProducao.service.MaoDeObraService;
import br.com.fatec.sorocaba.controleProducao.service.MateriaPrimaService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoService;

@Controller
public class FaseWebController {
	
	@Autowired
	private FaseService faseService;
	
	@Autowired
	private MateriaPrimaService materiaPrimaService;
	
	@Autowired
	private MaoDeObraService maoDeObraService;
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/fases")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("fases/index");
		return modelAndView;
	}
	
	@PostMapping("/fases")
	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		
		try {
			Fase fase = new Fase();

		} catch (Exception e) {
			System.out.println(e);
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");

		ModelAndView mv = new ModelAndView("redirect:/lista-fases");
		return mv;
	}
	
	@GetMapping("/lista-fases")
	public ModelAndView list() {
		List<Fase> fases = faseService.list();
		ModelAndView mv = new ModelAndView("fases/list");
		mv.addObject("fases", fases);
		return mv;
	}
	
	@GetMapping("/fases/addMP/{numFase}")
	public ModelAndView novoRecurso(@PathVariable("numFase") Long numFase, HttpServletRequest request, HttpServletResponse response) {
		Fase fase = faseService.findById(numFase).get();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mps", materiaPrimaService.list());		
		modelAndView.addObject("fase", fase);
		modelAndView.setViewName("fases/matPrima");
		return modelAndView;
	}
	
	@PostMapping("/fases/addMP/{numFase}")
	public ModelAndView salvaMP(@PathVariable("numFase") Long numFase, HttpServletRequest request, HttpServletResponse responde) {
		
		
		
		return null;
		
	}
	
}
