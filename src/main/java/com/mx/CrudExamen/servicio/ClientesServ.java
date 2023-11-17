package com.mx.CrudExamen.servicio;

import java.util.List;

import com.mx.CrudExamen.model.Clientes;

public interface ClientesServ  {
public String crear(Clientes cliente);
public void editar(Clientes cliente);
public Clientes buscar(Clientes cliente);
public List<Clientes> listar();
}
