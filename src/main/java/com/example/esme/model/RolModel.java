package com.example.esme.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RolModel {

	private Integer id;
	private String nombreRol;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;

}
