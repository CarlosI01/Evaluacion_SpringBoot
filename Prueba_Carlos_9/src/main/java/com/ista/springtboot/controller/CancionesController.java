package com.ista.springtboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springtboot.models.Canciones;
import com.ista.springtboot.models.Lista_Reproducciones;
import com.ista.springtboot.service.CancionesService;
import com.ista.springtboot.service.ListaR_Service;
@RestController
@RequestMapping("/api")
public class CancionesController {

	@Autowired
	private CancionesService cancionS;

	@GetMapping("/Canciones/requestAll")
	public ResponseEntity<List<Canciones>> getAllListaR() {

		return ResponseEntity.status(HttpStatus.OK).body(cancionS.findByAll());

	}

	@GetMapping("/Canciones/searchById/{id}")
	public ResponseEntity<Canciones> ListaRById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(cancionS.findById(id));
	}

	@PostMapping("/Canciones/save")
	public ResponseEntity<Canciones> saveListaR(@RequestBody Canciones cancion) {
		return new ResponseEntity<>(cancionS.save(cancion), HttpStatus.CREATED);
	}

	@DeleteMapping("/Canciones/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteListaR(@PathVariable("id") Integer id) {
		cancionS.delete(id);
	}

	@PutMapping("/Canciones/update/{id}")
	public ResponseEntity<Canciones> updateListaR(@RequestBody Canciones cancion,
			@PathVariable("id") Integer id) {
		Canciones cancionUP = cancionS.findById(id);
		if (cancionUP == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				
				cancionUP.setNombre_artista(cancion.getNombre_artista());
				cancionUP.setTitulo(cancion.getTitulo());
				cancionUP.setAlbum(cancion.getAlbum());
				cancionUP.setYear(cancion.getYear());		
				return ResponseEntity.ok(cancionS.save(cancionUP));
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

}
