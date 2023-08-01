package com.example.login.service.jpa.entities;

import javax.persistence.CascadeType;
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
@Table(name = "USUARIO")
@Getter
@Setter
public class UsuarioEntitty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	Long idUsuario;
	@Column(name = "NOMBRE")
	String nombre;
	@Column(name = "EMAIL")
	String email;
	@Column(name = "PASSWORD")
	String password;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CP")
	CodPosEntity cp;
}
