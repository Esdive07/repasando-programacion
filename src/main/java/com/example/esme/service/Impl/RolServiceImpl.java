package com.example.esme.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.esme.entity.RolEntity;
import com.example.esme.model.RolModel;
import com.example.esme.repository.RolRepository;
import com.example.esme.service.RolService;
import com.example.esme.util.MapperUtil;

@Service
public class RolServiceImpl implements RolService {

	private RolRepository rolRepository;
	private MapperUtil mapperUtil;

	public RolServiceImpl(RolRepository rolRepository, MapperUtil mapperUtil) {
		super();
		this.rolRepository = rolRepository;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public RolModel createRol(RolModel rolModel) {
		RolEntity rolEntity = this.mapperUtil.mapperObject(rolModel, RolEntity.class);
		RolEntity rolSave = this.rolRepository.save(rolEntity);
		return this.mapperUtil.mapperObject(rolSave, RolModel.class);
	}

	@Override
	public List<RolModel> getAllRol() {
		List<RolModel> listaModel = this.rolRepository.findAll().stream()
				.map(value -> this.mapperUtil.mapperObject(value, RolModel.class)).collect(Collectors.toList());
//		
//		List<PersonaModel> listaModel = this.rolRepository.findAll().stream()
//				.map(value -> {
//					
//					PersonaModel personaModel = new PersonaModel();
//					
//					personaModel.setNombre(value.getRoleName());
//					return personaModel;
//				}).collect(Collectors.toList());

		return listaModel;
	}

	@Override
	public RolModel updateRol(RolModel rolModel, Integer id) {
		rolModel.setId(id);
		RolEntity rolEntity = this.mapperUtil.mapperObject(rolModel, RolEntity.class);
		RolEntity rolsave = this.rolRepository.save(rolEntity);
		return this.mapperUtil.mapperObject(rolsave, RolModel.class);
	}

	@Override
	public void deleteRol(Integer id) {
		this.rolRepository.deleteById(id);

	}

	@Override
	public RolModel getRolById(Integer id) {
		RolEntity rolEntity = this.rolRepository.findById(id).get();
		return this.mapperUtil.mapperObject(rolEntity, RolModel.class);
	}

}