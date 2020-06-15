package com.idees.pedidos.model;

public enum OrigemPedido {
	
	LOJA("Loja"),
	INSTAGRAM("Instagram"),
	WHATSAPP("Whatsapp");
	
	private String origem;
	
	OrigemPedido(String origem){
		this.origem = origem;
	}
	
	public String getDescricao() {
		return origem;  
	}

}
