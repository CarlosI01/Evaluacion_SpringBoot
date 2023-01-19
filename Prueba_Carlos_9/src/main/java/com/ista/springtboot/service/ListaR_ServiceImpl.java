package com.ista.springtboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.springtboot.models.Lista_Reproducciones;
import com.ista.springtboot.repository.Lista_reproRespository;
@Service
public class ListaR_ServiceImpl extends GenericServiceImpl<Lista_Reproducciones, Integer> implements ListaR_Service {

	@Autowired
	Lista_reproRespository listaR;
	@Override
	public CrudRepository<Lista_Reproducciones, Integer> getDao() {
		return listaR;
	}

}
