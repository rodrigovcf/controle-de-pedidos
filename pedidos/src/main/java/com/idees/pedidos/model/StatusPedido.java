package com.idees.pedidos.model;

public enum StatusPedido {
	
	PENDENTE("Pendente"),
	CANCELADO("Cancelado"),
	ENTREGUE("Entregue");
	
	private String descricao;
	
	StatusPedido(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;  
	}
	

}
