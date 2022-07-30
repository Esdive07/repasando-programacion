package com.example.esme.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class RolEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer idx;
	@JsonProperty("nombreRol")
	private String roleName;
	@JsonProperty("descripcion")
	private String description;
	@JsonProperty("fechaCreacion")
	private LocalDate creationDate;
	@JsonProperty("fechaModificacion")
	private LocalDate modificationDate;

	@PrePersist
	public void prePersist() {
		this.creationDate = LocalDate.now();
		this.modificationDate = LocalDate.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.modificationDate = LocalDate.now();
	}

}
