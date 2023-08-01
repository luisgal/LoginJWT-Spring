package com.example.login.service.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MUNICIPIO")
@Getter
@Setter
public class MunicipioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MUNICIPIO")
	Long idMunicipio;
	@Column(name = "NOMBRE")
	String nombre;
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	EstadoEntity estadoEntity;
}
