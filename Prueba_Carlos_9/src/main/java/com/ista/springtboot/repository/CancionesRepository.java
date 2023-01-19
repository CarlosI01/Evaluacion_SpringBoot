package com.ista.springtboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.springtboot.models.Canciones;
import com.ista.springtboot.models.Lista_Reproducciones;

public interface CancionesRepository extends JpaRepository<Canciones, Integer> {

}
