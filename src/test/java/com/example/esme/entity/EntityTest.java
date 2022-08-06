package com.example.esme.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTest {

	private RolEntity rolEntity;
	private PersonaEntity personaEntity;

	@BeforeEach
	public void init() {
		this.rolEntity = new RolEntity();
		this.personaEntity = new PersonaEntity();
	}

	@Test
	public void rolTest() {
		Integer idx = 1;
		String roleName = "Administrador";
		String description = "todas las opciones";
		LocalDateTime creationDate = LocalDateTime.now();
		LocalDateTime modificationDate = LocalDateTime.now();

		this.rolEntity.setIdx(idx);
		this.rolEntity.setRoleName(roleName);
		this.rolEntity.setDescription(description);
		this.rolEntity.setCreationDate(creationDate);
		this.rolEntity.setModificationDate(modificationDate);

		assertEquals(idx, this.rolEntity.getIdx());
		assertEquals(roleName, this.rolEntity.getRoleName());
		assertEquals(description, this.rolEntity.getDescription());
		assertEquals(creationDate, this.rolEntity.getCreationDate());
		assertEquals(modificationDate, this.rolEntity.getModificationDate());

		creationDate = null;
		this.rolEntity.setCreationDate(creationDate);
		this.rolEntity.prePersist();
		assertNotNull(this.rolEntity.getCreationDate());

		this.rolEntity.setModificationDate(null);
		this.rolEntity.preUpdate();
		assertNotNull(this.rolEntity.getModificationDate());

	}

	@Test
	public void personTest() {
		Integer idx = 1;
		Integer document = 123;
		String name = "Esme";
		String lastName = "Diaz";
		LocalDate birthday = LocalDate.parse("1993-07-10");
		LocalDateTime creationDate = LocalDateTime.now();
		LocalDateTime modificationDate = LocalDateTime.now();

		RolEntity rolEntity = new RolEntity();

		this.personaEntity.setIdx(idx);
		this.personaEntity.setDocument(document);
		this.personaEntity.setName(name);
		this.personaEntity.setLastName(lastName);
		this.personaEntity.setBirthday(birthday);
		this.personaEntity.setCreationDate(creationDate);
		this.personaEntity.setModificationDate(modificationDate);
		this.personaEntity.setRolEntity(rolEntity);

		assertEquals(idx, this.personaEntity.getIdx());
		assertEquals(document, this.personaEntity.getDocument());
		assertEquals(name, this.personaEntity.getName());
		assertEquals(lastName, this.personaEntity.getLastName());
		assertEquals(birthday, this.personaEntity.getBirthday());
		assertEquals(creationDate, this.personaEntity.getCreationDate());
		assertEquals(modificationDate, this.personaEntity.getModificationDate());
		assertNotNull(this.personaEntity.getRolEntity());

		this.personaEntity.setCreationDate(null);
		this.personaEntity.prePersist();
		assertNotNull(this.personaEntity.getCreationDate());

		this.personaEntity.setModificationDate(null);
		this.personaEntity.preUpdate();
		assertNotNull(this.personaEntity.getModificationDate());
	}
}
