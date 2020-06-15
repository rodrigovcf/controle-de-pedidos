package com.idees.pedidos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idees.pedidos.model.Pedido;
import com.idees.pedidos.model.StatusPedido;
import com.idees.pedidos.repository.Pedidos;


@Controller
@RequestMapping ("/pedidos")
public class PedidoController {
	
	//Gera uma instância de Pedidos 
	@Autowired
	private Pedidos pedidos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroPedido");
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Pedido pedido) {
		pedidos.save(pedido);
		
		ModelAndView mv = new ModelAndView("CadastroPedido");
		mv.addObject("mensagem", "Pedido salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Pedido> todosPedidos = pedidos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaPedido");
		mv.addObject("pedidos", todosPedidos);
		return mv;
	}
	
	@ModelAttribute("todosStatusPedido")
	public List<StatusPedido> todosStatusPedido(){
		return Arrays.asList(StatusPedido.values());
	}
}
