package com.mx.CrudExamen.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "DIRECCIONES")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Direcciones {
	// Mapear la tabla
	/*
	 * ID NUMBER PRIMARY KEY NOT NULL, CALLE NVARCHAR2(100) NOT NULL, NUM_EXT
	 * NUMBER, NUM_INT NUMBER
	 */

	@Id
	private int id;
	private String calle;
	private Integer num_ext;
	private Integer num_int;

	// Cardinalidad
	// @JsonIgnore---se utiliza en el nivel de campo para marcar una proiedad o
	// lista de proipiedades que va ser ignorada
	@OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Clientes> lista = new ArrayList<Clientes>();

}
