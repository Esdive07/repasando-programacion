package com.example.esme.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.esme.model.RolModel;
import com.example.esme.service.RolService;

public class RolControllerTest {
	private RolController rolController;
	@Mock
	private RolService rolService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.rolController = new RolController(rolService);
	}

	@Test
	public void createRolTest() {
		RolModel rolModel = new RolModel();
		when(this.rolService.createRol(rolModel)).thenReturn(rolModel);
		ResponseEntity<RolModel> response = this.rolController.createRol(rolModel);
		assertNotNull(response);
	}

	@Test
	public void getAllRolTest() {
		RolModel rolModel = new RolModel();
		List<RolModel> listaModels = new ArrayList<>();
		listaModels.add(rolModel);

		when(this.rolService.getAllRol()).thenReturn(listaModels);
		ResponseEntity<List<RolModel>> response = this.rolController.getAllRol();
		assertNotNull(response);
	}

	@Test
	public void updateRolTest() {
		RolModel rolModel = new RolModel();
		Integer id = 1;
		when(this.rolService.updateRol(rolModel, id)).thenReturn(rolModel);
		ResponseEntity<RolModel> response = this.rolController.updateRol(rolModel, id);
		assertNotNull(response);
	}

	@Test
	public void deleteRolTest() {
		Integer id = 1;
		this.rolController.deleteRol(id);
		assertNotNull(id);
	}

	@Test
	public void getRolByIdTest() {
		Integer id = 1;
		RolModel rolModel = new RolModel();

		when(this.rolService.getRolById(id)).thenReturn(rolModel);
		ResponseEntity<RolModel> response = this.rolController.getRolById(id);
		assertNotNull(response);
	}
}
