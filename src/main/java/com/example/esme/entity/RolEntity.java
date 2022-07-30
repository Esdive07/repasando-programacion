package com.example.esme.entity;

import java.time.LocalDateTime;

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
	private LocalDateTime creationDate;
	@JsonProperty("fechaModificacion")
	private LocalDateTime modificationDate;

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
