package com.example.esme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PersonaModel {

	private Integer id;
	private Integer documento;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;

	private RolModel rol;

}
