package com.example.esme.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.esme.model.PersonaModel;
import com.example.esme.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	private PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@PostMapping
	public ResponseEntity<PersonaModel> createPersona(@RequestBody PersonaModel personaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.createPerson(personaModel));
	}

	@GetMapping
	public ResponseEntity<List<PersonaModel>> getAllPerson() {
		return ResponseEntity.ok(this.personaService.getAllPerson());
	}
}
