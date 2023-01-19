package com.ista.springtboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.springtboot.models.Canciones;
import com.ista.springtboot.repository.CancionesRepository;
@Service
public class Canciones_ServiceImpl extends GenericServiceImpl<Canciones, Integer> implements CancionesService {

	@Autowired
	CancionesRepository cancioR;
	
	@Override
	public CrudRepository<Canciones, Integer> getDao() {
		return cancioR;
	}

}
