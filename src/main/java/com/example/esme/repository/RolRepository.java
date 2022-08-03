package com.example.esme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esme.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {

	Optional<RolEntity> findByRoleName(String roleName);
}
