package com.example.esme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esme.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

	Optional<PersonaEntity> findByDocument(Integer document);
}
