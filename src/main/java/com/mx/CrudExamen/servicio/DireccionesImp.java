package com.mx.CrudExamen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudExamen.dao.DireccionesDao;

import com.mx.CrudExamen.model.Direcciones;

@Service
public class DireccionesImp implements DireccionServ {

	@Autowired
	DireccionesDao dirDao;

	@Override
	public boolean crear(Direcciones direccion) {
		boolean rest = true;

		for (Direcciones d : dirDao.findAll()) {
			if (d.getId() == direccion.getId()) {
				rest = false;
				break;
			}
		}

		if (rest) {
			dirDao.save(direccion);
		}
		return rest;
	}

	@Override
	public List<Direcciones> listar() {
		// TODO Auto-generated method stub
		return (List<Direcciones>) dirDao.findAll();
	}
}
