package com.mx.CrudExamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudExamen.model.Direcciones;
import com.mx.CrudExamen.servicio.DireccionesImp;

@RestController
@RequestMapping("DireccionesWS")
@CrossOrigin
public class DireccionesWS {
	
	@Autowired
	DireccionesImp dirImp;
	
	
	// http://localhost:9000/DireccionesWS/listar
	@GetMapping("listar")
	public List<Direcciones> listar() {
		return dirImp.listar();
	}
	
	// http://localhost:9000/DireccionesWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Direcciones direccion) {
		String respuesta = null;
		if(dirImp.crear(direccion)==false) {
			respuesta = "Este Id ya existe";
		}else respuesta="Guardado Correctamente";
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}

}
