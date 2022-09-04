package com.example.esme.service.impl;

import java.util.List;
import java.util.Optional;
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
		return this.getByRolName(rolModel.getNombreRol()).orElseGet(() -> {

			RolEntity rolEntity = this.mapperUtil.mapperObject(rolModel, RolEntity.class);
			RolEntity saveRol = this.rolRepository.save(rolEntity);
			return this.mapperUtil.mapperObject(saveRol, RolModel.class);
		});
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
		RolModel rolModelSaved = this.getRolById(id);
		rolModelSaved.setNombreRol(rolModel.getNombreRol());
		rolModelSaved.setDescripcion(rolModel.getDescripcion());

		RolEntity rolEntity = this.mapperUtil.mapperObject(rolModelSaved, RolEntity.class);
		RolEntity saveRol = this.rolRepository.save(rolEntity);
		return this.mapperUtil.mapperObject(saveRol, RolModel.class);
	}

	@Override
	public void deleteRol(Integer id) {
		this.rolRepository.deleteById(id);

	}

	@Override
	public RolModel getRolById(Integer id) {
		RolEntity rolEntity = this.rolRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id no valido,no existe"));
		return this.mapperUtil.mapperObject(rolEntity, RolModel.class);
	}

	private Optional<RolModel> getByRolName(String rolName) {
		Optional<RolEntity> rolEntity = this.rolRepository.findByRoleName(rolName);

		return rolEntity.map(value -> this.mapperUtil.mapperObject(value, RolModel.class));
	}

}
