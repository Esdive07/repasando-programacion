package com.example.esme.service;

import java.util.List;

import com.example.esme.model.RolModel;

public interface RolService {

	public RolModel createRol(RolModel rolModel);

	public List<RolModel> getAllRol();

	public RolModel updateRol(RolModel rolModel, Integer id);

	public void deleteRol(Integer id);

	public RolModel getRolById(Integer id);


}
