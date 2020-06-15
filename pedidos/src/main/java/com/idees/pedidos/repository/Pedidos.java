package com.idees.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idees.pedidos.model.Pedido;

//Entidade e tipo de ID
public interface Pedidos extends JpaRepository<Pedido, Long>{

}
