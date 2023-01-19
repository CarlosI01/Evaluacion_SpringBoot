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

import com.ista.springtboot.models.Lista_Reproducciones;
import com.ista.springtboot.service.ListaR_Service;

@RestController
@RequestMapping("/api")
public class ListaReproduccioon_Controller {

	@Autowired
	private ListaR_Service listaS;

	@GetMapping("/ListaReproduccion/requestAll")
	public ResponseEntity<List<Lista_Reproducciones>> getAllListaR() {

		return ResponseEntity.status(HttpStatus.OK).body(listaS.findByAll());

	}

	@GetMapping("/ListaReproduccion/searchById/{id}")
	public ResponseEntity<Lista_Reproducciones> ListaRById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(listaS.findById(id));
	}

	@PostMapping("/ListaReproduccion/save")
	public ResponseEntity<Lista_Reproducciones> saveListaR(@RequestBody Lista_Reproducciones lista) {
		return new ResponseEntity<>(listaS.save(lista), HttpStatus.CREATED);
	}

	@DeleteMapping("/ListaReproduccion/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteListaR(@PathVariable("id") Integer id) {
		listaS.delete(id);
	}

	@PutMapping("/ListaReproduccion/update/{id}")
	public ResponseEntity<Lista_Reproducciones> updateListaR(@RequestBody Lista_Reproducciones lista,
			@PathVariable("id") Integer id) {
		Lista_Reproducciones listaUP = listaS.findById(id);
		if (listaUP == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				listaUP.setDescripcion(lista.getDescripcion());
				listaUP.setConjunto_canciones(lista.getConjunto_canciones());

				return ResponseEntity.ok(listaS.save(listaUP));
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

}
