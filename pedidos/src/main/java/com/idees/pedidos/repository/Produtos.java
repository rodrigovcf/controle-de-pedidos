package com.idees.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idees.pedidos.model.Produto;

//Entidade e tipo de ID
public interface Produtos extends JpaRepository<Produto, Long>{

}
