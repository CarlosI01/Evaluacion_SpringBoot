package com.ista.springtboot.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "canciones")
public class Canciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_canciones")
	private Integer id_canciones;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "nombre_artista")
	private String nombre_artista;

	@Column(name = "album")
	private String album;

	@Column(name = "year")
	private String year;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "id_lista", referencedColumnName = "id_lista") private
	 * Lista_Reproducciones musica;
	 */

	
	
	@JsonIgnore
    @OneToMany(mappedBy = "id_lista")
    private List<Lista_Reproducciones> ListaS;

}
