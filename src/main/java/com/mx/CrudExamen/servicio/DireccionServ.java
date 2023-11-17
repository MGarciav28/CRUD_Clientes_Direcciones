package com.mx.CrudExamen.servicio;

import java.util.List;

import com.mx.CrudExamen.model.Direcciones;

public interface DireccionServ {
	public boolean crear(Direcciones direccion);
	public List<Direcciones> listar();
}
