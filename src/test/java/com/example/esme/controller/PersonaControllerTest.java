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

import com.example.esme.model.PersonaModel;
import com.example.esme.service.PersonaService;

public class PersonaControllerTest {
	private PersonaController personaController;
	@Mock
	private PersonaService personaService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.personaController = new PersonaController(personaService);
	}

	@Test
	public void createPersonaTest() {
		PersonaModel personaModel = new PersonaModel();
		when(this.personaService.createPerson(personaModel)).thenReturn(personaModel);
		ResponseEntity<PersonaModel> response = this.personaController.createPersona(personaModel);
		assertNotNull(response);
	}

	@Test
	public void getAllPersonTest() {
		List<PersonaModel> listaPersonaModels = new ArrayList<>();
		when(this.personaService.getAllPerson()).thenReturn(listaPersonaModels);
		ResponseEntity<List<PersonaModel>> response = this.personaController.getAllPerson();
		assertNotNull(response);
	}

	@Test
	public void updatePersonTest() {
		PersonaModel personaModel = new PersonaModel();
		Integer id = 1;

		when(this.personaService.updatePerson(personaModel, id)).thenReturn(personaModel);
		ResponseEntity<PersonaModel> response = this.personaController.updatePerson(personaModel, id);
		assertNotNull(response);
	}

	@Test
	public void detelePersonTest() {
		Integer id = 1;
		this.personaController.deletePerson(id);
		assertNotNull(id);
	}

	@Test
	public void getPersonByIdTest() {
		Integer id = 1;
		PersonaModel personaModel = new PersonaModel();
		when(this.personaService.getPersonById(id)).thenReturn(personaModel);
		ResponseEntity<PersonaModel> response = this.personaController.getPersonById(id);
		assertNotNull(response);
	}

}
