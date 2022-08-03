package com.example.esme.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.esme.model.RolModel;
import com.example.esme.service.RolService;

@RestController
@RequestMapping("roles")
public class RolController {

	private RolService rolService;

	public RolController(RolService rolService) {
		super();
		this.rolService = rolService;
	}

	@PostMapping
	public ResponseEntity<RolModel> createRol(@RequestBody RolModel rolModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.rolService.createRol(rolModel));
	}

	@GetMapping
	public ResponseEntity<List<RolModel>> getAllRol() {
		return ResponseEntity.ok(this.rolService.getAllRol());
	}

	@PutMapping("/{id}")
	public ResponseEntity<RolModel> updateRol(@RequestBody RolModel rolModel, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.rolService.updateRol(rolModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
		this.rolService.deleteRol(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RolModel> getRolById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.rolService.getRolById(id));
	}

}
