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

import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoService;

@Controller
public class ProdutoWebController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/produto")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produto", new Produto());
		modelAndView.setViewName("produto/index");
		return modelAndView;
	}
	
	@PostMapping("/produto")
	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-produto");
		
		try {
			produtoService.save(produto);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse usuário!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Usuário criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-produto")
	public ModelAndView list() {
		List<Produto> produtos = produtoService.list();
		ModelAndView mv = new ModelAndView("produto/list");
		mv.addObject("produtos", produtos);
		return mv;
	}	
	
}
