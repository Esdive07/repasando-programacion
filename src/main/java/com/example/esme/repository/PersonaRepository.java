package com.example.esme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esme.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

}
