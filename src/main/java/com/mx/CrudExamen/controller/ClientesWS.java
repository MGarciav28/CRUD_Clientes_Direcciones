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


import com.mx.CrudExamen.model.Clientes;
import com.mx.CrudExamen.servicio.ClientesImp;

@RequestMapping("ClientesWS")
@RestController
@CrossOrigin
public class ClientesWS {
	
	// http://localhost:9000/ClientesWS/listar
	
	@Autowired
	ClientesImp clientesImp;
	
	@GetMapping("listar")
	public List<Clientes> listar(){
		return clientesImp.listar();
	}
	
	@PostMapping("crear")
	public ResponseEntity<String> crear(@RequestBody Clientes cliente) {
		String respuesta = clientesImp.crear(cliente);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Clientes cliente) {
		clientesImp.editar(cliente);
	}
	
	@PostMapping("buscar")
	public Clientes buscar(@RequestBody Clientes cliente) {
		return clientesImp.buscar(cliente);
	}
}
