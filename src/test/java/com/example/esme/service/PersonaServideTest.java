package com.example.esme.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.esme.entity.PersonaEntity;
import com.example.esme.model.PersonaModel;
import com.example.esme.repository.PersonaRepository;
import com.example.esme.service.impl.PersonaServiceImpl;
import com.example.esme.util.MapperUtil;

public class PersonaServideTest {

	private PersonaServiceImpl personaServiceImpl;
	@Mock
	private PersonaRepository personaRepository;
	@Mock
	private MapperUtil mapperUtil;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.personaServiceImpl = new PersonaServiceImpl(personaRepository, mapperUtil);
	}

	@Test
	public void createSuccessPersonTest() {
		PersonaModel personaModel = new PersonaModel();
		personaModel.setDocumento(123);
		PersonaEntity personaEntity = new PersonaEntity();

		Optional<PersonaEntity> personaEntityOptional = Optional.empty();

		when(this.personaRepository.findByDocument(personaModel.getDocumento())).thenReturn(personaEntityOptional);
		when(this.mapperUtil.mapperObject(personaModel, PersonaEntity.class)).thenReturn(personaEntity);
		when(this.personaRepository.save(personaEntity)).thenReturn(personaEntity);
		when(this.mapperUtil.mapperObject(personaEntity, PersonaModel.class)).thenReturn(personaModel);

		PersonaModel response = this.personaServiceImpl.createPerson(personaModel);
		assertNotNull(response);
	}

	@Test
	public void createNotSuccessPersonTest() {
		PersonaModel personaModel = new PersonaModel();
		personaModel.setDocumento(123);
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setDocument(123);

		Optional<PersonaEntity> personaEntityOptional = Optional.of(personaEntity);

		when(this.personaRepository.findByDocument(personaEntity.getDocument())).thenReturn(personaEntityOptional);
		when(this.mapperUtil.mapperObject(personaEntity, PersonaModel.class)).thenReturn(personaModel);

		PersonaModel response = this.personaServiceImpl.createPerson(personaModel);
		assertNotNull(response);
	}

	@Test
	public void getAllPersonTest() {

		PersonaEntity personaEntity = new PersonaEntity();
		List<PersonaEntity> personaEntities = new ArrayList<>();
		personaEntities.add(personaEntity);

		PersonaModel personaModel = new PersonaModel();
		personaModel.setId(1);
		personaModel.setDocumento(123);
		personaModel.setNombre("Esme");

		when(this.personaRepository.findAll()).thenReturn(personaEntities);
		when(this.mapperUtil.mapperObject(personaEntities, PersonaModel.class)).thenReturn(personaModel);

		List<PersonaModel> response = this.personaServiceImpl.getAllPerson();
		assertNotNull(response);
	}

	@Test
	public void updateSuccesPersonTest() {

		PersonaModel personaModel = new PersonaModel();
		personaModel.setId(1);
		personaModel.setDocumento(123);
		personaModel.setNombre("Esme");
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setIdx(1);
		personaEntity.setDocument(123);
		personaEntity.setName("Esme");
		Integer id = 1;

		Optional<PersonaEntity> personaentityOptional = Optional.of(personaEntity);

		when(this.personaRepository.findById(id)).thenReturn(personaentityOptional);
		when(this.mapperUtil.mapperObject(personaModel, PersonaEntity.class)).thenReturn(personaEntity);
		when(this.personaRepository.save(personaEntity)).thenReturn(personaEntity);
		when(this.mapperUtil.mapperObject(personaEntity, PersonaModel.class)).thenReturn(personaModel);

		PersonaModel response = this.personaServiceImpl.updatePerson(personaModel, id);
		assertNotNull(response);
	}

	@Test
	public void detelePersonTest() {
		Integer id = 1;
		this.personaServiceImpl.detelePerson(id);
		assertNotNull(id);
	}
}
