package com.idees.pedidos.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo; 
	
	private String nomeCliente;
	private String nomeBebe;
	
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@Enumerated(EnumType.STRING)
	private OrigemPedido origem;
	
	private String descProduto;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorTotal;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeBebe() {
		return nomeBebe;
	}
	public void setNomeBebe(String nomeBebe) {
		this.nomeBebe = nomeBebe;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public OrigemPedido getOrigem() {
		return origem;
	}
	public void setOrigem(OrigemPedido origem) {
		this.origem = origem;
	}
	private String obsPagamento;
	private String obsPedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getClienteNome() {
		return nomeCliente;
	}
	public void setClienteNome(String clienteNome) {
		this.nomeCliente = clienteNome;
	}
	public String getBebeNome() {
		return nomeBebe;
	}
	public void setBebeNome(String bebeNome) {
		this.nomeBebe = bebeNome;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public String getObsPagamento() {
		return obsPagamento;
	}
	public void setObsPagamento(String obsPagamento) {
		this.obsPagamento = obsPagamento;
	}
	public String getObsPedido() {
		return obsPedido;
	}
	public void setObsPedido(String obsPedido) {
		this.obsPedido = obsPedido;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	
	public String statusCollor() {
		String statusCollor;
		if (StatusPedido.PENDENTE.equals(this.status))
			statusCollor = "label-warning";
		else if (StatusPedido.ENTREGUE.equals(this.status))
			statusCollor = "label-success";
		else 
			statusCollor = "label-danger";
		return statusCollor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
	
}
