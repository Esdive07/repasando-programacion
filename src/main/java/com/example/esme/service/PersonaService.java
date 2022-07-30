package com.example.esme.service;

import java.util.List;

import com.example.esme.model.PersonaModel;

public interface PersonaService {

	public PersonaModel createPerson(PersonaModel personaModel);

	public List<PersonaModel> getAllPerson();

	public PersonaModel updatePerson(PersonaModel personaModel, Integer id);

	public void detelePerson(Integer id);

	public PersonaModel getPersonById(Integer id);

}
