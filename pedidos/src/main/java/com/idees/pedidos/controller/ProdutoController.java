package com.idees.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idees.pedidos.model.Produto;
import com.idees.pedidos.repository.Produtos;

@Controller
@RequestMapping ("/produtos")
public class ProdutoController {
	
		//Gera uma instância de Produtos 
		@Autowired
		private Produtos produtos;

		@RequestMapping("/novo")
		public ModelAndView novo() {
			ModelAndView mv = new ModelAndView("CadastroProduto");
			return mv;
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ModelAndView salvar(Produto produto) {
			produtos.save(produto);
			
			ModelAndView mv = new ModelAndView("CadastroProduto");
			mv.addObject("mensagem", "Produto salvo com sucesso!");
			return mv;
		}
		
		@RequestMapping
		public ModelAndView pesquisar() {
			List<Produto> todosProdutos = produtos.findAll();
			ModelAndView mv = new ModelAndView("PesquisaProduto");
			mv.addObject("produtos", todosProdutos);
			return mv;
		}
		
				
}
