package com.mx.CrudExamen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "CLIENTESS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Clientes {
	// Mapeo
	/*
	 * ID NUMBER PRIMARY KEY NOT NULL, NUM_CLIENTE NUMBER NOT NULL, NOMBRE
	 * NVARCHAR2(100) NOT NULL, APP NVARCHAR2(100) NOT NULL, APM NVARCHAR2(100) NOT
	 * NULL, CELULAR NUMBER NOT NULL, CORREO NVARCHAR2(50) NOT NULL, ESTATUS NUMBER
	 * NOT NULL, ----1---ACTIVO ---2-- INACTIVO --- 3 BUROCREDITO ID_DIRECCION
	 * NUMBER NOT NULL,
	 */

	@Id
	private int id;
	private int num_cliente;
	private String nombre;
	private String app;
	private String apm;
	private long celular;
	private String correo;
	private int estatus;

	// Cardinalidad
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DIRECCION")
	Direcciones direccion;

}
