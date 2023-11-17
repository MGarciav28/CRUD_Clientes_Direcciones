package com.mx.CrudExamen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudExamen.dao.ClientesDao;
import com.mx.CrudExamen.dao.DireccionesDao;
import com.mx.CrudExamen.model.Clientes;
import com.mx.CrudExamen.model.Direcciones;

@Service
public class ClientesImp implements ClientesServ {

	@Autowired
	ClientesDao cliDao;

	@Autowired
	DireccionesDao dirDao;

	@Override
	public String crear(Clientes cliente) {
		String respuesta = "Registro Correcto";
		boolean rest = true;
		boolean dir = false;

		for (Clientes c : cliDao.findAll()) {
			if (c.getId()==cliente.getId()) {
				respuesta = "Id duplicado";
				rest = false;
				break;
			} else if (c.getNum_cliente() == cliente.getNum_cliente()) {
				respuesta = "Numero de cliente Duplicado";
				rest = false;
				break;
			}else {
				for (Direcciones d : dirDao.findAll()) {
					if (cliente.getDireccion().getId()== d.getId()) {
						rest=true;
						respuesta = "Registro Correcto";
						break;
					}else {
						rest=false;
						respuesta = "Direccion no existe";
					}
				}				
			}
		}

		

		if (rest) {
			cliDao.save(cliente);
		}
		return respuesta;
	}

	@Override
	public void editar(Clientes cliente) {
		cliDao.save(cliente);

	}

	@Override
	public Clientes buscar(Clientes cliente) {
		// TODO Auto-generated method stub
		return cliDao.findById(cliente.getId()).orElse(null);
	}

	@Override
	public List<Clientes> listar() {

		return (List<Clientes>) cliDao.findAll();
	}

}
