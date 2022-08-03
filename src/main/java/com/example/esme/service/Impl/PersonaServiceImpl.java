package com.example.esme.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.esme.entity.PersonaEntity;
import com.example.esme.model.PersonaModel;
import com.example.esme.repository.PersonaRepository;
import com.example.esme.service.PersonaService;
import com.example.esme.util.MapperUtil;

@Service
public class PersonaServiceImpl implements PersonaService {

	private PersonaRepository personaRepository;
	private MapperUtil mapperUtil;

	public PersonaServiceImpl(PersonaRepository personaRepository, MapperUtil mapperUtil) {
		super();
		this.personaRepository = personaRepository;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public PersonaModel createPerson(PersonaModel personaModel) {
		PersonaEntity personaEntity = this.mapperUtil.mapperObject(personaModel, PersonaEntity.class);
		PersonaEntity savePerson = this.personaRepository.save(personaEntity);
		return this.mapperUtil.mapperObject(savePerson, PersonaModel.class);
	}

	@Override
	public List<PersonaModel> getAllPerson() {
		List<PersonaModel> listaPersonas = this.personaRepository.findAll().stream()
				.map(value -> this.mapperUtil.mapperObject(value, PersonaModel.class)).collect(Collectors.toList());
		return listaPersonas;
	}

	@Override
	public PersonaModel updatePerson(PersonaModel personaModel, Integer id) {

		PersonaModel personaSaved = this.getPersonById(id);
		personaSaved.setNombre(personaModel.getNombre());
		personaSaved.setApellidos(personaModel.getApellidos());
		personaSaved.setDocumento(personaModel.getDocumento());
		personaSaved.setFechaNacimiento(personaModel.getFechaNacimiento());
		personaSaved.setRol(personaModel.getRol());

		PersonaEntity personaEntity = this.mapperUtil.mapperObject(personaSaved, PersonaEntity.class);
		PersonaEntity SavePersona = this.personaRepository.save(personaEntity);
		return this.mapperUtil.mapperObject(SavePersona, PersonaModel.class);
	}

	@Override
	public void detelePerson(Integer id) {
		this.personaRepository.deleteById(id);
	}

	@Override
	public PersonaModel getPersonById(Integer id) {
		PersonaEntity personaEntity = this.personaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No valido"));
		return this.mapperUtil.mapperObject(personaEntity, PersonaModel.class);
	}

}
