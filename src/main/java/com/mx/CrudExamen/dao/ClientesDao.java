package com.mx.CrudExamen.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudExamen.model.Clientes;

public interface ClientesDao extends  CrudRepository<Clientes, Integer> {

}
