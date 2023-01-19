package com.ista.springtboot.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
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
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "lista_reproducciones")
public class Lista_Reproducciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Integer id_lista;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "conjunto_canciones")
	private String conjunto_canciones;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_canciones", referencedColumnName = "id_canciones")
	private Canciones cancion;


}
