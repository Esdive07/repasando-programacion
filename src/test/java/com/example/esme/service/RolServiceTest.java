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

import com.example.esme.entity.RolEntity;
import com.example.esme.model.RolModel;
import com.example.esme.repository.RolRepository;
import com.example.esme.service.impl.RolServiceImpl;
import com.example.esme.util.MapperUtil;

public class RolServiceTest {

	private RolServiceImpl rolserServiceImpl;
	@Mock
	private RolRepository rolRepository;
	@Mock
	private MapperUtil mapperUtil;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.rolserServiceImpl = new RolServiceImpl(rolRepository, mapperUtil);
	}

	@Test
	public void createRolSuccessfulTest() {
		String rolName = "Admin";
		RolModel rolModel = new RolModel();
		rolModel.setNombreRol(rolName);

		RolEntity rolEntity = new RolEntity();
		Optional<RolEntity> rolEntityOptional = Optional.empty();

		when(this.rolRepository.findByRoleName(rolName)).thenReturn(rolEntityOptional);

		when(this.mapperUtil.mapperObject(rolModel, RolEntity.class)).thenReturn(rolEntity);
		when(this.rolRepository.save(rolEntity)).thenReturn(rolEntity);
		when(this.mapperUtil.mapperObject(rolEntity, RolModel.class)).thenReturn(rolModel);

		RolModel response = this.rolserServiceImpl.createRol(rolModel);
		assertNotNull(response);
	}

	@Test
	public void createRolNotSuccessfulTest() {
		String rolName = "Admin";
		RolModel rolModel = new RolModel();
		rolModel.setNombreRol(rolName);
		RolEntity rolEntity = new RolEntity();
		rolEntity.setRoleName(rolName);

		Optional<RolEntity> rolEntityOptional = Optional.of(rolEntity);

		when(this.rolRepository.findByRoleName(rolName)).thenReturn(rolEntityOptional);
		when(this.mapperUtil.mapperObject(rolEntity, RolModel.class)).thenReturn(rolModel);

		RolModel response = this.rolserServiceImpl.createRol(rolModel);
		assertNotNull(response);
	}

	@Test
	public void getAllRolTest() {
		RolEntity rolEntity = new RolEntity();

		RolModel rolModel = new RolModel();
		rolModel.setId(1);
		rolModel.setNombreRol("admin");
		rolModel.setDescripcion("todas las opciones");

		List<RolEntity> rolEntities = new ArrayList<>();
		rolEntities.add(rolEntity);

		when(this.rolRepository.findAll()).thenReturn(rolEntities);
		when(this.mapperUtil.mapperObject(rolEntities, RolModel.class)).thenReturn(rolModel);

		List<RolModel> response = this.rolserServiceImpl.getAllRol();
		assertNotNull(response);
	}

	@Test
	public void updateRolTestOk() {

		RolModel rolModel = new RolModel();
		RolEntity rolEntity = new RolEntity();
		Integer id = 1;

		Optional<RolEntity> rolentityOptional = Optional.of(rolEntity);

		when(this.rolRepository.findById(id)).thenReturn(rolentityOptional);

		when(this.mapperUtil.mapperObject(rolModel, RolEntity.class)).thenReturn(rolEntity);
		when(this.rolRepository.save(rolEntity)).thenReturn(rolEntity);
		when(this.mapperUtil.mapperObject(rolEntity, RolModel.class)).thenReturn(rolModel);
		RolModel response = this.rolserServiceImpl.updateRol(rolModel, id);
		assertNotNull(response);
	}

	@Test
	public void deleteRolTest() {
		Integer id = 1;

		this.rolserServiceImpl.deleteRol(id);
		assertNotNull(id);
	}
}
