package com.example.esme.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelTest {

	private RolModel rolModel;
	private PersonaModel personaModel;

	@BeforeEach
	public void init() {
		this.rolModel = new RolModel();
		this.personaModel = new PersonaModel();
	}

	@Test
	public void rolModelTest() {

		Integer id = 1;
		String nombreRol = "Administrador";
		String descripcion = "acceso a todas las opciones";
		LocalDateTime fechaCreacion = LocalDateTime.now();
		LocalDateTime fechaModificacion = LocalDateTime.now();

		this.rolModel.setId(id);
		this.rolModel.setNombreRol(nombreRol);
		this.rolModel.setDescripcion(descripcion);
		this.rolModel.setFechaCreacion(fechaCreacion);
		this.rolModel.setFechaModificacion(fechaModificacion);

		assertEquals(id, this.rolModel.getId());
		assertEquals(nombreRol, this.rolModel.getNombreRol());
		assertEquals(descripcion, this.rolModel.getDescripcion());
		assertEquals(fechaCreacion, this.rolModel.getFechaCreacion());
		assertEquals(fechaModificacion, this.rolModel.getFechaModificacion());
	}

	@Test
	public void personaModelTest() {
		Integer id = 1;
		Integer documento = 123;
		String nombre = "Esme";
		String apellidos = "Diaz";
		LocalDate fechaNacimiento = LocalDate.parse("1993-07-10");
		LocalDateTime fechaCreacion = LocalDateTime.now();
		LocalDateTime fechaModificacion = LocalDateTime.now();

		RolModel rol = new RolModel();

		this.personaModel.setId(id);
		this.personaModel.setDocumento(documento);
		this.personaModel.setNombre(nombre);
		this.personaModel.setApellidos(apellidos);
		this.personaModel.setFechaNacimiento(fechaNacimiento);
		this.personaModel.setFechaCreacion(fechaCreacion);
		this.personaModel.setFechaModificacion(fechaModificacion);
		this.personaModel.setRol(rol);

		assertEquals(id, this.personaModel.getId());
		assertEquals(documento, this.personaModel.getDocumento());
		assertEquals(nombre, this.personaModel.getNombre());
		assertEquals(apellidos, this.personaModel.getApellidos());
		assertEquals(fechaNacimiento, this.personaModel.getFechaNacimiento());
		assertEquals(fechaCreacion, this.personaModel.getFechaCreacion());
		assertEquals(fechaModificacion, this.personaModel.getFechaModificacion());
	}

}
