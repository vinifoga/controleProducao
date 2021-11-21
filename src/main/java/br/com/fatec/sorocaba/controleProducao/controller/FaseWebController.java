package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;
import br.com.fatec.sorocaba.controleProducao.service.EquipamentoService;
import br.com.fatec.sorocaba.controleProducao.service.FaseService;
import br.com.fatec.sorocaba.controleProducao.service.MaoDeObraService;
import br.com.fatec.sorocaba.controleProducao.service.MateriaPrimaService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoFaseEquipamentoService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoFaseService;
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
	
	@Autowired
	private ProdutoFaseEquipamentoService produtoFaseEquipamentoService;
	
	@Autowired
	private ProdutoFaseService produtoFaseService;

	@GetMapping("/fases")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("fases/index");
		return modelAndView;
	}

	@GetMapping("/fases/produto/{idProduto}")
	public ModelAndView faseProduto(@PathVariable("idProduto") Long idProduto, HttpServletRequest request,
			HttpServletResponse response) {
		Produto produto = produtoService.findById(idProduto);	
		ModelAndView modelAndView = new ModelAndView();			
		modelAndView.addObject("fase", new Fase());		
		modelAndView.addObject("produto", produto);
		modelAndView.addObject("produtoFase", new ProdutoFase());
		List<ProdutoFase> produtosFase = produtoFaseService.list().stream().filter(pf -> pf.getProduto().getCodProduto().equals(idProduto)).collect(Collectors.toList());
		modelAndView.addObject("fasesProduto", produtosFase);
		modelAndView.setViewName("fases/produto");
		return modelAndView;
	}
	
	@GetMapping("**/fases/addMP/{codFaseProd}")
	public ModelAndView addMP(@PathVariable("codFaseProd") Long idFaseProd, HttpServletRequest request,
			HttpServletResponse response) {
		ProdutoFase pf = produtoFaseService.findById(idFaseProd);
		ModelAndView modelAndView = new ModelAndView();			
		modelAndView.addObject("produtoFase", pf);
		modelAndView.addObject(materiaPrimaService.list());
		modelAndView.setViewName("fases/addMP");
		return modelAndView;
	}


	@PostMapping("/fases")
	public ModelAndView save(@Valid Fase fase, @Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

		try {
			ProdutoFase pf = new ProdutoFase();
			Produto produtoBanco = produtoService.findById(produto.getCodProduto());
			pf.setFase(fase);
			pf.setProduto(produto);
			produtoFaseService.save(pf, produtoBanco, fase);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
System.out.println(produto.getCodProduto());
		ModelAndView mv = new ModelAndView("redirect:/fases/produto/" + produto.getCodProduto());
		
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
	public ModelAndView novoRecurso(@PathVariable("numFase") Long numFase, HttpServletRequest request,
			HttpServletResponse response) {
		Fase fase = faseService.findById(numFase).get();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mps", materiaPrimaService.list());
		modelAndView.addObject("fase", fase);
		modelAndView.setViewName("fases/matPrima");
		return modelAndView;

	}

	@PostMapping("/fases/addMP/{numFase}")
	public ModelAndView salvaMP(@PathVariable("numFase") Long numFase, HttpServletRequest request,
			HttpServletResponse responde) {

		return null;

	}

}
