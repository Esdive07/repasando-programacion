package com.example.esme.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer idx;
	@JsonProperty("documento")
	private Integer document;
	@JsonProperty("nombre")
	private String name;
	@JsonProperty("apellidos")
	private String lastName;
	@JsonProperty("fechaNacimiento")
	private LocalDate birthday;
	@JsonProperty("fechaCreacion")
	private LocalDateTime creationDate;
	@JsonProperty("fechaModificacion")
	private LocalDateTime modificationDate;

	@OneToOne
	@JoinColumn(name = "rol_id")
	@JsonProperty("rol")
	private RolEntity rolEntity;

	@PrePersist
	public void prePersist() {
		this.creationDate = LocalDateTime.now();
		this.modificationDate = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.modificationDate = LocalDateTime.now();
	}
}
